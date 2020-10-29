
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
        
        public static void main(String[] args) {
            
            Manage manager = new Manage(); // Instans av hela klassen ("bygga ett hus av ritningen")
            
            manager.Start();
            
            //Books book = new Books(123123, "Harry Potter", 200, 700, "jk rowling");
            
            //System.out.println("Article number: " + book.articleNumber );
            
            System.out.println(" Welcome to the Library system. ");
            System.out.println(" Below you can see the current inventory: ");
            
            
            // List on all the products should shows here!
            
            

 

            // Konstruktor
            // instansiera 
            
        }

 

    
        public Manage() { // konstruktor
            LibraryMain library = new LibraryMain (); //libpath - filen man vill spara
            
            
            // try catch exceptions
        }
        
        public void Start () {//ny funktion (ritningn för metoden)
            //System.out.println("Detta är start!");
            Scanner scanner = new Scanner(System.in);
            
    while (isRunning) {
                
                System.out.println(">");
                
                String userInput = scanner.nextLine();
            }
            
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
}