
import java.util.Scanner;


import java.util.ArrayList;

 

public class Manage { // Manager tolkar vad du vill göra och startar funktion i libraryklassen. 
                        //Library kommer skapa instanser av böcker och filmer.
    boolean isRunning;
    
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
        
    public static Scanner scanner = new Scanner (System.in);
    
        public static void main(String[] args) {
            
           // Manage manager = new Manage(); // Instans av hela klassen ("bygga ett hus av ritningen")
            
            //manager.Start();
            
            
            
            //Books book = new Books(123123, "Harry Potter", 200, 700, "jk rowling");
            
            //System.out.println("Article number: " + book.articleNumber );
            
            System.out.println(" Welcome to the Library system. ");
            System.out.println(" Below you can see the current inventory: ");
            
            
            // List on all the products should shows here!
            boolean on = true;
            
            while (on) {
        		
        		String playerInput = scanner.nextLine();
        		
        		Command command = parseCommand(playerInput);
        		
        		if (command == Command.LIST) {
        		
        			handleListCommand();
        			System.out.print("\n\tEnter next command: \n\t > ");

        			continue;
        		
        			} else if (command == Command.CHECKOUT) {
        		
        				handleCheckoutCommand();
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        	
        			} else if(command == Command.CHECKIN) {
        		
        				handleCheckinCommand();
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if(command == Command.REGISTER) {
                		
        				handleRegisterCommand();
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if(command == Command.DEREGISTER) {
                		
        				handleDeregisterCommand();
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if(command == Command.INFO) {
                		
        				handleInfoCommand();
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if (command == Command.UNKNOWN) {
        				
        				System.out.println("\nERROR: Unknown command.\n");
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        		
        			} else if (command == Command.QUIT) {
        		
        				System.out.println("\n\tExiting library.. ");
        				on = false;
        				break;
        		
        			}
				
        		}
 

            // Konstruktor
            // instansiera 
            
        }

 

    
        public Manage() { // konstruktor
            LibraryMain library = new LibraryMain (); //libpath - filen man vill spara
            
            
            // try catch exceptions
        }
        
      //  public void Start () {//ny funktion (ritningn f�r metoden)
            //System.out.println("Detta �r start!");
          //  Scanner scanner = new Scanner(System.in);
            
  //  while (isRunning) {
                
            //    System.out.println(">");
                
              //  String userInput = scanner.nextLine();
          //  }
            
     //   }

 

        public static Command parseCommand(String playerInput){ 
    
   
        	String commandString = playerInput.split(" ")[0];
   // String playerInput1 = scanner.nextLine(); // read wich command the user enter (LIST, CHECKOUT ETC.)
        
    //Scanner scanner = new Scanner (System.in);
    
    //String userInput = scanner.nextLine(); // read wich command the user enter (LIST, CHECKOUT ETC.)
    
        //splitting input and adding it to index [0] so that the code knows that the first word in input is a command
        //String commandString = playerInput.split(" ")[0]; 
        
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

	public static String[] parseArgument(String playerInput) {
		
		// CHANGE SO IT WORKS WITH ARRAY LIST AND NOT JUST ARRAY!!
		// MAKE IT PARSE ARTICLENUMBERS
		
		String[] fullInput = playerInput.split(" ");
		String[] arguments = new String[fullInput.length-1];
		
			for (int i=1; i<fullInput.length; i++) {
			arguments[i-1] = fullInput[i];
			
			}
			return arguments;
		}

        
        public static void handleListCommand() {
        	//enter code
        	System.out.println("list command handled");
        }
        
        public static void handleCheckoutCommand() {
        	//enter code
        	System.out.println("checkout command handled");

        }
        
        public static void handleCheckinCommand() {
        	//enter code
        	System.out.println("checkin command handled");

        }
        
        public static void handleRegisterCommand() {
        	//enter code
        	System.out.println("register command handled");

        }
        
        public static void handleDeregisterCommand() {
        	//enter code
        	System.out.println("deregister command handled");

        }
        
        public static void handleInfoCommand() {
        	//enter code
        	System.out.println("info command handled");

        }
        
}