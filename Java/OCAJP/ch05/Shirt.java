package ch05;

public class Shirt {

	public int size = 10;
	public double price = 100.5;

	public void display() {
		int size = 5;
		System.out.println(size);
		System.out.println(price);
		/*
		if (5 > 2) {
			int size = 9; // compile error!
			System.out.println(size);
		}
		for (int size;) {// compile error!
			
		}*/
	}

	public static void main(String[] args) {
		new Shirt().display();
	}

}
