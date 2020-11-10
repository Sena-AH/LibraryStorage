
public class Movie extends Product {

	// This class is a subclass of Product and handles the movie objects

	private int lengthInMinutes;
	private double rating;

	// Main constructor
	public Movie(String productType, int article, String name, int price, int minutes, double imdb) {

		super(productType, article, name, price);
		this.lengthInMinutes = minutes;
		this.rating = imdb;
	}

	// When a customer is added, the main constructor will change to this
	// constructor so that it can have customer as an attribute
	public Movie(String productType, int article, String name, int price, int minutes, double imdb, Customer borrower) {

		super(productType, article, name, price, borrower);
		this.lengthInMinutes = minutes;
		this.rating = imdb;

	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "(Movie) Article number: " + this.getArticleNumber() + " Title: " + this.getProductName() + " Price: "
				+ this.getValue() +

				" Length in minutes: " + this.getLengthInMinutes() + " Rating: " + this.getRating();
	}

}
