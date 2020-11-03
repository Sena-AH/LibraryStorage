import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

 
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
    
    public static Collection<Product> products = new ArrayList <Product>();
   
  // public static List<String[]> content = new ArrayList<>();
   
   public static List<List<String>> records = new ArrayList<>();

    
    public static ArrayList <Customer> customers = new ArrayList <Customer>();
    
        public static void main(String[] args) throws FileNotFoundException, IOException {
        	// add csv code from video in main method!!!!!!!!!!!
            
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
        		String[] arguments = parseArgument(playerInput);
        		
        		
        		if (command == Command.LIST) {
        			handleListCommand();
        			System.out.print("\n\tEnter next command: \n\t > ");

        			continue;
        		
        			} else if (command == Command.CHECKOUT) {
        		
        				handleCheckoutCommand(arguments);
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        	
        			} else if(command == Command.CHECKIN) {
        		
        				handleCheckinCommand(arguments);
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if(command == Command.REGISTER) {
                		
        				handleRegisterCommand();
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if(command == Command.DEREGISTER) {
                		
        				handleDeregisterCommand(arguments);
            			System.out.print("\n\tEnter next command: \n\t > ");

        				continue;
        				
        			} else if(command == Command.INFO) {
                		
        				handleInfoCommand(arguments);
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
 
            Product got = new Book (777, "Game of thrones", 300, 750, "Sena och Thiti");
            // Konstruktor
            // instansiera 
            
		}
/*
		public static void Csv() {
			String filePath = "LibraryProducts.csv"; // CSV-FILEN VISAS

			FileInputStream fin;
			try {
				fin = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				return;
			}
			Scanner scanner = new Scanner(fin);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
			scanner.close();
			
		} //Works but has no array but prints code
 */
        public static void csvArray() throws FileNotFoundException, IOException {
        	
        //	List<List<String>> records = new ArrayList<>();
        	try (BufferedReader br = new BufferedReader(new FileReader("LibraryProducts.csv"))) {
        	    String line;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(line);
        	        records.add(Arrays.asList(values));
    				System.out.println(line);
    				//FUNKAR
        	    }
        	}
        }
       
		public Manage() { // konstruktor
           // LibraryMain library = new LibraryMain (); //libpath - filen man vill spara
     /*       
            products = new ArrayList<Product>();
            
            products.add(new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling"));
        	products.add(new Movie(9001, "Attack on Titan", 150, 120, 8.8));
        	products.add(new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams"));
        	products.add(new Movie(9002, "Spirited Away", 80, 125, 8.6));
     */   	
        	
        }
     /*   
        public static void print() {
        	for (Product product : products) {
        		System.out.println(product);
        		
        	}
        }
     */   
      //  public void Start () {//ny funktion (ritningn f�r metoden)
            //System.out.println("Detta �r start!");
          //  Scanner scanner = new Scanner(System.in);
            
  //  while (isRunning) {
                
            //    System.out.println(">");
                
              //  String userInput = scanner.nextLine();
          //  }
            
     //   }
    	
    	public static Collection<Product> allProducts() {
    	//ArrayList <Product> products = new ArrayList <Product>();
/*
    	Product harrypotter = new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling");
    	Product attackontitan = new Movie(9001, "Attack on Titan", 150, 120, 8);
    	Product hitchhiker = new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams");
    	Product spiritedaway = new Movie(9002, "Spirited Away", 80, 125, 8);
  */
   
    	products.add(new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling"));
    	products.add(new Movie(9001, "Attack on Titan", 150, 120, 8));
    	products.add(new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams"));
    	products.add(new Movie(9002, "Spirited Away", 80, 125, 8));
    	
    	
    	return products;
    	
    	}

	
	/*
	public List<String[]> readData() throws IOException { 
	    int count = 0;
	    String file = "LibraryProducts.csv";
	   // List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(";"));
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    	System.out.println("EROOR ERROOROROR");
	    }
	    return content;
	}
	
	//FUNKADE EJ
*/
        
        public static void handleListCommand() throws FileNotFoundException, IOException {
        	//enter code
        	
       /*	
       	 for (Product p : products)
   	     { 		      
   	          System.out.println(p); 		
   	      }
       */
        	//for (String[] list : content) {
        		
     	      //    System.out.println(list); 		

        	//}
        	
        	//Csv();
        	
        	csvArray();
        	
        	System.out.println("list command handled");
        	
        	
        	
       }
        
        public static void handleCheckoutCommand(String[] articleNum) {
        	//enter code
        	System.out.println("checkout command handled");

        }
        
        public static void handleCheckinCommand(String[] articleNum) {
        	//enter code
        	System.out.println("checkin command handled");

        }
        
        public static void handleRegisterCommand() {
        	//enter code
        	records.add(products);
        	
        	System.out.println("register command handled");

        }
        
        public static void handleDeregisterCommand(String[] articleNum) {
        	//enter code
        	System.out.println("deregister command handled");

        }
        
        public static void handleInfoCommand(String[] articleNum) {
        	//enter code
        	System.out.println("info command handled");

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
        
}