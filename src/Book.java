
public class Book extends Product {
	
	public boolean book = true;
	
	private int pages;
	private String author;
	
	public Book(int article, String name, int price, int pageNumber, String writer) {
	super(article, name, price);
	this.pages = pageNumber;
	this.author = writer;
	 // om vi skriver super kommer vi kunna köra en set-funktion i products-filen : super.set
	
	}

	public int getPages() {
		return pages;
	}


	public String getAuthor() {
		return author;
	}


	}
	

