package type;

public class Desc {
	int typeno;
	String typename;
	int price;
	int gross;
	
	public Desc(int typeno,String typename,int price,int gross) {
		this.typeno=typeno;
		this.typename=typename;
		this.price=price;
		this.gross=gross;
	}
	
	public int getTypeno() {
		return typeno;
	}
	public void setTypeno(int typeno) {
		this.typeno = typeno;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGross() {
		return gross;
	}
	public void setGross(int gross) {
		this.gross = gross;
	}
}
