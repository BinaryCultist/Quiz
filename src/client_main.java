import java.io.*;
import java.net.*;

public class client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
       /* if (args.length != 2) {
            System.err.println(
                "Usage: java client_main <host name> <port number>");
            System.exit(1);
        } */

        String hostName = "127.0.0.1"; //args[0];
        int portNumber = 4444; // Integer.parseInt(args[1]);

        try (
            Socket kkSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
        		
        	InputStream is = kkSocket.getInputStream();
        		ObjectInputStream ois = new ObjectInputStream(is);
        		
        		
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;
            Object o;
            while (( o = ois.readObject()) != null) {
            	System.out.println(o.getClass().getSimpleName());
            	if (o instanceof Object[]) {
            		for (Object obj : (Object[])o) {
            			Frage frage = (Frage) obj;
            			System.out.println("Frage 1: " + frage.Frage + " Antwort 1: " + frage.Antwort1 + 
							" Antwort 2: " + frage.Antwort2 + " Antwort 3: " + frage.Antwort3 + 
							" Antwort 4: " + frage.Antwort4 + " Richtige Antwort: " + frage.RichtigeAntwort);					
					} 
            	}      	
            	/* if (o instanceof String) {
					 fromServer = (String) o;
					 System.out.println("Server: " + fromServer);
		                if (fromServer.equals("Bye."))
		                    break;
				} */
                
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
            System.out.println("Bla");
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        }
    }
}