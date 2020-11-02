import java.util.Scanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class LibraryMain {

		
		// l�gg in arrayList 
	

	ArrayList <Product> products = new ArrayList <Product>(); // M�ste l�gga till produkter innan jag kan anv�nda Arraylist

	Product harrypotter = new Book(1234, "Harry Potter and the philosophers stone", 200, 300, "J.K Rowling");
	
	
	products.add(harrypotter);
	
	
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
		
	

























































	
	
