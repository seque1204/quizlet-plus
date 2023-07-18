 import java.util.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	static String input;
	public static void main(String[] args) {
	/*
	 * second president,john adams,first presidnet,george washington,third president,thomas jefferson,fourth president,james madison,sixth presdient,john quincy adams,fortysecond president,bill clinton
	* Hydrogen,H,Helium,He,Lithium,Li,Berrylium,Be,Boron,B,Carbon,C,Nitrogen,N,Oxygen,O,Fluorine,F,Neon,Ne
	*/
		
	
	//Welcome user	
	System.out.println("Welcome to my version of Quizlet which aims to emulate the Learning Feature, I hope you enjoy using it!\n");
	
	//Adds the input from the user into the list
	Flashcard.getUserInput();
	
	//Allows user to go back and edit, a term, definition or add a new term.
	boolean state = true;
	
	while (state) {
	//Prints learning
	System.out.println("Check your list: \n");
	Flashcard.printList();
	//scanner.useDelimiter(",");
	System.out.println("Type 'no' to edit or hit 'enter' if it's okay.");
	input = scanner.nextLine();
	
	if (!input.equalsIgnoreCase("no")) {
		state = false;
	}
	else {
		System.out.println("How would you like to edit the list?");
		System.out.println("Type '1' to add a new pairing.");
		System.out.println("Type '2' to modify a term.");
		System.out.println("Type '3' to modify a definition.");
		
		input = scanner.nextLine();
		
		
		if (input.equals("1")) {
			Flashcard.getUserInput();
		}
		else if (input.equals("2")) {
			System.out.println("Enter {Correct Definition},{The New Term}: ");
			String definitionAndTerm = scanner.nextLine();
            String[] parts = definitionAndTerm.split(",");

            if (parts.length != 2) {
                System.out.println("Invalid input format.");
                continue;
            }

            String definition = parts[0].trim();
            String newTerm = parts[1].trim();
            Flashcard.modifyTerm(newTerm, definition);
		}
		
		else if (input.equals("3")){
			System.out.println("Enter: {Correct Term},{The New Definition} ");
            String termAndDefinition = scanner.nextLine();
            String[] parts = termAndDefinition.split(",");

            if (parts.length != 2) {
                System.out.println("Invalid input format.");
                continue;
            }

            String term = parts[0].trim();
            String newDefinition = parts[1].trim();
            Flashcard.modifyDefinition(term, newDefinition);
		}
		
		else {
			System.out.println("Invalid option.");
		}	
	}
	
	}
	
	
	//Runs through the learning phase
	while (!Flashcard.learning.isEmpty()) {
		Flashcard.compareUserAnswer();	
	}
	
	//Final summary
	Flashcard.printAll();
	
	//Asks user if they want to continue
	System.out.println("Congratulations, you have passed the learning stage, are you ready to become a master? (Press Q to quit)");
	input = scanner.nextLine();
	
	//Quits if the answer is Q
	if (input.equalsIgnoreCase("Q")) {
		System.out.print("Thank you for using my my app");
		System.exit(0);
	}
	
	//Runs through the learned phase to become a master
	else {
		while (!Flashcard.learned.isEmpty()) {
			Flashcard.compareUserAnswer();
		}
		
		//Final message
		System.out.println("Congratulations, you have become a master! Thank you for using my app."); 	
	}
}
}

	
	
	

