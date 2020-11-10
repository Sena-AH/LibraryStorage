
public class Product {

	// This is the superclass for handling products

	protected String productType;
	public int articleNumber;
	private String productName;
	private int value;
	private Customer borrower;

	// Main constructor
	public Product(String productType, int article, String name, int price) {
		this.productType = productType;
		this.articleNumber = article;
		this.productName = name;
		this.value = price;

	}

	// When a customer is added, the main constructor will change to this
	// constructor so that it can have customer as an attribute
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

	// Sets customer as borrower to use in handleCheckoutCommand()
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

	// this method sets customer to null to use in handleCheckinCommand()
	public void remove(Customer borrower2) {
		setBorrower(null);

	}

	@Override
	public String toString() {
		return "Article number: " + this.getArticleNumber() + ", Title: " + this.getProductName() + ", Price: "
				+ this.getValue();

	}

}
