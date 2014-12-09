import java.io.*;
import java.util.ArrayList;

public class server_questionlist {

	public static void main(String[] args) {		 
		server_questionlist obj = new server_questionlist();
		obj.run();	 
	  }

	private ArrayList<Frage> fragen = new ArrayList<Frage>();
	
	  public void run() {	 
		String csvFile = "/home/daedalus/workspace/Quiz/fragen.csv";
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
				fragen.add(f);				
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
	  }

	public Object[] fragen() {
		return fragen.toArray();
	}
}