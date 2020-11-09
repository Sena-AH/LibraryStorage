import java.util.*;
import java.io.*;

public class Manage {

	boolean isRunning;

	protected enum Command {

		LIST, CHECKOUT, CHECKIN, REGISTER, DEREGISTER, INFO, QUIT, UNKNOWN

	}

	public static Scanner scanner = new Scanner(System.in);

	public static List<Product> products = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println(" °-*-° Welcome to the Library system °-*-° ");
		System.out.println(" - Below you can see the current inventory - \n");

		readFile();
		printProducts();
		
		System.out.print("\n\tEnter command: \n\t > ");


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

				System.err.println("\n\tERROR: Unknown command.\n");
				System.out.println("\n\tEnter next command: \n\t > ");

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

			String line = scanner.nextLine();

			try {
				addProduct(line);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	public static void addProduct(String line) throws FileNotFoundException, ClassCastException {
		if (line.startsWith("Movie")) {
			addMovieToList(line);
		} else if (line.startsWith("Book")) {
			addBookToList(line);
		}
	}

	private static void writeCsvProducts() {

		// exports objects in arraylist to CSV file

		String objFilePath = "Products.csv";
		try (FileWriter fileWriter = new FileWriter(objFilePath)) {

			// String title = " Article nr; Title; Value in kr; Length in minutes; IMDB
			// rating\n";
			// fileWriter.append(title);
			String title = "Movie/Book; Article nr; Title; Value in kr; Length in minutes/pages; IMDB rating/author; Customer name; Customer phonenumber\n";
			fileWriter.append(title);
			for (Product m : products) {

				// Movie movie = (Movie)m;

				// instancof product m instance of movie ist för ifsats

				if (m.productType.equals("Movie") && m.getBorrower() == null) {
					// String title = "(Movie) Article nr; Title; Value in kr; Length in minutes;
					// IMDB rating\n";
					// fileWriter.append(title);
					Movie movie = (Movie) m;

					String csvLine1 = m.getProductType() + ";" + m.getArticleNumber() + ";" + m.getProductName() + ";"
							+ m.getValue() + ";" + movie.getLengthInMinutes() + ";" + movie.getRating();

					fileWriter.append(csvLine1).append("\n");

				}	if (m.productType.equals("Movie") && m.getBorrower() != null) {

					Product product = (Product) m;
					Movie movie = (Movie) m;
					String csvLine2 = product.getProductType() + ";" + m.getArticleNumber() + ";" + m.getProductName()
							+ ";" + m.getValue() + ";" + movie.getLengthInMinutes() + ";" + movie.getRating() + ";"
							+ m.getBorrower().getCustomerName() + ";" + m.getBorrower().getPhoneNumber();

					fileWriter.append(csvLine2).append("\n");
				}
			
			}

			for (Product b : products) {

				// Book book =(Book)b;
				// Product product = (Product)b;

				if (b.productType.equals("Book") && b.getBorrower() == null) {

					// Product.castToBook(b);
					Book book = (Book) b;

					String csvLine1 = b.getProductType() + ";" + b.getArticleNumber() + ";" + b.getProductName() + ";"
							+ b.getValue() + ";" + book.getPages() + ";" + book.getAuthor();

					fileWriter.append(csvLine1).append("\n");

				}if (b.productType.equals("Book") && b.getBorrower() != null) {

					Product product = (Product) b;

					Book book = (Book) b;

					String csvLine2 = product.getProductType() + ";" + b.getArticleNumber() + ";" + b.getProductName()
							+ ";" + b.getValue() + ";" + book.getPages() + ";" + book.getAuthor() + ";"
							+ b.getBorrower().getCustomerName() + ";" + b.getBorrower().getPhoneNumber();

					fileWriter.append(csvLine2).append("\n");

				}
				
			}

		} catch (IOException e) {
			System.out.println("Error while writing csv");
		}
	}

	public static Book parseBook(String csvLine) throws NumberFormatException {
		// this method creates book object

		String[] values = csvLine.split(";");

		String productType = values[0];
		int articleNumber = Integer.parseInt(values[1]);

		String productName = values[2];
		int value = Integer.parseInt(values[3]);
		int pages = Integer.parseInt(values[4]);
		String author = values[5];

		if (values.length == 8) {
			Customer borrower = new Customer(values[6], values[7]);

			return new Book(productType, articleNumber, productName, value, pages, author, borrower);
		}
		return new Book(productType, articleNumber, productName, value, pages, author);

	}

	public static Movie parseMovie(String csvLine) {
		// this method creates movie object
		String[] values = csvLine.split(";");

		String productType = values[0];
		int articleNumber = Integer.parseInt(values[1]);

		String productName = values[2];
		int value = Integer.parseInt(values[3]);
		int lengthInMinutes = Integer.parseInt(values[4]);
		double rating = Double.parseDouble(values[5]);

		if (values.length == 8) {
			Customer borrower = new Customer(values[6], values[7]);

			return new Movie(productType, articleNumber, productName, value, lengthInMinutes, rating, borrower);
		}
		return new Movie(productType, articleNumber, productName, value, lengthInMinutes, rating);
	}

	public static void printProducts() {

		for (Product p : products) {
			
			if (p.getBorrower() == null) {
			System.out.println(p.getProductType() + " Article number: " + p.getArticleNumber() + " Title: " + p.getProductName() + "\n");
			
			} else if (p.getBorrower() != null) {
				System.out.println(p.getProductType() + " Article number: " + p.getArticleNumber() + " Title: " + p.getProductName() +
				"\n Borrowed by: " + p.getBorrower().getCustomerName() + ", Phonenumber: " + p.getBorrower().getPhoneNumber() + "\n");

				
			}
			}
		
	}

	public static List<Product> addBookToList(String input) {

		Product book = parseBook(input);
		if (!(products.contains(book))) {

			products.add(book);
		}
		return products;

	}

	public static List<Product> addMovieToList(String input) throws FileNotFoundException {
		Product movie = parseMovie(input);
		if (!(products.contains(movie))) {

			products.add(movie);
		}

		return products;

	}

	public static void removeProduct(String filepath, int removeArticlenumber, int position, String limit) {

		int pos = position - 1;
		String article = Integer.toString(removeArticlenumber);
		String tempFile = "temp.csv";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String currentLine;
		String[] data;

		try {

			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);

			while ((currentLine = br.readLine()) != null) {

				data = currentLine.split(";");
				if (!(data[pos].equalsIgnoreCase(article))) {

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
			File products = new File(filepath);
			newFile.renameTo(products);

		} catch (Exception e) {

		}
	}

	public static void info(String filepath, int removeArticlenumber, int position, String limit) {

		//int pos = position - 1;
		String article = Integer.toString(removeArticlenumber);

		String currentLine;
		String[] data;

		try {

			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);

			while ((currentLine = br.readLine()) != null) {

				data = currentLine.split(";");
				if (data[1].equalsIgnoreCase(article)) {
					
				System.out.println("\nMovie/Book, Article nr, Title, Value in kr, Length in minutes/pages, IMDB rating/author, Customer name, Customer phonenumber\n");

					 	for (String element : data) {
						System.out.print(element + ",  ");
						
				}
					 	System.out.println(" ");
				}
			}
			fr.close();
			br.close();
			
			}
			catch (Exception e) {

		}
		}
	
	public static boolean checkArticleNumber(String input) {
		
		
		
		for(Product p : products) {
			if (p.toString().equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;	
	}

	public static void handleListCommand() {
		// make it only show article number and titel, and also if a customer has
		// borrowed it
		System.out.println("This is a list of all our products: ");

		printProducts();

		// TRY ADDING IN MAIN METHOD TO FIX PRINTING PROBLEM!
	}

	public static void handleCheckoutCommand(int articleArgs) {
		
		
		try {
			for(Product p : products) {
			if (p.getArticleNumber() == articleArgs) {
				
				if (p.getBorrower() != null) {
					
					Exception e = new Exception("ERROR: Product has already been borrowed");
					throw e;
				}

			} 
			}  
			
			
		
		
		System.out.println("Enter name: ");
		String customerName = scanner.nextLine();
		System.out.println("Enter phonenumber: ");
		String phoneNumber = scanner.nextLine();

		Customer customer = new Customer(customerName, phoneNumber);

		for (final Product product : products) {
			if (product.getArticleNumber() == articleArgs) {
				product.setBorrower(customer);
			}
			/*
			 * if(product.getBorrower().equals(customer)) {
			 * 
			 * }
			 */
		}

		writeCsvProducts();
			}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			//continue;
            //System.exit(0);

		}


	}

	public static void handleCheckinCommand(int articleArgs) {
		// enter code
		// ta emot artikelnr och kunna gora den tillganglig i listan igen
		// koppla ifran produkten fran customer and make it available
		for (Product product : products) {
			
			if (product.getArticleNumber() == articleArgs) {
				
				if (product.productType.equals("Movie")) {
					
					product.remove(null);
					
					
					
				} else if (product.productType.equals("Book")) {
				
					product.remove(null);

				}
			}
			writeCsvProducts();
/*
			try {
				if (!(products.contains(articleArgs))) {
					Exception e = new Exception("ERROR: Articlenumber does not exist");
					throw e;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}*/

		}
		System.out.println("checkin command handled");
	}

	public static void handleRegisterCommand() throws IOException {

		// nested objects!!!!!!
		System.out.println("hej enter b or m:");
		String input = scanner.nextLine();
		char c = input.charAt(0);

		if (c == 'm') {

			System.out.println("you have chosen movie");
			System.out.println("Enter: product type; article nr; title; value; length in minutes; rating ");
			String input2 = scanner.nextLine();
			checkArticleNumber(input2);
			addMovieToList(input2);
			writeCsvProducts();

		} else if (c == 'b') {

			System.out.println("you have chosen book");
			System.out.println("Enter: product type; article nr; title; value; pages; author ");
			String input3 = scanner.nextLine();
			checkArticleNumber(input3);
			addBookToList(input3);
			writeCsvProducts();

		}

		System.out.println("register command handled");

	}

	public static void handleDeregisterCommand(int articleArgs) {
		// remove product from the list

		removeProduct("Products.csv", articleArgs, 1, ";");
		Product movieToBeRemoved;
		Product bookToBeRemoved;
		for (int i = 0; i < products.size(); i++) {

			if (products.get(i).getArticleNumber() == articleArgs) {
				movieToBeRemoved = products.get(i);
				products.remove(movieToBeRemoved);
				writeCsvProducts();

				return;
			}

		}

		for (Product b : products) {
			int i = 0;
			if (products.get(i).getArticleNumber() == articleArgs) {
				bookToBeRemoved = products.get(i);
				products.remove(bookToBeRemoved);
				writeCsvProducts();

				return;
			}
		}
		

		
		System.out.println("deregister command handled");
//use for checkout?
	}

	public static void handleInfoCommand(int articleArgs) {
		// enter code
		info("Products.csv", articleArgs, 1, ";");
		
		

		// need to parse record from file using article number to print out info about
		// product
		// solve when solving handleDeregisterCommand()

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

		
			for (Product product : products) {

			if (product.getArticleNumber() == articleArguments && product.getBorrower() == null) {
			
				Exception error = new Exception("ERROR; Articlenumber already exists.");
			throw error;
			}
			return articleArguments;

			}
		} catch (NumberFormatException e) {
			System.err.println("SYNTAX ERROR: Articlenumber can only contain numbers");
			System.out.print("\n\tEnter next command: \n\t > ");
		}
		
		
				
		catch (Exception error){
			System.out.println(error.getMessage());

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