package ch12.extendsExample;
// 7. polymorphism usecase
public class DisplayClothing {
	public static void main(String[] args) {
		Clothing c;
		c = new Shirt('L', 1, "my shirt", 'B', 1000.5);
		c.display();
		System.out.println();

		c = new Sock(1, "my sock", 'B', 50);
		c.display();
		System.out.println();

		c = new Trousers('M', 1, "my trouser", 'B', 1200.5);
		c.display();
		System.out.println();
	}
}
