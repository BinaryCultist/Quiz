import java.net.*;
import java.io.*;

public class server_main {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java server_main <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            OutputStream os = clientSocket.getOutputStream();
        	ObjectOutputStream oos = new ObjectOutputStream(os);
        		
        		            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {        

            server_questionlist ql = new server_questionlist();
            ql.run();            
            oos.writeObject(ql.fragen());            
            oos.writeObject("Bye.");
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection.");
            System.out.println(e.getMessage());
        }
    }
}