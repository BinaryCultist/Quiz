package server;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class server_questionlist {

	private ArrayList<Frage> fragen1 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen2 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen3 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen4 = new ArrayList<Frage>();
	private ArrayList<Frage> fragen5 = new ArrayList<Frage>();
	
	public void fragenausdateilesen() {
		fragen1 = fragenausdateilesen_intern("fragen1.csv");
		fragen2 = fragenausdateilesen_intern("fragen2.csv");
		fragen3 = fragenausdateilesen_intern("fragen3.csv");
		fragen4 = fragenausdateilesen_intern("fragen4.csv");
		fragen5 = fragenausdateilesen_intern("fragen5.csv");
	}
	
	  public ArrayList<Frage> fragenausdateilesen_intern(String dateiname) {
		String csvFile = dateiname;
		ArrayList<Frage> fragentemp = new ArrayList<Frage>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	 
		try {	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {	 
				Frage f = new Frage();
				String [] element = line.split(cvsSplitBy);
				f.Frage = element[0];
				f.Antwort1 = element[1];
				f.Antwort2 = element[2];
				f.Antwort3 = element[3];
				f.Antwort4 = element[4];
				f.RichtigeAntwort = Integer.parseInt(element[5]);				
				fragentemp.add(f);				
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
	 
		System.out.println("Done");
		return fragentemp;
	  }
	  
		private ArrayList<Frage> randomzehn(ArrayList<Frage> fragen) {
			ArrayList<Frage> fragentemp = new ArrayList<Frage>();
			Random r = new Random();
			for (int i = 0; i < 10; i++) {
				fragentemp.add(fragen.get(r.nextInt(fragen.size() - 1)));
			}
			return fragentemp;
		}

/*	private ArrayList<Frage> fragen1() {
		fragen1 = randomzehn (fragen1);
		return fragen1;
	}

	public ArrayList<Frage> fragen2() {
		fragen2 = randomzehn (fragen2);
		return fragen2.;
	}
	
	public ArrayList<Frage> fragen3() {
		fragen3 = randomzehn (fragen3);
		return fragen3.toArray();
	}
	
	public ArrayList<Frage> fragen4() {
		fragen4 = randomzehn (fragen4);
		return fragen4.toArray();
	}
	
	public ArrayList<Frage> fragen5() {
		fragen5 = randomzehn (fragen5);
		return fragen5.toArray();
	}*/
	
	public Object[] allefragen() {
		ArrayList<Frage> fragentemp = new ArrayList<Frage>();
		fragen1 = randomzehn (fragen1);
		fragen2 = randomzehn (fragen2);
		fragen3 = randomzehn (fragen3);
		fragen4 = randomzehn (fragen4);
		fragen5 = randomzehn (fragen5);
		fragentemp.addAll(fragen1);
		fragentemp.addAll(fragen2);
		fragentemp.addAll(fragen3);
		fragentemp.addAll(fragen4);
		fragentemp.addAll(fragen5);		
		return fragentemp.toArray();
	}
}