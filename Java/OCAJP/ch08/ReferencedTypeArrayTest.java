package ch08;
// 2
import ch04.Shirt;

public class ReferencedTypeArrayTest {

	public static void main(String[] args) {

		Shirt s1 = new Shirt();		
		Shirt s2 = new Shirt();
		Shirt shirts[] = {s1, s2};
		
		//s1 和 shirts[0] 指向同一實例
		shirts[0].price = 100;
		System.out.println(s1.price);
		
		System.out.println(s1 == shirts[0]);
		
		//s2 和 shirts[1] 指向同一實例		
		s2.price = 200;
		System.out.println(shirts[1].price);

		System.out.println(s2 == shirts[1]);
		
	}
}
