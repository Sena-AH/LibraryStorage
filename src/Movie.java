

public class Movie extends Product{
	

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
	
//	public static boolean isBook() {
	//	return false;
//	}
/*
	@Override
	public String toString() {
		return "Movie name: " + productName + " Length in minutes: " + lengthInMinutes;
	}
	
	*/
}
