package server;

//import gui.Main;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

import functions.Befehle;
import functions.Highscore_eintrag;

public class Threads extends Thread {
    private Socket socket = null;
    
    private static ArrayList<Highscore_eintrag> Highscore = new ArrayList<Highscore_eintrag>();

    public Threads(Socket socket) {
        super("Multi-Thread");
        this.socket = socket;
    }
    
    public void run() {
    	

    	
    	
    	/*String path = Threads.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decodedPath;
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
			System.out.println(decodedPath);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} */
    	
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
            	if (input.getClass().equals(Befehle.class)){
            		ProcessOrder(out, in, (Befehle)input);
            	}
            }
            in.close();
            out.close();
            socket.close();
            System.exit(0);
        	
        	} catch (IOException e) {
        		e.printStackTrace();
        	} catch (ClassNotFoundException e) {    			
    			e.printStackTrace();
    		}
    }
    
	private void ProcessOrder(ObjectOutputStream out, ObjectInputStream in, Befehle befehl) throws IOException {
		System.out.println("Server - Process Order: " + befehl.toString());
		switch (befehl) {
		case Login:
			try {
				@SuppressWarnings("unused")
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
			break;
		default:
			break;
		}
	}
}