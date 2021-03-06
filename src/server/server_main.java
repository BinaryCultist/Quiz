package server;

import java.net.*;
import java.io.*;

public class server_main {
    public static void main(String[] args) throws IOException {
        
        int portNumber = 4444; // Portnummer wo der Server auf Verbindung wartet
        
        while (true) { // Server läuft konstant

	        try ( 
	            ServerSocket serverSocket = new ServerSocket(portNumber); // Socket wird erstellt mit obiger Portnummer, Exception wenn Port belegt.
	            Socket clientSocket = serverSocket.accept(); // Server wartet auf Verbindung und bei Erfolg wird dem Client ein Socket gegeben
	            OutputStream os = clientSocket.getOutputStream(); // Stream von Bytes können an ClientSocket übergeben und geschrieben werden
	        	ObjectOutputStream oos = new ObjectOutputStream(os);  // Konstruktor für einen ObjectOutputStream (übergibt ein Object an den Ouuput)
	        		
	        		            BufferedReader in = new BufferedReader(
	                new InputStreamReader(clientSocket.getInputStream())); // Es wird auf einen Byte-Stream vom Client gewartet (noch nicht implementiert)
	        ) {        
	
	            server_questionlist ql = new server_questionlist(); // Konstruktor für die Übergabe der Fragenliste
	            ql.fragenausdateilesen(); // Fragenliste wird erstellt
	            System.out.println("Fragen gelesen erfolgt");
	            oos.writeObject(ql.allefragen()); // Fragen werden an OutputStream übergeben und zum Client gesendet
	        } catch (IOException e) {
	            System.out.println("Fehler mit dem Port "
	                + portNumber + " oder beim Verbinden.");
	            System.out.println(e.getMessage());
	        }
        }
    }
}