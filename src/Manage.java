import java.util.*;
import java.io.*;


public class Manage { 
	
	boolean isRunning;

	protected enum Command {

		LIST, CHECKOUT, CHECKIN, REGISTER, DEREGISTER, INFO, QUIT, UNKNOWN

	}

	public static Scanner scanner = new Scanner(System.in);

	public static List<Movie> movies = new ArrayList<>();
	public static List<Book> books = new ArrayList<>();
	
	//public static List<Product> products = new ArrayList<>();

	public static List<Customer> customers = new ArrayList<Customer>();

	public static void main(String[] args) throws FileNotFoundException, IOException {


		System.out.println(" Welcome to the Library system. ");
		System.out.println(" Below you can see the current inventory: ");
		
		readFile();
		printProducts();
		
		boolean on = true;

		while (on) {

			String playerInput = scanner.nextLine();

			Command command = parseCommand(playerInput);
			

			if (command == Command.LIST) {
				handleListCommand();
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.CHECKOUT) {
				int articleArgs1 = parseArgument(playerInput);
				handleCheckoutCommand(articleArgs1);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.CHECKIN) {
				int articleArgs1 = parseArgument(playerInput);
				handleCheckinCommand(articleArgs1);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.REGISTER) {

				handleRegisterCommand();
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.DEREGISTER) {
				int articleArgs1 = parseArgument(playerInput);
				handleDeregisterCommand(articleArgs1);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.INFO) {
				int articleArgs1 = parseArgument(playerInput);
				handleInfoCommand(articleArgs1);
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.UNKNOWN) {

				System.err.println("\nERROR: Unknown command.\n");
				System.out.print("\n\tEnter next command: \n\t > ");

				continue;

			} else if (command == Command.QUIT) {

				System.out.println("\n\tExiting library.. ");
				on = false;
				break;

			}

		}

	}
	
	public static void readFile() {
		

		String filePathMovie = "Products.csv";
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
			
			addMovieToList(lineMovie);
			
				//Book book = parseBook(lineMovie);
	            //System.out.println(book.toString());
	            //Movie movie = parseMovie(lineMovie);
	            //System.out.println(movie.toString());
		

		}
		
		
	}

	private static void writeCsvProducts() {

		// exports objects in arraylist to CSV file

		String objFilePath = "Products.csv";
		try (FileWriter fileWriter = new FileWriter(objFilePath)) {

			//String title = " Article nr; Title; Value in kr; Length in minutes; IMDB rating\n";
			//fileWriter.append(title);

			for (Movie m : movies) {
				String title = " (Movie) Article nr; Title; Value in kr; Length in minutes; IMDB rating\n";
				fileWriter.append(title);
				
				String csvLine = m.getArticleNumber() + ";" + m.getProductName() + ";" + m.getValue() + ";"
						+ m.getLengthInMinutes() + ";" + m.getRating();
				fileWriter.append(csvLine).append("\n");
			}
			
			for (Book b : books) {
				
				String title = " (Book) Article nr; Title; Value in kr; Pages; Author\n";
				fileWriter.append(title);
				
				String csvLine = b.getArticleNumber() + ";" + b.getProductName() + ";" + b.getValue() + ";"
						+ b.getPages() + ";" + b.getAuthor();
				fileWriter.append(csvLine).append("\n");
			}
		/*	
			for (Customer c : customers) {
				
				String title = " Borrowed by: ";
				fileWriter.append(title);
				
			} */

		} catch (IOException e) {
			System.out.println("Error while writing csv");
		}
	}

	public static Book parseBook(String csvLine) {
		// this method creates book object
		
		String[] values = csvLine.split("; ");

		int articleNumber = Integer.parseInt(values[0]);
		String productName = values[1];
		int value = Integer.parseInt(values[2]);
		int pages = Integer.parseInt(values[3]);
		String author = values[4];

		return new Book(articleNumber, productName, value, pages, author);

	}

	public static Movie parseMovie(String csvLine) {
		// this method creates movie object
		String[] values = csvLine.split(";");

		int articleNumber = Integer.parseInt(values[0]);

		String productName = values[1];
		int value = Integer.parseInt(values[2]);
		int lengthInMinutes = Integer.parseInt(values[3]);
		double rating = Double.parseDouble(values[4]);

		return new Movie(articleNumber, productName, value, lengthInMinutes, rating);
	}
	/*
	public static Customer parseCustomer(String name, String number) {
		// this method creates book object
		String fullCustomer = name+ " "+number;
		String[] values = fullCustomer.split(" ");

		
		String customerName = values[0];
		
		String phoneNumber = values[1];

		return new Customer(customerName, phoneNumber);

	}
*/
	public static void printProducts() {
		
		
		for(Movie m : movies) {
			System.out.println(m.printList());
		}
/*
		String filePathMovie = "Products.csv";
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
				//Book book = parseBook(lineMovie);
	            //System.out.println(book.toString());
	            //Movie movie = parseMovie(lineMovie);
	            //System.out.println(movie.toString());
		System.out.println(lineMovie);

		} */
		
		}
