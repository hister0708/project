package res;

public class ResDTO {
	String id;
	String movie;
	String seat;
	int price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return movie;
	}
	public void setName(String MName) {
		this.movie = movie;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return "id : " + id + "movie : " + movie + "seat" + seat + "price" + price;
	}
}
