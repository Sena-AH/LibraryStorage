import java.util.Scanner;
import java.util.ArrayList;

public class Manager { // Manager tolkar vad du vill g�ra och startar funktion i libraryklassen. 
						//Library kommer skapa instanser av b�cker och filmer.
	
	
	protected enum Command{
	
	LIST,
	CHECKOUT,
	CHECKIN,
	REGISTER,
	DEREGISTER,
	INFO,
	QUIT,
	UNKNOWN
	
	}
		
		public static void main(String[] args) {
			
			Manager manager = new Manager(); // Instans av hela klassen
			
			Scanner scanner = new Scanner(System.in);
			
			//Books book = new Books(123123, "Harry Potter", 200, 700, "jk rowling");
			
			//System.out.println("Article number: " + book.articleNumber );
			
			System.out.println(" Welcome to the Library system. ");
			System.out.println(" Below you can see the current inventory: ");
			
			
			// List on all the products should shows here!
			
			
			while (true) {
				
				System.out.println(">");
				
				String userInput = scanner.nextLine();
			}

			// Konstruktor
			// instansiera 
			
		}

	
		public Manager() { // konstruktor
			library = new Library //libpath - filen man vill spara

			// try catch exceptions
		}


public static Command parseCommand(String playerInput){ 
	
	Scanner scanner = new Scanner (System.in);
	
	String playerInput1 = scanner.nextLine(); // read wich command the user enter (LIST, CHECKOUT ETC.)
		
	//Scanner scanner = new Scanner (System.in);
	
	//String userInput = scanner.nextLine(); // read wich command the user enter (LIST, CHECKOUT ETC.)
	
		//splitting input and adding it to index [0] so that the code knows that the first word in input is a command
		String commandString = playerInput.split(" ")[0]; 
		
		//switch statement for words from input that turns them into the commands in the enumeration
		switch (commandString) {
		
		case "list":
			return Command.LIST;
			
		case "checkout":
			return Command.CHECKOUT;
		
		case "checkin":
			return Command.CHECKIN;
			
		case "register":
			return Command.REGISTER;
			
		case "deregister":
			return Command.DEREGISTER;
			
		case "info":
			return Command.INFO;
			
		case "quit":
			return Command.QUIT;
			
		default:
			return Command.UNKNOWN;
		}
		
		
}
		
		public static void handleQuitCommand (String [] arguments) { // close the application
			System.exit(0);
			System.out.println("You have closed the library system. Goodbye! ");
		}

		// 
		

				
	
	}


