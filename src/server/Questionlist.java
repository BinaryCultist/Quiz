package server;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Questionlist {

	private ArrayList<Frage> fragen1 = new ArrayList<Frage>(); // Konstruktor für Arrayliste der Fragen Kategorie 1
	private ArrayList<Frage> fragen2 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen3 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen4 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen5 = new ArrayList<Frage>();
	
	public void fragenausdateilesen() {
		fragen1 = fragenausdateilesen_intern("/home/daedalus/workspace/Quiz/src/server/fragen1.csv"); // Auslesen der Fragen aus CSV-Datei
		fragen2 = fragenausdateilesen_intern("/home/daedalus/workspace/Quiz/src/server/fragen2.csv");
		fragen3 = fragenausdateilesen_intern("/home/daedalus/workspace/Quiz/src/server/fragen3.csv");
		fragen4 = fragenausdateilesen_intern("/home/daedalus/workspace/Quiz/src/server/fragen4.csv");
		fragen5 = fragenausdateilesen_intern("/home/daedalus/workspace/Quiz/src/server/fragen5.csv");
	}
	
	  public ArrayList<Frage> fragenausdateilesen_intern(String dateiname) {
		String csvFile = dateiname;
		ArrayList<Frage> fragentemp = new ArrayList<Frage>(); // Konstruktor temp-ArrayList
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";"; // Trennzeichen zwischen Elementen ist ein Semikolon
	 
		try {	 
			br = new BufferedReader(new FileReader(csvFile)); // Einlesen der CSV-Datei
			while ((line = br.readLine()) != null) { // Schleife um Zeile für Zeile einzulesen bis Dateiende 
				Frage f = new Frage(); // Konstruktor für ein Array (Frage + dazugehörigen Antworten + richtige Antwort)
				String [] element = line.split(cvsSplitBy);
				f.Frage = element[0]; // Abspeichern in Array
				f.Antwort1 = element[1];
				f.Antwort2 = element[2];
				f.Antwort3 = element[3];
				f.Antwort4 = element[4];
				f.RichtigeAntwort = Integer.parseInt(element[5]);		
				fragentemp.add(f); // zur temp-ArrayList hinzufügen		
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		// System.out.println("Done");
		return fragentemp;
	  }
	  
		private ArrayList<Frage> randomzehn(ArrayList<Frage> fragen) { // Fragen random verteilen und 10 pro Kategorie auswählen
			ArrayList<Frage> fragentemp = new ArrayList<Frage>();
			Random r = new Random();
			for (int i = 0; i < 10; i++) { // für 10 Fragen
				fragentemp.add(fragen.get(r.nextInt(fragen.size() - 1))); // Random-Fragenarray hinzufügen
			}
			return fragentemp; // Rückgabe 10 Zufallsfragen pro csv-Datei
		}
	
	public Object[] allefragen() { 
		ArrayList<Frage> fragentemp = new ArrayList<Frage>(); // Konstruktor für alle 50 Zufalls-Fragen
		fragen1 = randomzehn (fragen1); // Zufallsfragen holen
		fragen2 = randomzehn (fragen2);
		fragen3 = randomzehn (fragen3);
		fragen4 = randomzehn (fragen4);
		fragen5 = randomzehn (fragen5);
		fragentemp.addAll(fragen1); // Übergabe von 10 Zufallsfragen aus Kategorie 1 an temp-ArrayList
		fragentemp.addAll(fragen2);
		fragentemp.addAll(fragen3);
		fragentemp.addAll(fragen4);
		fragentemp.addAll(fragen5);		
		return fragentemp.toArray(); // Rückgabe von 50 Zufalls-Fragen (je 10 aus 1 Kategorie)
	}
}