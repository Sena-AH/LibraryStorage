
public class Book extends Product {

	protected static String identifier = "b";
	private int pages;
	private String author;
	public String customer;

	public Book(int article, String name, int price, int pageNumber, String writer) {
		super(article, name, price);
		this.pages = pageNumber;
		this.author = writer;
		

	}

	public String getIdentifier() {
		return identifier;
	}

	public int getPages() {
		return pages;
	}

	public String getAuthor() {
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
				+ this.getValue() + " Pages: " + this.getPages() + " Author: " + this.getAuthor();

	}
}
	

