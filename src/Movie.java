import java.io.Serializable;

public class Movie extends Product implements Serializable{

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
/*
	@Override
	public String toString() {
		return "Movie name: " + productName + " Length in minutes: " + lengthInMinutes;
	}
	
	*/
}
