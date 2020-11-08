
public class Product {

	//add typeidentifier protected string
	
	protected String productType;
	
	public int articleNumber;
	private String productName;
	private int value;
	private Customer borrower;

	public Product(String productType, int article, String name, int price) {
		this.productType = productType;
		this.articleNumber = article;
		this.productName = name;
		this.value = price;
		
		
	}	
	
	public Product(String productType, int article, String name, int price, Customer borrower) {
		this.productType = productType;
		this.articleNumber = article;
		this.productName = name;
		this.value = price;
		this.borrower = borrower;
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}

	public String getProductType() {
		return productType;

	}

	
	public int getArticleNumber() {
		return articleNumber;
	}
	


	public String getProductName() {
		return productName;
	}

	public int getValue() {
		return value;
	}
	/*
public Book castToBook(Object o) {
	
	Book book =(Book)o;
	return book;*/


	
	@Override
	public String toString() {
		return "Article number: " + this.getArticleNumber() + ", Title: " + this.getProductName() + ", Price: "
				+ this.getValue();

	}
}




















