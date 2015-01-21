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
        	/*String anfrage = in.readLine();
        	System.out.println(in.readLine());
        	if(anfrage.equals("Login")){
        		String nutzer = in.readLine();
        		String pw =  in.readLine();
        		System.out.println(nutzer);
        		System.out.println(pw);
        		if (nutzer.equals("Test") && pw.equals("Test1234")){
        			oos.writeObject(true);
        		} else {
        			oos.writeObject(false);
        		}
        		
        	}else if(anfrage.equals("Fragen")){*/
        		Questionlist ql = new Questionlist(); // Konstruktor für die Übergabe der Fragenliste
            	ql.fragenausdateilesen(); // Fragenliste wird erstellt
            	System.out.println("Fragen gelesen erfolgt");
            	oos.writeObject(ql.allefragen()); // Fragen werden an OutputStream übergeben und zum Client gesendet
            	oos.flush();
            	oos.reset();
            	
        	//}        	
        	       	
        	socket.close();
        	} catch (IOException e) {
        		System.out.println("Fehler mit dem Port oder beim Verbinden.");
        		System.out.println(e.getMessage());
        	}
    }
}