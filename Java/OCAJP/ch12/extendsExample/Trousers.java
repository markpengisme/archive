package ch12.extendsExample;
// 2. extendsExample
public class Trousers extends Clothing {

	public Trousers(char gender, int itemID, String description, char colorCode, double price) {
		super(itemID, description, colorCode, price);
		this.gender = gender;
	}

	private char gender = 'F';	//M=Male, F=Female
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("Gender: " + getGender());
	}
	
}
