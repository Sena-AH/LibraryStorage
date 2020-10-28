
public class Commands {

	protected enum Command{
		
		list,
		checkout,
		checkin,
		register,
		deregister,
		info,
		quit,
		unknown
	}
	
public static Command parseCommand(String playerInput){ 
		
		//splitting input and adding it to index [0] so that the code knows that the first word in input is a command
		String commandString = playerInput.split(" ")[0]; 
		
		//switch statement for words from input that turns them into the commands in the enumeration
		switch (commandString) {
		
		case "list":
			return Command.list;
			
		case "checkout":
			return Command.checkout;
		
		case "checkin":
			return Command.checkin;
			
		case "register":
			return Command.register;
			
		case "deregister":
			return Command.deregister;
			
		case "info":
			return Command.info;
			
		case "quit":
			return Command.quit;
			
		default:
			return Command.unknown;
		}
		
	}
}
