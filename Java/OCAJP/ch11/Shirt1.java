package ch11;
// 3. constructor
public class Shirt1 {

	char colorCode;
	String description;
	double price;
	int size;

	public Shirt1(int size, double price) {
		this.setSize(size);
		this.setPrice(price);
	}

	public Shirt1() {}

	public char getColorCode() {
		return colorCode;
	}

	public void setColorCode(char colorCode) {
		this.colorCode = colorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void show() {
		System.out.println("price=" + price + ", size=" + size);
	}

}
