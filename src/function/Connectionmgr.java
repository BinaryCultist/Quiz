package function;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connectionmgr
{
	private String IPAddr;
	private String name = null;
	private InetAddress address = null;
	private byte[] ip = new byte[0];
	
	private static int richtig = 5; // Wert 5: Zwischenzustand bis neue Frage angefordert wurde
	private static String[] fragen;
	
	public void clear() // Aufzurufen, sobald User die Frage erhalten hat
	{
		fragen = null;
		richtig = 5;
	}
	
	public String[] getFragen() // Aufzurufen in der GUI
	{
		return fragen;
	}
	
	public boolean antwortRichtig(int antwortUser) // �berpr�fung der User-Antwort
	{
		return antwortUser == richtig;
	}
	
	public void connectionless()
	{		
		try
		{
			address = InetAddress.getByName(IPAddr);
			ip = address.getAddress();
			name = address.getHostName();
		}
    
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	ip = address.getAddress();
    	IPAddr = getIpAddress(ip);
		System.out.println("Server Address: " + IPAddr);
		System.out.println("Server Name: " + name);
		
		//Verbindungsaufbau
		try
		{
			Socket s = new Socket(IPAddr, 54683);
			/*
			System.out.println(s.getKeepAlive());           // false
			System.out.println(s.getLocalAddress());        // /192.168.2.138
			System.out.println(s.getLocalPort());           // 1456
			System.out.println(s.getLocalSocketAddress());  // /192.168.2.138:1202
			System.out.println(s.getOOBInline());           // false
			System.out.println(s.getPort());                // 80
			System.out.println(s.getRemoteSocketAddress()); // www.tutego.com/82.96.100.30:80
			System.out.println(s.getReuseAddress());        // false
			System.out.println(s.getReceiveBufferSize());   // 8192
			System.out.println(s.getSendBufferSize());      // 8192
			System.out.println(s.getSoLinger());            // �1
			System.out.println(s.getTcpNoDelay());          // false
			System.out.println(s.getTrafficClass());        // 0
			 */
			
			PrintWriter toServer = new PrintWriter(s.getOutputStream());
    		ObjectInputStream ois = new ObjectInputStream(s.getInputStream()); // Quizdaten und weitere Kommunikation vom Server
    		
    		//BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

    		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    		String fromServer;
    		String fromUser;
    		Object o;
    		while (( o = ois.readObject()) != null) {	// Solange Server Daten sendet
    			System.out.println(o.getClass().getSimpleName());
    			if (o instanceof String[]) {
    				fragen = (String[]) o;
    				richtig = Integer.parseInt(fragen[5]);
    				System.out.println("Frage 1: " + fragen[0] + " Antwort 1: " + fragen[1] + 
    						" Antwort 2: " + fragen[2] + " Antwort 3: " + fragen[3] + 
    						" Antwort 4: " + fragen[4] + " Richtige Antwort: " + fragen[5]);

    	    		toServer.println("Success."); // R�ckmeldung an Server
    			}
    			if (o instanceof String) {
    				fromServer = (String) o;
    				System.out.println("Server: " + fromServer);
    				if (fromServer.equals("Bye."))
    					break;
    			}  

    			fromUser = stdIn.readLine();
    			if (fromUser != null) {
    				System.out.println("Client: " + fromUser);
    				toServer.println(fromUser);
    			}
    		}
    		System.out.println("Done.");

    		toServer.flush();
    		toServer.close();
    		s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}	

	public String getIpAddress(byte[] rawBytes)
    {
        int i = 4;
        String ipAddress = "";
        for (byte raw : rawBytes)
        {
            ipAddress = ipAddress + (raw & 0xFF);
            if (--i > 0)
            {
                ipAddress += ".";
            }
        }
        return ipAddress;
    }
	
	public Connectionmgr(String IPAddr)
	{
		this.IPAddr = IPAddr;
	}
}