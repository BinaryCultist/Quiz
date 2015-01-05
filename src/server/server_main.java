package server;

import java.net.*;
import java.io.*;

public class server_main {
    public static void main(String[] args) throws IOException {
        
        int portNumber = 4444;  // Integer.parseInt(args[0]);

        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            OutputStream os = clientSocket.getOutputStream();
        	ObjectOutputStream oos = new ObjectOutputStream(os);
        		
        		            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {        

            server_questionlist ql = new server_questionlist();
            ql.fragenausdateilesen();
            System.out.println("Fragen gelesen erfolgt");
            oos.writeObject(ql.allefragen());
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection.");
            System.out.println(e.getMessage());
        }
    }
}