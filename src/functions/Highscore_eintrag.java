package functions;

public class Highscore_eintrag implements java.io.Serializable, Comparable<Highscore_eintrag>  {	
	 
		private static final long serialVersionUID = 1L;
		
		public String Nutzername;
		public Integer Punkte;		

		@Override
		public int compareTo(Highscore_eintrag e) {
			
			return e.Punkte.compareTo(this.Punkte);
		}
}