
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SCAS {
	public HashMap<String, Athlete> athletes = new HashMap<String, Athlete>();
	public HashMap<String, Practitioner> practitioners = new HashMap<String, Practitioner>();
	Scanner keyboard = new Scanner(System.in);
	
	public SCAS(){
		// Pull data from database
		
	}
	
	
	public Athlete loginAthelete(String username) {
		if(athletes.containsKey(username))
			return athletes.get(username);
		else
			return null;
	}
	
	public void addAthlete() {
		boolean isContinue = true;
		
		while(isContinue) {
			System.out.println("Enter your username: ");
			String name = keyboard.nextLine();
			if(athletes.containsKey(name)) {
				System.out.println("Existed name in the system, go change your name.");
				System.out.println();
			}
			else {
				isContinue = false;
				System.out.println("Enter password: ");
				String password = keyboard.nextLine();
				athletes.put(name, new Athlete(name, password));
				System.out.println("Sign up successful");
			}
		}
		
		
	}
	
	public void addPractitioner(String name, String word) {
		// No need to Implement
	}
	public void saveData() {
		// Push Data to database
	}
	
	public void addRecord(Athlete athlete){
		int sumScore = 0;
		int numSymptom = 0;
		String[] SymptomsList  = {"Headache", "Pressure in Head", "Neck Pain", "Nausea or Vomiting", "Dizziness",
	            "Blurred vision", "Balance problems", "Sensitivity to light", "Sensitivity to noise",
	            "Feeling slowed down", "Feeling like 'in a fog'", "Don't feel right",
	            "Difficulty concentrating", "Difficulty remembering", "Fatigue or low energy",
	            "Confusion", "Drowsiness", "Trouble falling asleep", "More emotional",
	            "Irritability", "Sadness", "Nervous or Anxious"};
		
		System.out.println("Creating a new Record: ");
		System.out.println();
		
		
		for(int i =0; i < SymptomsList.length; i++) {
			String str1  = "Please enter your " + SymptomsList[i] + " score";
			System.out.printf("%-50s", str1);
			System.out.print("(none (0), mild (1-2), moderater (3-4), & severe(5-6)): ");
			
			int score = keyboard.nextInt();
			
			if(score > 0) {
				numSymptom++;
			}
			
			sumScore = sumScore + score;
			
			System.out.println();
		}
		athlete.addRecord(numSymptom, sumScore);
		System.out.println("Record has been added");
	}
	
	
}