/*	
	public static List<Customer> addCustomerToList(String name, String number){
		Customer customer = parseCustomer(name,number);
		customers.add(customer);
		return customers;
	}
*/
	public static List<Book> addBookToList(String input) {
		Book book = parseBook(input);
		books.add(book);
		return books;
	}

	public static List<Movie> addMovieToList(String input) {
		Movie movie = parseMovie(input);
		movies.add(movie);
		return movies;
	}
	
	public static void removeProduct(String filepath, int removeArticlenumber, int position, String limit) {
		
		int pos = position -1;
		String article = Integer.toString(removeArticlenumber); 
		String tempFile = "temp.csv";
		File oldFile = new File(filepath);
		File newFile = new File (tempFile);
		String currentLine;
		String[] data;
		
		try {
			
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			while((currentLine = br.readLine()) != null) {
				
				data = currentLine.split(";");
				if(!(data[pos].equalsIgnoreCase(article))) {
					
					pw.println(currentLine);
				}
			}
			
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File products = new File (filepath);
			newFile.renameTo(products);
			
		} catch (Exception e) {
			
		}
	}

	public static void info(String filepath, int removeArticlenumber, int position, String limit) {
		
		int pos = position -1;
		String article = Integer.toString(removeArticlenumber); 
	
		
		String currentLine;
		String[] data;
		
		try {
			
			
			
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			while((currentLine = br.readLine()) != null) {
				
				data = currentLine.split(";");
				if(data[pos].equalsIgnoreCase(article)) {
					

			        for (String element: data) {
			            System.out.println(element);
			       }					
					

				}
			}
			
			
			fr.close();
			br.close();
		
			
			
			
		} catch (Exception e) {
			
		}
	}

	
	public static void handleListCommand() {
		//make it only show article number and titel, and also if a customer has borrowed it
		System.out.println("This is a list of all our products: ");
		
		printProducts();
		

	}

	public static void handleCheckoutCommand(int articleArgs) {
		// enter code
		//nested objects!!!!!!
		
		//CREATE CUSTOMER ATTRIBUTE IN MOVIE AND BOOK CLASS AND ADD SETTER METHOD TO SET CUSTOMER TO PRODUCT!!!!!!!
		
		//when printing out product in list command, print out customer

		// customer enters name and phonenumber
		// connect product to customer and make it unavailable until checkinCommand()
		System.out.println("Enter name: ");
		String customerName = scanner.nextLine();
		System.out.println("Enter phonenumber: ");
		String phoneNumber = scanner.nextLine();
		
		
	//	addCustomerToList(customerName, phoneNumber);
	//	writeCsvProducts();

		info("Products.csv", articleArgs, 1, ";");

		Customer cus = new Customer(customerName, phoneNumber);

		customers.add(cus);
		
		
		
		//articleArgs connect to cus
		/*
		for (Customer c : customers) {
			System.out.println(c);
		}
*/

		System.out.printf("This product has now been borrowed by %s , %s", customerName, phoneNumber);

		System.out.println("\ncheckout command handled");

		//return cus;
	}

	public static void handleCheckinCommand(int articleArgs) {
		// enter code
		// ta emot artikelnr och kunna gora den tillganglig i listan igen
		// koppla ifran produkten fran customer and make it available
		System.out.println("checkin command handled");

	}

	public static void handleRegisterCommand() throws IOException {
//nested objects!!!!!!
		System.out.println("hej enter b or m:");
		String input = scanner.nextLine();
		char c = input.charAt(0);

		if (c == 'm') {
			
			System.out.println("you have chosen movie");
			System.out.println("Enter: article nr; title; value; length in minutes; rating ");
			String input2 = scanner.nextLine();
			addMovieToList(input2);
			writeCsvProducts();
			
		} else if (c == 'b') {
			
			System.out.println("you have chosen book");
			System.out.println("Enter: article nr; title; value; pages; author ");
			String input3 = scanner.nextLine();
			addBookToList(input3);
			writeCsvProducts();

		}

		System.out.println("register command handled");

	}

	public static void handleDeregisterCommand(int articleArgs) {
		// remove product from the list
		
		removeProduct("Products.csv", articleArgs, 1, ";");
		Movie movieToBeRemoved;
		for(int i = 0; i <movies.size(); i++) {
			
			if(movies.get(i).getArticleNumber() == articleArgs) {
				movieToBeRemoved = movies.get(i);
				movies.remove(movieToBeRemoved);
				return;
			}
			
		}
		System.out.println("deregister command handled");

	}

	public static void handleInfoCommand(int articleArgs) {
		// enter code
		info("Products.csv", articleArgs, 1, ";");
		
		//need to parse record from file using article number to print out info about product
		//solve when solving handleDeregisterCommand()
		
	}

	public static int parseArgument(String playerInput) {

		// CHANGE SO IT WORKS WITH ARRAY LIST AND NOT JUST ARRAY!!
		// MAKE IT PARSE ARTICLENUMBERS

		String[] fullInput = playerInput.split(" ");
		String arguments = new String();

		for (int i = 1; i < fullInput.length; i++) {
			arguments = fullInput[i];
			// int articleArguments = Integer.parseInt(arguments);

		}
		try {
			int articleArguments = Integer.parseInt(arguments);
			// skapa metod som letar i arraylistan efter specifik artikelnummer
			// !!!!!!!!!!!!!
			return articleArguments;
		} catch (NumberFormatException e) {
			System.err.println("SYNTAX ERROR: Articlenumber can only contain numbers");
			System.out.print("\n\tEnter next command: \n\t > ");
		}
		return 0;

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