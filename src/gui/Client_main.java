package gui;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import server.Frage;
import server.Highscore_eintrag;
import server.Server_befehl;

import javax.swing.*;

public class Client_main {
	
	private static Socket serversocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static BufferedReader stdIn;
	private static String hostName;
	private static int portNumber;
	
	public static Panel_GUI GUI;	
	public static ArrayList<Frage> Allefragen = new ArrayList<Frage>();
	public static ArrayList<Highscore_eintrag> Highscore = new ArrayList<Highscore_eintrag>();
	public static String AktNutzername;
	
    public static void main(String[] args) throws IOException, ClassNotFoundException {    	
        
        hostName = "127.0.0.1"; // Server läuft auf Localhost, ansonsten Server-IP
        portNumber = 4444; // Verbindungs-Port auf dem Server

        //try (        		
        serversocket = new Socket(hostName, portNumber); // Öffnen eines Sockets zum Server
        out = new ObjectOutputStream(serversocket.getOutputStream());
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        in = new ObjectInputStream(serversocket.getInputStream());
        
        //InputStream is = serversocket.getInputStream();          
        //ObjectInputStream ois = new ObjectInputStream(is);
        //)        
        //out = new PrintWriter(serversocket.getOutputStream(), true);        	
        //BufferedReader in = new BufferedReader(new InputStreamReader(serversocket.getInputStream()));
        //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));        	
        //out.println("Fragen");
    
        
            /*Object o;
            while (( o = ois.readObject()) != null) {
            	if (o instanceof Object[]) {
            		int i = 0;
            		for (Object obj : (Object[])o) {
            			Frage frage = (Frage) obj;
            			Allefragen.add(frage);            			
            			
            			i++;
            			System.out.println("Frage " + i + ": " + frage.Frage + " Antwort 1: " + frage.Antwort1 + 
						" Antwort 2: " + frage.Antwort2 + " Antwort 3: " + frage.Antwort3 + 
						" Antwort 4: " + frage.Antwort4 + " Richtige Antwort: " + frage.RichtigeAntwort);		
					}*/
            		GUI = new Panel_GUI();
            		GUI.setTitle("Quiz");
            		GUI.setSize(800, 600);
            		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            		GUI.setVisible(true);
            		GUI.setResizable(false);
            		
            	

            	//stdIn.readLine();
            	//System.out.println("Exit");
            	//System.exit(0);         	
            
            
       /* } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);*/
            		
            		
        }
    
    public static Boolean Login(String user, String pass) {
    	System.out.println("Login... User: " + user + ", Passwort: " + pass);
    	
        try {
        	out.writeObject(Server_befehl.Login);
        	out.writeObject(user);
        	out.writeObject(pass);
			Boolean isOk = (Boolean)in.readObject();
			return isOk;	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return false;
    }
    
    public static ArrayList<Frage> HolFragen() {
    	try {
        	out.writeObject(Server_befehl.Fragenholen);
        	ArrayList<Frage> fragen = (ArrayList<Frage>)in.readObject();
        	Allefragen = fragen;
			return fragen;	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    public static void Highscore_speichern(Highscore_eintrag eintrag) {
    	//System.out.println("Login... User: " + user + ", Passwort: " + pass);
    	
        try {
        	out.writeObject(Server_befehl.Highscore_speichern);
        	out.writeObject(eintrag);			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static ArrayList<Highscore_eintrag> Highscore_laden() {
    	try {
        	out.writeObject(Server_befehl.Highscore_laden);
        	ArrayList<Highscore_eintrag> highscore = (ArrayList<Highscore_eintrag>)in.readObject();
        	Highscore = highscore;
        	for (Highscore_eintrag e : highscore) {
    			//HighscoreFeld.append(e.Nutzername + ": " + e.Punkte.toString() + " Punkte\n");
    			System.out.println(e.Nutzername + ": " + e.Punkte.toString() + " Punkte\n");
    		}
			return highscore;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }
}