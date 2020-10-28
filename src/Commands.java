import java.util.Scanner;

public class Commands {

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
	
public static Command parseCommand(String playerInput){ 
		
	Scanner scanner = new Scanner (System.in);
	
	String userInput = scanner.nextLine(); // read wich command the user enter (LIST, CHECKOUT ETC.)
	
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
}
