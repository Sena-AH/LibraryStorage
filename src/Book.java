
public class Book extends Product {

	protected String identifier = "b";
	private int pages;
	private String author;

	public Book(int article, String name, int price, int pageNumber, String writer) {
		super(article, name, price);
		this.pages = pageNumber;
		this.author = writer;
		

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

	@Override
	public String toString() {
		return "Article number: " + this.getArticleNumber() + ", Title: " + this.getProductName() + ", Price: "
				+ this.getValue() + " Pages: " + this.getPages() + ", Author: " + this.getAuthor();

	}
}
	

