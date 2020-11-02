
public class Movie extends Products{

	private int lengthInMinutes;
	private int rating;
	
	public Movie(int article, String name, int price, int minutes, int imdb) {
		
		super(article, name, price);
		this.lengthInMinutes = minutes;
		this.rating = imdb;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	

	public int getRating() {
		return rating;
	}

	
	
	
}
