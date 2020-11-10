import java.util.*;
import java.io.*;

public class Manage {

	//This class manages all the commands from the user
	
	boolean isRunning;

	protected enum Command {

		LIST, CHECKOUT, CHECKIN, REGISTER, DEREGISTER, INFO, QUIT, UNKNOWN

	}

	public static Scanner scanner = new Scanner(System.in);

	public static List<Product> products = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println(" �-*-� Welcome to the Library system �-*-� ");
		System.out.println(" - Below you can see the current inventory - \n");

		readFile();
		printProducts();

		System.out.print("\n\tEnter command: \n\t > ");

		boolean on = true;

		while (on) {

			String playerInput = scanner.nextLine();

			Command command = parseCommand(playerInput);
			
			//if statements to handle command methods
			
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
		
		//method to read the csv file and calling a method for adding products in the list
		
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
		
		//method to split movie and book products 
		
		if (line.startsWith("Movie")) {
			addMovieToList(line);
		} else if (line.startsWith("Book")) {
			addBookToList(line);
		}
	}

	private static void writeCsvProducts() {

		// this method exports products in list to CSV file

		String objFilePath = "Products.csv";
		try (FileWriter fileWriter = new FileWriter(objFilePath)) {

			String title = "Movie/Book;Article nr;Title;Value in kr;Length in minutes/pages;IMDB rating/author;Customer name;Customer phonenumber\n";
			fileWriter.append(title);
			
			//export movie products
			for (Product m : products) {

				if (m.productType.equals("Movie") && m.getBorrower() == null) {

					Movie movie = (Movie) m;

					String csvLine1 = m.getProductType() + ";" + m.getArticleNumber() + ";" + m.getProductName() + ";"
							+ m.getValue() + ";" + movie.getLengthInMinutes() + ";" + movie.getRating();

					fileWriter.append(csvLine1).append("\n");

				}
				//checks if product has been borrowed by customer
				if (m.productType.equals("Movie") && m.getBorrower() != null) {

					Product product = (Product) m;
					Movie movie = (Movie) m;
					String csvLine2 = product.getProductType() + ";" + m.getArticleNumber() + ";" + m.getProductName()
							+ ";" + m.getValue() + ";" + movie.getLengthInMinutes() + ";" + movie.getRating() + ";"
							+ m.getBorrower().getCustomerName() + ";" + m.getBorrower().getPhoneNumber();

					fileWriter.append(csvLine2).append("\n");
				}

			}
			//export book products
			for (Product b : products) {

				if (b.productType.equals("Book") && b.getBorrower() == null) {

					Book book = (Book) b;

					String csvLine1 = b.getProductType() + ";" + b.getArticleNumber() + ";" + b.getProductName() + ";"
							+ b.getValue() + ";" + book.getPages() + ";" + book.getAuthor();

					fileWriter.append(csvLine1).append("\n");

				}
				
				//checks if product has been borrowed by customer		
				if (b.productType.equals("Book") && b.getBorrower() != null) {

					Product product = (Product) b;

					Book book = (Book) b;

					String csvLine2 = product.getProductType() + ";" + b.getArticleNumber() + ";" + b.getProductName()
							+ ";" + b.getValue() + ";" + book.getPages() + ";" + book.getAuthor() + ";"
							+ b.getBorrower().getCustomerName() + ";" + b.getBorrower().getPhoneNumber();

					fileWriter.append(csvLine2).append("\n");

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Book parseBook(String csvLine) throws NumberFormatException {
		
		// this method parses input to initialize book objects
		
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

		// this method parses input to initialize movie objects

		String[] values = csvLine.split(";");

		String productType = values[0];
		int articleNumber = Integer.parseInt(values[1]);

		String productName = values[2];
		int value = Integer.parseInt(values[3]);
		int lengthInMinutes = Integer.parseInt(values[4]);
		double rating = Double.parseDouble(values[5]);
		if (rating > 10.0) {
			RuntimeException e = new RuntimeException("INPUT ERROR: IMDB rating too high. Needs to be less than 10.0.");
			throw e;
		}
		if (values.length == 8) {
			Customer borrower = new Customer(values[6], values[7]);

			return new Movie(productType, articleNumber, productName, value, lengthInMinutes, rating, borrower);
		}
		return new Movie(productType, articleNumber, productName, value, lengthInMinutes, rating);
	}

	public static void printProducts() {

		//this method prints out the products in the list to the console	
		
		for (Product p : products) {

			if (p.getBorrower() == null) {
				System.out.println("(" + p.getProductType() + ")" + " Article number: " + p.getArticleNumber()
						+ " Title: " + p.getProductName() + "\n");

			} else if (p.getBorrower() != null) {
				System.out.println("(" + p.getProductType() + ")" + " Article number: " + p.getArticleNumber()
						+ " Title: " + p.getProductName() + "\n Borrowed by: " + p.getBorrower().getCustomerName()
						+ ", Phonenumber: " + p.getBorrower().getPhoneNumber() + "\n");

			}
		}

	}

	public static List<Product> addBookToList(String input) {

		//method to add initialized book objects in list
		
		Product book = parseBook(input);
		if (!(products.contains(book))) {

			products.add(book);
		}
		return products;

	}

	public static List<Product> addMovieToList(String input) {		//	throws FileNotFoundException {

		//method to add initialized movie objects in list

		Product movie = parseMovie(input);
		if (!(products.contains(movie))) {

			products.add(movie);
		}

		return products;

	}

	public static void removeProduct(String filepath, int removeArticlenumber, int position, String limit) {

		//this method removes a record from the csv file by duplicating the wanted objects onto a new file, leaving the unwanted object, then deleting the old file
		
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

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void info(String filepath, int removeArticlenumber, int position, String limit) {

		//a method to print out a products full information by parsing the values of the product into an array 
		
		String article = Integer.toString(removeArticlenumber);

		String currentLine;
		String[] data;

		try {

			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);

			while ((currentLine = br.readLine()) != null) {

				data = currentLine.split(";");
				if (data[1].equalsIgnoreCase(article)) {

					System.out.println(
							"\nMovie/Book, Article nr, Title, Value in kr, Length in minutes/pages, IMDB rating/author, Customer name, Customer phonenumber\n");

					for (String element : data) {
						System.out.print(element + ",  ");

					}
					System.out.println(" ");
				}
			}
			fr.close();
			br.close();

		} catch (Exception e) {

		}
	}

	public static void checkArticleNumber(String input) {
		
		//a method using the article number input to check if the product already exists or if its not a valid input

		String[] inputArray = input.split(";");

		try {
			FileReader fr = new FileReader("Products.csv");

			BufferedReader br = new BufferedReader(fr);

			String currentLine;

			while ((currentLine = br.readLine()) != null) {

				String[] fileArray = currentLine.split(";");

				for (Product p : products) {

					String article = String.valueOf(p.getArticleNumber());

					if ((inputArray[1].equalsIgnoreCase(article)) && (fileArray[1].equalsIgnoreCase(inputArray[1]))) {

						RuntimeException error = new RuntimeException(
								"ERROR: Product already exists or input is not valid.");
						throw error;
					}

				}

			}
			fr.close();
			br.close();
		} catch (IOException e) {
			e.getMessage();

		}

	}

	public static void articleNumberDoesNotExist(int articleArgs) {
		
		//a method to check if the article number does not exist in the list, meaning that the product does not exist

		boolean articleNumberDoesNotExist = true;

		for (Product p : products) {

			String article = String.valueOf(articleArgs);

			String articleList = String.valueOf(p.getArticleNumber());

			if (article.equalsIgnoreCase(articleList)) {
				articleNumberDoesNotExist = false;
			}
		}

		if (articleNumberDoesNotExist) {
			throw new RuntimeException("ERROR: Article number does not exist.");
		}

	}

	public static void handleListCommand() {
		
		//prints out the products in the inventory

		System.out.println("This is a list of all our products: \n");

		printProducts();

	}

	public static void handleCheckoutCommand(int articleArgs) {
		
		//checks out the specified product to the customer

		try {
			
			//if product if already borrowed by a customer, an exception will be thrown
			articleNumberDoesNotExist(articleArgs);

			for (Product p : products) {
				if (p.getArticleNumber() == articleArgs) {

					if (p.getBorrower() != null) {
						Exception e = new Exception("ERROR: Product has already been borrowed");
						throw e;
					}

				}

			}
			
			//creates new customer object that connects with the specified product by adding the customer as an attribute to the product
			System.out.println("Enter name: ");
			String customerName = scanner.nextLine();
			System.out.println("Enter phonenumber: ");
			String phoneNumber = scanner.nextLine();

			Customer customer = new Customer(customerName, phoneNumber);

			for (final Product product : products) {
				if (product.getArticleNumber() == articleArgs) {
					product.setBorrower(customer);
				}

			}

			writeCsvProducts();

		} catch (RuntimeException E) {
			System.err.println("ERROR: Article number does not exist.");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void handleCheckinCommand(int articleArgs) throws IOException {
		
		//customer returns the product, making it available again by removing the customer as an attribute in the product

		try {
			articleNumberDoesNotExist(articleArgs);

			for (Product product : products) {

				if (product.getArticleNumber() == articleArgs) {
					
					//checks if there is a customer connected to the product to make sure the product can be returned
					if (product.getBorrower() == null) {

						Exception E = new Exception(
								"ERROR: Product needs to be borrowed before customer can checkin product.");
						throw E;
					}
					
					//removes customer as attribute in product
					if (product.productType.equals("Movie")) {

						product.remove(null);

					} else if (product.productType.equals("Book")) {

						product.remove(null);

					}
				}
				writeCsvProducts();

			}
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());

		} catch (Exception E) {
			System.err.println(E.getMessage());
		}
		System.out.println("checkin command handled");

	}

	public static void handleRegisterCommand() throws IOException {
		
		////this method registers new products into the list and file. customer types in the values of the attributes, and if the input is valid, a new product will be created

		System.out.println("To register new product, enter the type of product. Enter m/M for movie or b/B for book: ");
		String input = scanner.nextLine();
		char c = input.charAt(0);
		
		//separates books from movies and adds product to list
		if (c == 'm' || c == 'M') {

			System.out.println("You have chosen movie");
			System.out.println("Enter (without spacing): product type;article number;name of movie;price;length in minutes;rating ");
			String input2 = scanner.nextLine();
			try {
				checkArticleNumber(input2);
				addMovieToList(input2);
				writeCsvProducts();

			} catch (RuntimeException e) {
				System.err.println(e.getMessage());

				System.out.print("\n\tEnter next command: \n\t > ");
			}

		} else if (c == 'b' || c == 'B') {

			System.out.println("You have chosen book");
			System.out.println("Enter(without spacing): product type;article number;name of book;price;amount of pages;author ");
			String input3 = scanner.nextLine();

			try {
				checkArticleNumber(input3);
				addBookToList(input3);
				writeCsvProducts();
			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
				System.out.print("\n\tEnter next command: \n\t > ");
			}

		}

		System.out.println("register command handled");

	}

	public static void handleDeregisterCommand(int articleArgs) {
		
		//removes product from the list and copying the list to the file
		
		try {

			articleNumberDoesNotExist(articleArgs);
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
		} catch (RuntimeException e) {
			System.err.println("ERROR: Article number does not exist.");
		}

		System.out.println("deregister command handled");
	}

	public static void handleInfoCommand(int articleArgs) {

		//prints full information about product
		
		try {
			articleNumberDoesNotExist(articleArgs);
			info("Products.csv", articleArgs, 1, ";");

		} catch (RuntimeException e) {
			System.err.println("ERROR: Article number does not exist.");
		}

	}

	public static int parseArgument(String playerInput) {

		//parses argument from input and checks for syntax error
		
		String[] fullInput = playerInput.split(" ");
		String arguments = new String();

		for (int i = 1; i < fullInput.length; i++) {
			arguments = fullInput[i];

		}
		try {
			int articleArguments = Integer.parseInt(arguments);

			return articleArguments;
		} catch (NumberFormatException e) {
			System.err.println("SYNTAX ERROR: Articlenumber can only contain numbers");
			System.out.print("\n\tEnter next command: \n\t > ");
		}
		return 0;

	}

	public static Command parseCommand(String playerInput) {
		
		//parses command from input

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