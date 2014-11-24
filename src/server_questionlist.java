import java.io.*;

public class server_questionlist {

	public static void main(String[] args) {
		 
		server_questionlist obj = new server_questionlist();
		obj.run();
	 
	  }

	private String[] fragen;
	
	  public void run() {
	 
		String csvFile = "/home/daedalus/workspace/Quiz/fragen.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {	 
			        
				 fragen = line.split(cvsSplitBy);
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

	public String[] fragen() {
		return fragen;
	}
}