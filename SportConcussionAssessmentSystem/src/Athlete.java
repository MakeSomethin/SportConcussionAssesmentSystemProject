import java.util.ArrayList;

public class Athlete {
	private String username;
	private String password;
	private String risk;
	public ArrayList<RecordAthlete> records;
	
	public Athlete(String name, String word) {
		username = name;
		password = word;
		records = new ArrayList<RecordAthlete>();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String name) {
		username = name;
	}
	
	public boolean checkPassword(String word) {
		if(password.equals(word)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void addRecord(int symptom, int score) {
		if (records.size() == 0) {
			records.add(new RecordAthlete(symptom, score, "No Rating"));
		}else {
			int sympDiff = Math.abs(records.get(records.size() - 1).symptom - symptom);
			if(sympDiff<3 && score <10) {
				records.add(new RecordAthlete(symptom, score, "No difference"));
			}else if (sympDiff < 3 && score >=10 && score < 15) {
				records.add(new RecordAthlete(symptom, score, "Unsure"));
			}else if(sympDiff >= 3 || score >= 15){
				records.add(new RecordAthlete(symptom, score, "Very different"));
			}else {
				records.add(new RecordAthlete(symptom, score, "Some Unbound Error"));
			}
		}
	}
	
	
	public String toString() {
		String res = "";
		res=  "Username: "+ this.getUsername() + "\n";
		int i =0;
		
		for (var record: records) {
			i++;
			res = res + "\n";
			res = res + "Game " + Integer.toString(i) + ": \n";
			res = res + record;
		}
		res = res + "\n";
		
		return res;
	}
	
}
