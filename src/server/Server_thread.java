package server;

import java.net.*;
import java.io.*;

public class Server_thread extends Thread {
    private Socket socket = null;

    public Server_thread(Socket socket) {
        super("Multi-Thread");
        this.socket = socket;
    }
    
    public void run() {

        try (
        	OutputStream os = socket.getOutputStream();
        	ObjectOutputStream oos = new ObjectOutputStream(os);
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        		
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        ) {
        	
        	Questionlist ql = new Questionlist(); // Konstruktor für die Übergabe der Fragenliste
        	ql.fragenausdateilesen(); // Fragenliste wird erstellt
        	System.out.println("Fragen gelesen erfolgt");
        	oos.writeObject(ql.allefragen()); // Fragen werden an OutputStream übergeben und zum Client gesendet
        	socket.close();
        	} catch (IOException e) {
        		System.out.println("Fehler mit dem Port oder beim Verbinden.");
        		System.out.println(e.getMessage());
        	}
    }
}
        	
            /*String inputLine, outputLine;
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye"))
                    break;
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace(); */

/*	        try ( 
ServerSocket serversocket = new ServerSocket(portNumber); // Socket wird erstellt mit obiger Portnummer, Exception wenn Port belegt.
Socket clientsocket = serversocket.accept(); // Server wartet auf Verbindung und bei Erfolg wird dem Client ein Socket gegeben

OutputStream os = clientsocket.getOutputStream(); // Stream von Bytes können an ClientSocket übergeben und geschrieben werden
ObjectOutputStream oos = new ObjectOutputStream(os);  // Konstruktor für einen ObjectOutputStream (übergibt ein Object an den Ouuput)
	
	            BufferedReader in = new BufferedReader(
    new InputStreamReader(clientsocket.getInputStream())); // Es wird auf einen Byte-Stream vom Client gewartet (noch nicht implementiert)
) {        

Questionlist ql = new Questionlist(); // Konstruktor für die Übergabe der Fragenliste
ql.fragenausdateilesen(); // Fragenliste wird erstellt
System.out.println("Fragen gelesen erfolgt");
oos.writeObject(ql.allefragen()); // Fragen werden an OutputStream übergeben und zum Client gesendet
} catch (IOException e) {
System.out.println("Fehler mit dem Port "
    + portNumber + " oder beim Verbinden.");
System.out.println(e.getMessage());
}
} */