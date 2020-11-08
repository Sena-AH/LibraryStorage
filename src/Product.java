
public class Product {

	//add typeidentifier protected string
	
	protected String productType;
	
	public int articleNumber;
	private String productName;
	private int value;

	public Product(String productType, int article, String name, int price) {
		this.productType = productType;
		this.articleNumber = article;
		this.productName = name;
		this.value = price;
		
		
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

	@Override
	public String toString() {
		return "Article number: " + this.getArticleNumber() + ", Title: " + this.getProductName() + ", Price: "
				+ this.getValue();

	}
}




















