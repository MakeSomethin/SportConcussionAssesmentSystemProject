


public class RecordAthlete {
	public int symptom = 0;
	public int score = 0;
	public String risk = "";
	
	public RecordAthlete(int Symp, int sc, String rsk) {
		symptom = Symp;
		score = sc;
		risk = rsk;
	}
	
	
	public String toString() {
		return "Total number of symptoms: " + Integer.toString(symptom) + "\n"
				+ "Symptom severity score: " +Integer.toString(score) + "\n"
				+ "Risk Condition = " + risk + "\n";
		
		
	}
}
