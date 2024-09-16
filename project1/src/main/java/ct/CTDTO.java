package ct;

public class CTDTO {
	String Id;
	String Movie;
	String Seat;
	int Price;
	
	public String getId() {
		return Id;
	}
	public void setId(String Id) {
		this.Id = Id;
	}
	public String getMovie() {
		return Movie;
	}
	public void setMovie(String Movie) {
		this.Movie = Movie;
	}
	public String getSeat() {
		return Seat;
	}
	public void setSeat(String Seat) {
		this.Seat = Seat;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int Price) {
		this.Price = Price;
	}
	public String toString() {
		return "id : " + Id + "movie : " + Movie + "seat" + Seat + "price" + Price;
	}
}