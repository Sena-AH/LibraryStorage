

public class Movie extends Product  {

	protected static String identifier = "m";
	private int lengthInMinutes;
	private double rating;

	public Movie(String productType, int article, String name, int price, int minutes, double imdb) {

		super(productType, article, name, price);
		this.lengthInMinutes = minutes;
		this.rating = imdb;
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
}
