import java.io.*;
import java.net.*;

public class client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java client_main <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

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
            	if (o instanceof String[]) {
					 String[] fragen = (String[]) o;
					 System.out.println("Frage 1: " + fragen[0] + " Antwort 1: " + fragen[1] + 
								" Antwort 2: " + fragen[2] + " Antwort 3: " + fragen[3] + 
								" Antwort 4: " + fragen[4] + " Richtige Antwort: " + fragen[5]);
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