import java.io.Serializable;

public class Movies extends Products implements Serializable{

	private int lengthInMinutes;
	private int rating;
	
	public Movies(int article, String name, int price, int minutes, int imdb) {
		
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
