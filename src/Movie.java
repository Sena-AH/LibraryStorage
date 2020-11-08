

public class Movie extends Product  {

	protected static String identifier = "m";
	private static int lengthInMinutes;
	private static double rating;

	public Movie(String productType, int article, String name, int price, int minutes, double imdb) {

		super(productType, article, name, price);
		Movie.lengthInMinutes = minutes;
		Movie.rating = imdb;
	}
	
	public String getIdentifier() {
		return identifier;
	}

	public static int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public static double getRating() {
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

				" Length in minutes: " + Movie.getLengthInMinutes() + " Rating: " + Movie.getRating();
	}
}
