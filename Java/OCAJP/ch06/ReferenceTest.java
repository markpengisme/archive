package ch06;
// 1
import ch04.Shirt;

public class ReferenceTest {
	public static void main(String[] args) {
		Shirt shirt1 = new Shirt();
		Shirt shirt2 = new Shirt();

		shirt1 = shirt2;

		shirt1.price = 1000;
		shirt2.price = 500;

		System.out.println("Shirt price: " + shirt1.price);

	}

}
