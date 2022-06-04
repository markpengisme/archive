package ch11;
// 2. no constructor
public class Shirt0 {

	char colorCode;

	String description;

	double price;

	int size;

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
