import java.util.*;
import java.io.*;
import java.nio.*;

 
public class Manage implements Serializable { // Manager tolkar vad du vill gÃ¶ra och startar funktion i libraryklassen.
	// Library kommer skapa instanser av bÃ¶cker och filmer.
	boolean isRunning;

	protected enum Command {

		LIST, CHECKOUT, CHECKIN, REGISTER, DEREGISTER, INFO, QUIT, UNKNOWN

	}

	public static Scanner scanner = new Scanner(System.in);

	public static List<Movie> movies = new ArrayList<>();
	public static List<Book> books = new ArrayList<>();

	public static ArrayList<Customer> customers = new ArrayList<Customer>();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Book got = new Book(777, "Game of thrones", 300, 750, "Sena och Thiti");

		System.out.println(" Welcome to the Library system. ");
		System.out.println(" Below you can see the current inventory: ");

		boolean on = true;

		while (on) {

			String playerInput = scanner.nextLine();

			Command command = parseCommand(playerInput);
			String [] arguments = parseArgument(playerInput);

			if (command == Command.LIST) {
				handleListCommand();
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.CHECKOUT) {

				handleCheckoutCommand(arguments);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.CHECKIN) {

				handleCheckinCommand(arguments);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.REGISTER) {

				handleRegisterCommand();
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.DEREGISTER) {

				handleDeregisterCommand(arguments);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.INFO) {

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

	}

	public static Book parseBook(String csvLine) {

		String[] values = csvLine.split(";");

		int articleNumber = Integer.parseInt(values[0]);
		String productName = values[1];
		int value = Integer.parseInt(values[2]);
		int pages = Integer.parseInt(values[3]);
		String author = values[4];

		return new Book(articleNumber, productName, value, pages, author);

	}

	public static Movie parseMovie(String csvLine) {

		String[] values = csvLine.split(";");

		int articleNumber = Integer.parseInt(values[0]);

		String productName = values[1];
		int value = Integer.parseInt(values[2]);
		int lengthInMinutes = Integer.parseInt(values[3]);
		double rating = Double.parseDouble(values[4]);

		return new Movie(articleNumber, productName, value, lengthInMinutes, rating);
	}

	public static void printMovie(String input) throws IOException {

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
			// Movie movie = parseMovie(lineMovie);
			// movies.add(movie);

		}

		// FileOutputStream fo;
		Movie movie = parseMovie(input);
		movies.add(movie);
		/*
		 * try { fo = new FileOutputStream(filePathMovie); ObjectOutputStream oos = new
		 * ObjectOutputStream(fo);
		 * 
		 * oos.writeObject(movie); oos.flush(); oos.close(); } catch (IOException e){
		 * e.printStackTrace(); }
		 */

		/*
		 * String objFilePath = "Movie.csv"; FileOutputStream fout = new
		 * FileOutputStream(objFilePath); ObjectOutputStream oout = new
		 * ObjectOutputStream(fout); oout.writeObject(movie.toString()); oout.close();
		 */
		for (Movie m : movies) {
			System.out.println(m);
		}
	}

	public static void printBook(String input) {

		System.out.println("you have chosen book");

		String filePathBook = "Book.csv";
		FileInputStream fin;
		try {
			fin = new FileInputStream(filePathBook);
		} catch (FileNotFoundException e) {
			return;
		}
		Scanner scanner = new Scanner(fin);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			String lineBook = scanner.nextLine();
			System.out.println(lineBook);

		}
		Book book = parseBook(input);
		books.add(book);
		for (Book b : books) {
			System.out.println(b);
		}
	}

	public static void handleListCommand() throws FileNotFoundException, IOException {
		
		System.out.println("This is a list of all our products: ");
		
		for (Movie m : movies) {
			System.out.println(m);
		}
		
		for (Book b : books) {
			System.out.println(b);
		}
		// Använda customerobjektet nedan och använda det här uppe! Hur gör man utan att kopiera och klistra in?
		//System.out.println(customers.cus + "has borrowed this product");

	}

	public static Customer handleCheckoutCommand(String[] articleNum) {
		// enter code

		// customer enters name and phonenumber
		//connect product to customer and make it unavailable until checkinCommand()
		System.out.println("Enter name: ");
		String customerName = scanner.nextLine();
		System.out.println("Enter phonenumber: ");
		String phoneNumber = scanner.nextLine();

		Customer cus = new Customer(customerName, phoneNumber);

		customers.add(cus);
		
		for(Customer c : customers) {
			System.out.println(c);
		}

		System.out.printf("This product has now been borrowed by %s , %s", customerName, phoneNumber);

		System.out.println("\ncheckout command handled");
			
			return cus;
	}

	public static void handleCheckinCommand(String[] articleNum) {
		// enter code
		//ta emot artikelnr och kunna gora den tillganglig i listan igen 
		// koppla ifran produkten fran customer and make it available
		System.out.println("checkin command handled");

	}

	public static void handleRegisterCommand() throws IOException {

		System.out.println("hej enter b or m:");
		String input = scanner.nextLine();
		char c = input.charAt(0);

		if (c == 'm') {
			System.out.println("Enter: article nr; title; value; length in minutes; rating ");
			String input2 = scanner.nextLine();
			printMovie(input2);
		} else if (c == 'b') {
			System.out.println("Enter: article nr; title; value; pages; author ");
			String input3 = scanner.nextLine();
			printBook(input3);
		}

		System.out.println("register command handled");

	}

	public static void handleDeregisterCommand(String[] articleNum) {
		// remove product from the list 
				
		int i = books.indexOf(articleNum); 
		books.remove(i);
		
		
		int i2 = movies.indexOf(articleNum);
		books.remove(i2);
	
		System.out.println("deregister command handled");

	}

	public static void handleInfoCommand(String[] articleNum) {
		// enter code
		System.out.println("info command handled");

	}

	public static String[] parseArgument(String playerInput) {

		// CHANGE SO IT WORKS WITH ARRAY LIST AND NOT JUST ARRAY!!
		// MAKE IT PARSE ARTICLENUMBERS
		
		System.out.println("Hello from parseArgument!!!!");
		String[] fullInput = playerInput.split(" ");
		String[] arguments = new String[fullInput.length -1 ];
		
		for (int i = 1; i < fullInput.length; i++) {
			arguments[i -1] = fullInput[i];
			
			System.out.println("Parseargument for-looooooop!!!");
			
			/*try {
				//MAKE SURE INPUT IS INT TO BE VALID
				//if(arguments != scanner.nextInt)
			} catch ( Error e)
			{
				System.err.println("SYNTAX ERROR: Not a valid article number."); 
			}*/
			
			/*switch (arguments) {

			case int:
				return arguments;

			default:
				return System.err.println("SYNTAX ERROR: not valid article nr. ");*/

			
		}
		
		return arguments;
		
		

	}

	public static Command parseCommand(String playerInput) {

		String commandString = playerInput.split(" ")[0];

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