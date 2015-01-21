package server;

import java.net.*;
import java.io.*;

public class Server_main {
    public static void main(String[] args) throws IOException {
        
        int portNumber = 4444; // Portnummer wo der Server auf Verbindung wartet
        boolean listening = true;
        
        try (ServerSocket serversocket = new ServerSocket(portNumber)) { 
            while (listening) {
	            new Server_thread(serversocket.accept()).start();
	            System.out.println("Neuer Server Thread aufgemacht.");
	        }
	    } catch (IOException e) {
            System.err.println("Fehler mit Port " + portNumber);
            System.exit(-1);
        }
    }
}