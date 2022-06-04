package ch05;

public class CastingTest1 {

	public static void main(String[] args) {
		int i1 = 53;
		int i2 = 47;
		byte b3;
		// b3 = i1 + i2; // compile error!!
		b3 = (byte) (i1 + i2);
		System.out.println(b3);
	}

}
