
public class Book extends Product {

	// This class is a subclass of Product and handles the book objects

	private int pages;
	private String author;

	// Main constructor
	public Book(String productType, int article, String name, int price, int pageNumber, String writer) {
		super(productType, article, name, price);
		this.pages = pageNumber;
		this.author = writer;

	}

	// When a customer is added, the main constructor will change to this
	// constructor so that it can have customer as an attribute
	public Book(String productType, int article, String name, int price, int pageNumber, String writer,
			Customer borrower) {
		super(productType, article, name, price, borrower);
		this.pages = pageNumber;
		this.author = writer;

	}

	public int getPages() {
		return pages;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "(Book) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName() + " Price: "
				+ this.getValue() + " Pages: " + this.getPages() + " Author: " + this.getAuthor();

	}
}
