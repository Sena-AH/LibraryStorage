
public class Products {

	private int articleNumber;
	private String productName;
	private int value;
	
	public Products(int article, String name, int price) {
		
		this.articleNumber = article;
		this.productName = name;
		this.value = price;
			
		
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

	
}
