package ch11;
// 2. many setter
public class Shirt0Test {

	public static void main(String args[]) {
		Shirt0 s0 = new Shirt0();
		// set values
		s0.setColorCode('R');
		s0.setDescription("Outdoors Function");
		s0.setPrice(45.12);
		s0.setSize(20);
		s0.show();
	}
}
