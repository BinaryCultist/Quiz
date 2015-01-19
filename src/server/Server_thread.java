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