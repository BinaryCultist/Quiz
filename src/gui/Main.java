package gui;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;

import functions.Befehle;
import functions.Frage;
import functions.Highscore_eintrag;

public class Main {	
	private static Socket serversocket;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static String hostName;
	private static int portNumber;
	
	public static Panel_GUI GUI;	
	public static ArrayList<Frage> Allefragen = new ArrayList<Frage>();
	public static ArrayList<Highscore_eintrag> Highscore = new ArrayList<Highscore_eintrag>();
	public static String AktNutzername;
	
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
        hostName = "127.0.0.1"; // Server läuft auf Localhost, ansonsten Server-IP
        portNumber = 4444; // Verbindungs-Port auf dem Server
        
        serversocket = new Socket(hostName, portNumber); // Öffnen eines Sockets zum Server
        out = new ObjectOutputStream(serversocket.getOutputStream());
        in = new ObjectInputStream(serversocket.getInputStream());
        
        GUI = new Panel_GUI();
        GUI.setTitle("Quiz");
        GUI.setSize(800, 600);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
        GUI.setResizable(false);
    }
    
    public static Boolean Login(String user, String pass) {
    	
    	System.out.println("Login... User: " + user + ", Passwort: " + pass);		
    	
        try {
        	out.writeObject(Befehle.Login);
        	out.writeObject(user);
        	out.writeObject(pass);
			Boolean isOk = (Boolean)in.readObject();
			return isOk;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return false;
    }
    
    @SuppressWarnings("unchecked")
	public static ArrayList<Frage> HolFragen() {
    	
    	try {
        	out.writeObject(Befehle.Fragenholen);
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
    	
        try {
        	out.writeObject(Befehle.Highscore_speichern);
        	out.writeObject(eintrag);			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static ArrayList<Highscore_eintrag> Highscore_laden() {
    	
    	try {
        	out.writeObject(Befehle.Highscore_laden);
        	@SuppressWarnings("unchecked")
			ArrayList<Highscore_eintrag> highscore = (ArrayList<Highscore_eintrag>)in.readObject();
        	Highscore = highscore;
			return highscore;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
    }
}