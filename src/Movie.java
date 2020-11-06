import java.io.Serializable;

public class Movie extends Product implements Serializable {

	protected String identifier = "m";
	private int lengthInMinutes;
	private double rating;

	public Movie(int article, String name, int price, int minutes, double imdb) {

		super(article, name, price);
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
		return "Article number: " + this.getArticleNumber() + ", Title: " + this.getProductName() + ", Price: "
				+ this.getValue() +

				" Length in minutes: " + this.getLengthInMinutes() + ", Rating: " + this.getRating();
	}
}
