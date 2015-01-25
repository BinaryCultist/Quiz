package server;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Server_thread extends Thread {
    private Socket socket = null;
    
    //private Integer Summe = 0;
    private static ArrayList<Highscore_eintrag> Highscore = new ArrayList<Highscore_eintrag>();

    public Server_thread(Socket socket) {
        super("Multi-Thread");
        this.socket = socket;
    }
    
    public void run() {  	
    	
    	try (
        	//OutputStream os = socket.getOutputStream();
        	//ObjectOutputStream oos = new ObjectOutputStream(os);
            //PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        		
            //BufferedReader in = new BufferedReader(
                //new InputStreamReader(socket.getInputStream()));
        ) {
    		Object input = null;	
            while ((input = in.readObject()) != null) {
            	if (input.getClass().equals(Server_befehl.class)){
            		ProcessOrder(out, in, (Server_befehl)input);
            	}
            }
            socket.close();
        	
        		/*Questionlist ql = new Questionlist(); // Konstruktor für die Übergabe der Fragenliste
            	ql.fragenausdateilesen(); // Fragenliste wird erstellt
            	System.out.println("Fragen gelesen erfolgt");
            	oos.writeObject(ql.allefragen()); // Fragen werden an OutputStream übergeben und zum Client gesendet
            	oos.flush();
            	oos.reset();*/
        	       	
        	
        	} catch (IOException e) {
        		e.printStackTrace();
        	} catch (ClassNotFoundException e) {    			
    			e.printStackTrace();
    		}
    }
    
	private void ProcessOrder(ObjectOutputStream out, ObjectInputStream in, Server_befehl befehl) throws IOException {
		System.out.println("Server - Process Order: " + befehl.toString());
		switch (befehl) {
		case Login:
			try {
				String user = (String)in.readObject();
				String pass = (String)in.readObject();
				Boolean isLoginOk = false;
				if (pass.equals("test")) isLoginOk = true;
				out.writeObject(isLoginOk);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			break;
			//outStream.writeObject(new String("Antwort auf Order 1"));
			//break;
		case Fragenholen:
			/*ArrayList<String> arr = new ArrayList<String>();
			arr.add("eins"); arr.add("zwei"); arr.add("drei");
			outStream.writeObject(arr);*/
			Questionlist ql = new Questionlist(); // Konstruktor für die Übergabe der Fragenliste
        	ql.fragenausdateilesen(); // Fragenliste wird erstellt
        	System.out.println("Fragen gelesen erfolgt");
        	out.writeObject(ql.allefragen());
			break;
		case Highscore_speichern:
			try {
				Highscore_eintrag param = (Highscore_eintrag)in.readObject();
				//outStream.writeObject(new String(param));
				Highscore.add(param);
				Collections.sort(Highscore);
				for (Highscore_eintrag e : Highscore) {
					System.out.println(e.Nutzername + ": " + e.Punkte.toString());
					
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			break;
		case Highscore_laden:
			
				out.writeObject(Highscore);
				out.flush();
				out.reset();
			/*
			try {
				Integer zahl = (Integer)in.readObject();
				Summe = Summe + zahl;
				outStream.writeObject(Summe); */					
			break;
		default:
			break;
		}
	}
}