
public class Book extends Product {

	protected static String identifier = "b";
	private int pages;
	private String author;

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

	public static boolean isBook() {
		return true;
	}
	
	public String printList() {
		return "(Book) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName();	
		}

	@Override
	public String toString() {
		return "(Book) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName() + " Price: "
				+ this.getValue() + " Pages: " + this.getPages() + " Author: " + this.getAuthor();

	}
}
	

