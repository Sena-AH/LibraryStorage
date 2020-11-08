
public class Book extends Product {

	protected static String identifier = "b";
	private static int pages;
	private static String author;
	public String customer;

	public Book(String productType, int article, String name, int price, int pageNumber, String writer) {
		super(productType, article, name, price);
		Book.pages = pageNumber;
		Book.author = writer;
		

	}

	public String getIdentifier() {
		return identifier;
	}

	public static int getPages() {
		return pages;
	}

	public static String getAuthor() {
		return author;
	}
/*	
	public static Customer setCustomerBook(String name, String number) {
		Customer customer = new Customer(name, number);
		
		
		return customer;
		
	}
*/
	
	
	public static boolean isBook() {
		return true;
	}
	
	public String printList() {
	return "(Book) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName();	
		}
	
	@Override
	public int hashCode() {
		String s = "(Book) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName();
		return s.hashCode();
	}

	@Override
	public String toString() {
		return "(Book) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName() + " Price: "
				+ this.getValue() + " Pages: " + Book.getPages() + " Author: " + Book.getAuthor();

	}
}
	

