import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;



public class LibraryMain {
	
	

	public static void main(String[] args) {
		String filePath = "Movie.csv";
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
	}
	
	

		
	/*
	protected ArrayList<Product> allProducts() {
	ArrayList <Product> products = new ArrayList <Product>();

	Product harrypotter = new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling");
	Product attackontitan = new Movie(9001, "Attack on Titan", 150, 120, 8);
	Product hitchhiker = new Book(1235, "The Hitchhiker's Guide to the Galaxy", 100, 208, "Douglas Adams");
	Product spiritedaway = new Movie(9002, "Spirited Away", 80, 125, 8);
	
	products.add(harrypotter);
	products.add(attackontitan);
	products.add(hitchhiker);
	products.add(spiritedaway);
	
	
	return products;
	
	}
	*/
	// Serialize data
	//public void saveData() {
		// the massive object to store all our objects!
		//ArrayList <Object> data = new ArrayList<Object>();
		/*data.add(myName);
		data.add(myAge);
		data.add(myHobbies);
		data.add(myFriends);*/
		
		// the actuall serilazation 
	
	/*	try {
			FileOutputStream fileOut = new FileOutputStream("data.ser");
			ObjectOutputStream out = new ObjectOutputStream (fileOut);
			out.writeObject(data);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in data.ser");
		}catch (IOException i) {
			i.printStackTrace(); */
		//}
		//}
	
	//LinkedList library = new LinkedList(); 
	
	
	// Manipulera filen via koden så vi kan ändra. Koppla listan till filen så att programmet vet vilken artikelnr den ska ta bort.
	
	public static String filePath = "LibraryProducts.csv";
	
	public static void writeCsv(String filepath) {
		
		ArrayList <Product> products = new ArrayList <Product>();
		
		//demo users
		
		Product harrypotter = new Book(1234, "Harry Potter and the Philosopher's stone", 179, 223, "J.K Rowling");
		products.add(harrypotter);
		
		FileWriter fileWriter = null;
		try {
			fileWriter =new FileWriter(filePath);
			fileWriter.append("article number, name, price, pages, author");
			
			for(Product p: products) {
				//fileWriter.append(p.getArticleNumber());
				fileWriter.append(",");
				fileWriter.append(p.getProductName());
				fileWriter.append(",");
				//fileWriter.append(p.getValue());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void readCsv(String filePath) {
		BufferedReader reader = null;
		
		try {
			ArrayList <Product> products = new ArrayList <Product>();
			String line = "";
			reader = new BufferedReader (new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				
				if(fields.length > 0) {
					Product product = new Product(0, line, 0);
					product.getArticleNumber();
					product.getProductName();
					products.add(product);

					
				}
 			}
			for(Product p: products) {
				System.out.printf("articlenum = %, name = %s",p.getArticleNumber(), p.getProductName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
		}





	
	
