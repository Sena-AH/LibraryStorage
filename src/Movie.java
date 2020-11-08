

public class Movie extends Product  {

	protected static String identifier = "m";
	private  int lengthInMinutes;
	private  double rating;
	private Customer borrower;

	public Movie(String productType, int article, String name, int price, int minutes, double imdb) {

		super(productType, article, name, price);
		this.lengthInMinutes = minutes;
		this.rating = imdb;
	}
	
	public Movie(String productType, int article, String name, int price, int minutes, double imdb, Customer borrower) {
		// TODO Auto-generated constructor stub

		super(productType, article, name, price);
		this.lengthInMinutes = minutes;
		this.rating = imdb;
		this.setBorrower(borrower);
	}

	public String getIdentifier() {
		return identifier;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public double getRating() {
		return rating;
	}
	
	public String printList() {
		return "(Movie) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName();	
		}

	@Override
	public int hashCode() {
		String s = "(Movie) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName();
		return s.hashCode();
	}


	@Override
	public String toString() {
		return "(Movie) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName() + " Price: "
				+ this.getValue() +

				" Length in minutes: " + this.getLengthInMinutes() + " Rating: " + this.getRating();
	}

	public Customer getBorrower() {
		return borrower;
	}

	public void setBorrower(Customer borrower) {
		this.borrower = borrower;
	}
}
