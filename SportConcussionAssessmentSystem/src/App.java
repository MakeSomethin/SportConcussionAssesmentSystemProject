import java.util.Scanner;

public class App {
	public static Scanner keyboard = new Scanner(System.in);
	public static SCAS scas = new SCAS();
	public static Athlete userAthlete;
	public static String username;
	public static int practitionerID;
	public static String[] SymptomsList = {"Headache", "Pressure in Head", "Neck Pain", "Nausea or Vomiting", "Dizziness",
            "Blurred vision", "Balance problems", "Sensitivity to light", "Sensitivity to noise",
            "Feeling slowed down", "Feeling like 'in a fog'", "Don't feel right",
            "Difficulty concentrating", "Difficulty remembering", "Fatigue or low energy",
            "Confusion", "Drowsiness", "Trouble falling asleep", "More emotional",
            "Irritability", "Sadness", "Nervous or Anxious"};
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
	public static final String strNoDiff = ANSI_GREEN + "No difference" + ANSI_RESET;
	public static final String strUnsure = ANSI_YELLOW + "Unsure" + ANSI_RESET;
	public static final String strVeryDiff = ANSI_RED + "Very Different" + ANSI_RESET;
	

	
	public static void main(String[] args) {
		processMainMenu();
	}
	
	public static void processAthleteMenu(){
		do {
			// Need to Implement
			System.out.println("\tAthlete Menu:");
			System.out.println();
			System.out.println("\t\t1. Enter Symptons for a new game");
			System.out.println("\t\t2. Symptom Summary");
			System.out.println("\t\t3. view Practitioner comment");
			System.out.println("\t\t4. Am I at risk");
			System.out.println("\t\t5. back to main menu");
			System.out.println("\t\t6. Exit");
			
			System.out.println("Enter 1-5");
			
			
			while(!keyboard.hasNext("[1-5]")) {
				System.out.println();
				System.out.println("Invalid input");
				keyboard.nextLine();
			}
			
			int choice = keyboard.nextInt();
			
			switch(choice){
			case 1: // Enter Symptoms
				scas.addRecord(userAthlete);
				break;
			case 2: // Symptom Summary
				System.out.println("Symptom Sumary for Athlete");
				System.out.println("--------------------------");
				System.out.println(userAthlete);
				break;
			case 3: // Practitioner comment
				System.out.println("Not require to implement Practitioner");
				break;
			case 4:
				if(userAthlete.records.get(userAthlete.records.size()-1).risk.equals("No difference")) {
					System.out.println(strNoDiff);
				}else if(userAthlete.records.get(userAthlete.records.size()-1).risk.equals("Unsure")) {
					System.out.println(strUnsure);
				}
				else if(userAthlete.records.get(userAthlete.records.size()-1).risk.equals("Very different")) {
					System.out.println(strVeryDiff);
				}else if(userAthlete.records.get(userAthlete.records.size()-1).risk.equals("No Rating")) {
					System.out.println("No Rating");
				}else {
					System.out.println("Not mention it");
				}
				
				break;
			case 5: // back to main menu
				System.out.println();
				processMainMenu();
				break;
			case 6: // Exit
				scas.saveData();
				System.out.println();
				System.out.println("GoodBye");
				System.exit(0);
			}
			
		}while(true);
		
		
		
	}
	
	public static void processMainMenu() {
		do {

			
			System.out.println("\tSport Concussion Assessment System");
			System.out.println();
			System.out.println("\tMain Menu:");
			System.out.println();
			System.out.println("\t\t1. Athlete log in");
			System.out.println("\t\t2. Athlete sign up");
			System.out.println("\t\t3. Medical Practitioner log in");
			System.out.println("\t\t4. Medical Practitioner sign up");
			System.out.println("\t\t5. Exit");
			
			System.out.println("Enter 1-5");
			
			
			while(!keyboard.hasNext("[1-5]")) {
				System.out.println();
				System.out.println("Invalid input");
				keyboard.nextLine();
			}
			
			int userChoice = keyboard.nextInt();
			
			
			switch(userChoice) {
			case 1: // Log in Athlete
			{
				boolean isContinue = true;
				keyboard.nextLine();
				
				while (isContinue) {
					System.out.println();
					System.out.println("Enter username: ");
					username = keyboard.nextLine();
					userAthlete = scas.loginAthelete(username);
					if( userAthlete == null) {
						System.out.println("Not exist this Athlete in this system, Please enter again");
					}else {
						System.out.println("Successful Login");
						isContinue = false;
					}
				}
				processAthleteMenu();
				
			}	
				break;
			case 2: // Athlete sign up
				scas.addAthlete();
				break;
			case 3: // Medical Practitioner login
				break;
			case 4: // Medical Practitioner Sign up
				break;
			case 5:
				scas.saveData();
				System.out.println("GoodBye");
				System.exit(0);
			}
			
		}while(true);
	}

}
