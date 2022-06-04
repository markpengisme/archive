package ch12.extendsExample;
// 2. extendsExample
public class Clothing {

	private int itemID = 0;
	private String description = "-description required-";
	private char colorCode = 'U';
	private double price = 0.0;

	public Clothing(int itemID, String description, char colorCode, double price) {
		this.itemID = itemID;
		this.description = description;
		this.colorCode = colorCode;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getItemID() {
		return itemID;
	}

	public char getColorCode() {
		return colorCode;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setColorCode(char colorCode) {
		this.colorCode = colorCode;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void display() {
		System.out.println("Item ID: " + getItemID());
		System.out.println("Item description: " + getDescription());
		System.out.println("Item price: " + getPrice());
		System.out.println("Color code: " + getColorCode());
	}

}
