import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class LibraryMain {

		
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
	public void saveData() {
		// the massive object to store all our objects!
		ArrayList <Object> data = new ArrayList<Object>();
		/*data.add(myName);
		data.add(myAge);
		data.add(myHobbies);
		data.add(myFriends);*/
		
		// the actuall serilazation 
		
		try {
			FileOutputStream fileOut = new FileOutputStream("data.ser");
			ObjectOutputStream out = new ObjectOutputStream (fileOut);
			out.writeObject(data);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in data.ser");
		}catch (IOException i) {
			i.printStackTrace();
		}
		}
	
	//LinkedList library = new LinkedList(); 
	
	
		}

//HEJ THITI
		
	

























































	
	
