package ch11;
// 3. use constructor and overloading
public class Shirt1Test {

	public static void main(String[] args) {

		Shirt1 s1 = new Shirt1(20, 45.12);
		// set other field
		s1.setColorCode('R');
		s1.setDescription("Outdoors Function");
		s1.show();

		// overloading
		s1 = new Shirt1();
		s1.show();



	}

}
