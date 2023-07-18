import java.util.*;

public class Flashcard {
	// Static Variables

    /**
     * Default term for a flashcard
     */
    static String DEFAULT_TERM = "Term";

    /**
     * Default definition for a flashcard
     */
    static String DEFAULT_DEFINITION = "Definition";

    /**
     * Linked List to store terms.
     * Used to store the terms that the user has either:
     *   - not practiced
     *   - got wrong after it had been moved up to learned
     */
    static LinkedList<Flashcard> learning = new LinkedList<>();

    /**
     * Linked List to store terms.
     * Used to store the terms that the user has either:
     *   - practiced and got correct
     *   - got wrong after it had been moved up to mastered
     */
    static LinkedList<Flashcard> learned = new LinkedList<>();

    /**
     * Linked List to store terms.
     * Used to store the terms that the user has either:
     *   - practiced and got right after being in learned
     *   - used for final review
     */
    static LinkedList<Flashcard> mastered = new LinkedList<>();

    // Instance Variables

    /**
     * Term of the flashcard
     */
    String term;

    /**
     * Definition of the flashcard
     */
    String definition;
   
    // Constructors
    
    /**
     * Creates a flash card given:
     * @param term
     * @param definition
     * and adds it to corresponding linked list
     */
    public Flashcard(String term, String definition) {
        this.term = term;
        this.definition = definition;    
        learning.add(this);
    }
    
    /**
     * Calls the first constructor recursively given 1 parameter
     * uses default definition
     * @param term
     */
    public Flashcard(String term) {
    	this(term, Flashcard.DEFAULT_DEFINITION);
    }
    
    /**
     * Calls the first constructor recursively given no parameters.
     * Uses default term and definition
     */
    public Flashcard() {
    	this(Flashcard.DEFAULT_TERM, Flashcard.DEFAULT_DEFINITION);
    }
    
    //Methods
    /**
     * Returns the definition of a term
     * @return definition
     */
    public String getDefinition() {
    	return this.definition;
    }
    
    /**
     * Returns the term
     * @return term
     */
    public String getTerm() {
    	return this.term;
    }
    
    public void setDefinition(String newDefinition) {
    	this.definition = newDefinition;
    }
    
    public void setTerm(String newTerm) {
    	this.term = newTerm;
    }
    
    public static void modifyTerm(String newTerm, String definition) {
    	for (Flashcard flashcard : learning) {
            if (flashcard.getDefinition().equals(definition)) {
                // Modify the definition of the flashcard
                flashcard.setTerm(newTerm);
                return; // Exit the loop once the flashcard is found and modified
            }
        }
    	
    	for (Flashcard flashcard : learned) {
            if (flashcard.getDefinition().equals(definition)) {
                // Modify the definition of the flashcard
                flashcard.setTerm(newTerm);
                return; // Exit the loop once the flashcard is found and modified
            }
    	}
    	for (Flashcard flashcard : mastered) {
            if (flashcard.getDefinition().equals(definition)) {
                // Modify the definition of the flashcard
                flashcard.setTerm(newTerm);
                return; // Exit the loop once the flashcard is found and modified
            }
        
        }
    	
    }
    
    public static void modifyDefinition(String term, String newDefinition) {
        // Search for the flashcard with the specified term
        for (Flashcard flashcard : learning) {
            if (flashcard.getTerm().equals(term)) {
                // Modify the definition of the flashcard
                flashcard.setDefinition(newDefinition);
                return; // Exit the loop once the flashcard is found and modified
            }
        }

        for (Flashcard flashcard : learned) {
            if (flashcard.getTerm().equals(term)) {
                // Modify the definition of the flashcard
                flashcard.setDefinition(newDefinition);
                return; // Exit the loop once the flashcard is found and modified
            }
        }

        for (Flashcard flashcard : mastered) {
            if (flashcard.getTerm().equals(term)) {
                // Modify the definition of the flashcard
                flashcard.setDefinition(newDefinition);
                return; // Exit the loop once the flashcard is found and modified
            }
        
        }
    }
    
    public static void printList() {
    	for (Flashcard flashcard : learning) {
            System.out.println(flashcard.term + ": " + flashcard.definition);
        }
    	System.out.println();
    }
    
