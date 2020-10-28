
public class Movies extends Products{

	protected int lengthInMinutes;
	protected int rating;
	
	protected Movies(int article, String name, int price, int minutes, int imdb) {
		
		super(article, name, price);
		this.lengthInMinutes = minutes;
		this.rating = imdb;
	}
}
