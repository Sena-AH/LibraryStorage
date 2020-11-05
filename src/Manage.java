import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
    public static List<Product> products = new ArrayList <Product>();
    public static List<Movie> movies = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

   
  // public static List<String[]> content = new ArrayList<>();
   
   public static List<List<String>> records = new ArrayList<>();
   // public static List<List<Object>> records = new ArrayList<>();
    
    
    public static ArrayList <Customer> customers = new ArrayList <Customer>();
    
        public static void main(String[] args) throws FileNotFoundException, IOException {
        	// add csv code from video in main method!!!!!!!!!!!
            
           // Manage manager = new Manage(); // Instans av hela klassen ("bygga ett hus av ritningen")
            
            //manager.Start();
            
        	
            
            
            //Books book = new Books(123123, "Harry Potter", 200, 700, "jk rowling");
            
            //System.out.println("Article number: " + book.articleNumber );
        	Book got = new Book (777, "Game of thrones", 300, 750, "Sena och Thiti");
       
            
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
      /*  public static void csvArray() throws FileNotFoundException, IOException {
        	
        //	List<List<String>> records = new ArrayList<>();
        	try (BufferedReader br = new BufferedReader(new FileReader("LibraryProducts.csv"))) {
        	    String line;
        	    while ((line = br.readLine()) != null) {
        	        String[] values = line.split(line);
        	        records.add(Arrays.asList(values));
    				System.out.println(line);
    				//FUNKAR Fast ej kunnat l�gga till i arraylist
        	    }
        	}
        }*/
        
       /* 
        public static void addArrayCsv() {
          String csvFile = "LibraryProducts.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
   // List<Entry> People = new ArrayList<>();
    try {
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] Labels = line.split(cvsSplitBy);                 
            Product pro = new Product(Labels[0], Labels[1], Labels[2], Labels[3], Labels[4], Labels[5], Labels[6], Labels[7]);
            products.add(pro);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace(); // Denna vill ha en String i arrayen men vi har blandade datatyper som vi vill f� in
            }
        }
    }
    System.out.print(products);
}
     */
      /*  
        public static Product parseProducts(String lineMovie) {
        	
        		String[] values = lineMovie.split(",");
        		String title = values[0];
        		
        		
        		int articleNumber = Integer.parseInt(values[1]);
        		String productName = values[2];
        		int value = Integer.parseInt(values[3]);
    
	if(book = true ) { 		
        		int pages = Integer.parseInt(values[4]);
        		String author = values[5];
        		return new Book(articleNumber,productName, value, pages, author);
       		
       }else if (values.length >= 6){
       			
        		int lengthInMinutes = Integer.parseInt(values[6]);
        		double rating = Double.parseDouble(values[7]);
        		
       		return new Movie(articleNumber,productName, value, lengthInMinutes, rating);
       		}
        }
        */		
       
        public static Book parseBook(String csvLine) {
        	
    		String[] values = csvLine.split(",");
    		
    		int articleNumber = Integer.parseInt(values[0]);
    		String productName = values[1];
    		int value = Integer.parseInt(values[2]);
    		int pages = Integer.parseInt(values[3]);
    		String author = values[4];
    		
    		return new Book(articleNumber,productName, value, pages, author);

        }
        
        public static Movie parseMovie(String csvLine){
        	
    		String[] values = csvLine.split(",");
    		
    		int articleNumber = Integer.parseInt(values[0]);
    		
    		String productName = values[1];
    		int value = Integer.parseInt(values[2]);
    		int lengthInMinutes = Integer.parseInt(values[3]);
    		double rating = Double.parseDouble(values[4]);
    		
    		return new Movie(articleNumber,productName, value, lengthInMinutes, rating);
   		}
        
       /* 
		public Manage() { // konstruktor
           // LibraryMain library = new LibraryMain (); //libpath - filen man vill spara
           
            products = new ArrayList<Product>();
            
            products.add(new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling"));
        	products.add(new Movie(9001, "Attack on Titan", 150, 120, 8.8));
        	products.add(new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams"));
        	products.add(new Movie(9002, "Spirited Away", 80, 125, 8.6));
     */   	
        	
       // }
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
    	
    	//public static Collection<Product> allProducts() {
    	//ArrayList <Product> products = new ArrayList <Product>();
/*
    	Product harrypotter = new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling");
    	Product attackontitan = new Movie(9001, "Attack on Titan", 150, 120, 8);
    	Product hitchhiker = new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams");
    	Product spiritedaway = new Movie(9002, "Spirited Away", 80, 125, 8);
  */
   /*
    	products.add(new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling"));
    	products.add(new Movie(9001, "Attack on Titan", 150, 120, 8));
    	products.add(new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams"));
    	products.add(new Movie(9002, "Spirited Away", 80, 125, 8));
    	
    	
    	return products;
    	
    	}
*/
	
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
      
        /*
         * JÄTTEBRA KOD MEN NÅR EJ IF SATSERNA!!!!!
         
        public static void printMovieAndBook(String playerInput) {
    		
        	System.out.println("this is the print book and movie method");
        	
    
        	if (playerInput == "m") {
    			System.out.println("you have chosen movie");
    		String filePathMovie = "Movie.csv";
    		FileInputStream fin;
    		try {
    			fin = new FileInputStream(filePathMovie);
    		} catch (FileNotFoundException e) {
    			return;
    		}
    		Scanner scanner = new Scanner(fin);
    		while (scanner.hasNextLine()) {
    			String lineMovie = scanner.nextLine();
    			System.out.println(lineMovie);
    			Movie movie = parseMovie(lineMovie);
                movies.add(movie);
    			
    		} 
    		} else if (playerInput == "b"){
    			System.out.println("you have chosen book");

    		String filePathBook = "Book.csv";
    		FileInputStream fin;
    		try {
    			fin = new FileInputStream(filePathBook);
    		} catch (FileNotFoundException e) {
    			return;
    		}
    		Scanner scanner = new Scanner(fin);
    		while (scanner.hasNextLine()) {
    			String lineBook = scanner.nextLine();
    			System.out.println(lineBook);
    			Book book = parseBook(lineBook);
                books.add(book);
    	} 
    		} 
    		
    	//scanner.close();
    	}
    		
        */
       public static void printMovie() {
    	   
       
    		System.out.println("you have chosen movie");
    		String filePathMovie = "Movie.csv";
    		FileInputStream fin;
    		try {
    			fin = new FileInputStream(filePathMovie);
    		} catch (FileNotFoundException e) {
    			return;
    		}
    		Scanner scanner = new Scanner(fin);
    		scanner.nextLine();
    		while (scanner.hasNextLine()) {
    			String lineMovie = scanner.nextLine();
    			System.out.println(lineMovie);
    			Movie movie = parseMovie(lineMovie);
                movies.add(movie);
    	   
    		}
       }
       
       public static void printBook() {
    	   
    	   System.out.println("you have chosen book");

   		String filePathBook = "Book.csv";
   		FileInputStream fin;
   		try {
   			fin = new FileInputStream(filePathBook);
   		} catch (FileNotFoundException e)  {
   			return;
   		}
   		Scanner scanner = new Scanner(fin);
   		scanner.nextLine();
   		while (scanner.hasNextLine()) {
   			String lineBook = scanner.nextLine();
   			System.out.println(lineBook);
   			Book book = parseBook(lineBook);
               books.add(book);
               
       }
       }

       
        
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
        	
        	//csvArray();
        	
        	//printMovieAndBook();
        	
        	System.out.println("list command handled");
        	
        	
        	
       }
        
        public static void handleCheckoutCommand(String[] articleNum) {
        	//enter code
        	
        	//customer enters name and phonenumber
        	System.out.println("Enter name: ");
        	String customerName = scanner.nextLine();
        	System.out.println("Enter phonenumber: ");
        	String phoneNumber = scanner.nextLine();
        	
        	System.out.printf("This product has now been borrowed by %s , %s", customerName, phoneNumber);

        	
        	
        	System.out.println("\ncheckout command handled");
        	
        }
        
        public static void handleCheckinCommand(String[] articleNum) {
        	//enter code
        	System.out.println("checkin command handled");

        }
        
        public static void handleRegisterCommand() {
        	//enter code
        	//records.add(products);
        	//records.addAll(products);
        	
        	//book.add(parseBook(got));
        	System.out.println("hej enter b or m:");
        	String input= scanner.nextLine();
        	char c = input.charAt(0);
        	
        	if(c == 'm') {
        		printMovie();
        	} else if (c == 'b') {
        		printBook();
        	}
        	
        	
        	//printMovieAndBook(input);
        	
        	
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