    /**
     * Print the elements of the learning linked list.
     */
    public static void printLearning() {
    	System.out.println("Learning List:");
    	System.out.println();
    	for (Flashcard flashcard : learning) {
            System.out.println(flashcard.term + ": " + flashcard.definition);
        }
    	System.out.println();
    }
    
    /**
     * Print the elements of the learned linked list.
     */
    public static void printLearned() {
    	System.out.println("Learned List:");
    	System.out.println();
    	for (Flashcard flashcard : learned) {
            System.out.println(flashcard.term + ": " + flashcard.definition);
        }
    	System.out.println();
    }
    
    /**
     * Print the elements of the mastered linked list.
     */
    public static void printMastered() {
    	System.out.println("Mastered List:");
    	System.out.println();
    	for (Flashcard flashcard : mastered) {
            System.out.println(flashcard.term + ": " + flashcard.definition);
        }
    	System.out.println();
    }
    
    /**
     * Print the elements of all the lists.
     */
    public static void printAll() {
    	printLearning();
    	printLearned();
    	printMastered();
    }
    
   
    /**
     * Used in main to get user input and create the objects of type Flashcard and adds them to the learning linked list
     */
    public static void getUserInput() {
    	//Create a scanner instance
    	Scanner scanner = new Scanner(System.in);
    	
    	//Prompt user to enter their terms separated by commas
    	System.out.println("Please enter all of your terms and definitions separated by commas\n\nExample:(Sky,Blue,Cloud,White...): ");
    	String input = scanner.nextLine();
    	
    	//Use Scanner to process input
    	Scanner inputScanner = new Scanner(input);
        inputScanner.useDelimiter(",");
        
        //Create and store new Flashcard instances for each input
        while (inputScanner.hasNext()){
        if (inputScanner.hasNext()) {
            String term = inputScanner.next();
            if (inputScanner.hasNext()) {
                String definition = inputScanner.next();
                new Flashcard(term, definition);
            } else {
                new Flashcard(term);
            }
        }
        }
        
        inputScanner.close();
        System.out.println();   
    }
    
    public static void compareUserAnswer() {
    	 String randomTerm;
    	    if (!learning.isEmpty()) {
    	        int size = learning.size();
    	        Random random = new Random();
    	        int randomIndex = random.nextInt(size);   
    	        randomTerm = learning.get(randomIndex).getTerm();
    	    }
    	    else if (!learned.isEmpty()) {
    	        int size = learned.size();
    	        Random random = new Random();
    	        int randomIndex = random.nextInt(size);
    	        randomTerm = learned.get(randomIndex).getTerm();
    	    }
    	    else {
    	        randomTerm = null;
    	    }

    	    if (randomTerm != null) {
    	        String correctAnswer = null;
    	        for (Flashcard flashcard : learning) {
    	            if (flashcard.getTerm().equals(randomTerm)) {
    	                correctAnswer = flashcard.getDefinition();
    	                break;
    	            }
    	        }
    	        if (correctAnswer == null) {
    	        	for (Flashcard flashcard : learned) {
        	            if (flashcard.getTerm().equals(randomTerm)) {
        	                correctAnswer = flashcard.getDefinition();
        	                break;
        	            }
        	        }
    	        }

    	        if (correctAnswer != null) {
    	            Scanner scanner = new Scanner(System.in);
    	            System.out.print("Enter your answer for the term \"" + randomTerm + "\": ");
    	            String userInput = scanner.nextLine();

    	            if (correctAnswer.equals(userInput)) {
    	                System.out.println("Correct!");

    	                // Find the Flashcard object in the learning list
    	                Flashcard flashcard = null;
    	                for (Flashcard card : learning) {
    	                    if (card.getTerm().equals(randomTerm)) {
    	                        flashcard = card;
    	                        break;
    	                    }
    	                }

    	                if (flashcard != null) {
    	                    learning.remove(flashcard);
    	                    learned.add(flashcard);
    	                }
    	                else {
    	                	for (Flashcard card : learned) {
        	                    if (card.getTerm().equals(randomTerm)) {
        	                        flashcard = card;
        	                        break;
        	                    }
        	                }
    	                if (flashcard != null) {
        	                learned.remove(flashcard);
        	                mastered.add(flashcard);
    	                }
    	              } 
    	            }
    	            else {
    	                System.out.println("Wrong! The correct answer was: " + correctAnswer);
    	            }
    	        }
    	    } else {
    	        System.out.println("No flashcards available for testing.");
    	    }
    	}   

    
    
}