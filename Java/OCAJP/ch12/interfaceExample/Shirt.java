package ch12.interfaceExample;

import ch12.extendsExample.Clothing;

public class Shirt extends Clothing implements Returnable {

	public Shirt(char fit, int itemID, String description, char colorCode, double price) {
		super(itemID, description, colorCode, price);
		this.fit = fit;
	}
	
	private char fit = 'U'; //S=Small,M=Medium,L=Large, U=Unset
	public char getFit() {
		return fit;
	}
	public void setFit(char fit) {
		this.fit = fit;
	}
	
	@Override
	public void display() {
		super.display();
		System.out.println("Fit: " + getFit());
	}

	@Override
	public void doReturn() {
		System.out.println("Could be returned within 3 days");
	}

}
