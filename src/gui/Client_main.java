package gui;

import java.io.*;
import java.net.*;
import server.*;

public class Client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {    	
        
        String hostName = "127.0.0.1"; // Server läuft auf Localhost, ansonsten Server-IP
        int portNumber = 4444; // Verbindungs-Port auf dem Server

        try (
            Socket serversocket = new Socket(hostName, portNumber); // Öffnen eines Sockets zum Server
            PrintWriter out = new PrintWriter(serversocket.getOutputStream(), true);
        		
        	InputStream is = serversocket.getInputStream();
        	ObjectInputStream ois = new ObjectInputStream(is);        		
        		
            BufferedReader in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
        	BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
        	
            Object o;
            while (( o = ois.readObject()) != null) {
            	if (o instanceof Object[]) {
            		int i = 0;
            		for (Object obj : (Object[])o) {
            			Frage frage = (Frage) obj;
            			i++;
            			System.out.println("Frage " + i + ": " + frage.Frage + " Antwort 1: " + frage.Antwort1 + 
						" Antwort 2: " + frage.Antwort2 + " Antwort 3: " + frage.Antwort3 + 
						" Antwort 4: " + frage.Antwort4 + " Richtige Antwort: " + frage.RichtigeAntwort);					
					} 
            	}
            	
            	stdIn.readLine();
            	System.out.println("Exit");
            	System.exit(0);         	
            }
            
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