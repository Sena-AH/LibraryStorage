
public class Books extends Products {
	
	
	protected int pages;
	protected String author;
	
	protected Books(int article, String name, int price, int pageNumber, String writer) {
	super(article, name, price);
	this.pages = pageNumber;
	this.author = writer;
	
	
	}
	
}
