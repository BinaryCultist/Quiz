package function;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Connectionmgr
{
	private String IPAddr;
	private String name = null;
	private InetAddress address = null;
	private byte[] ip = new byte[0];
	
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
			System.out.println(s.getSoLinger());            // –1
			System.out.println(s.getTcpNoDelay());          // false
			System.out.println(s.getTrafficClass());        // 0
			 */
			ObjectOutputStream os;
			
			os = new ObjectOutputStream(s.getOutputStream());
			os.writeObject(new String("Hallo Server"));
			os.flush();
			os.close();
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