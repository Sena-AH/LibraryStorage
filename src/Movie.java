

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
	
	@Override
	public String toString() {
	    return "Length in minutes: " + this.getLengthInMinutes() + 
	           ", Rating: " + this.getRating();
}
}
