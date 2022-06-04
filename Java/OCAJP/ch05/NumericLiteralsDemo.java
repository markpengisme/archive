package ch05;

public class NumericLiteralsDemo {

	public static void main(String[] args) {

		int i1 = 1234567;
		int i2 = 1_234_567;
		System.out.println(i1 == i2);

		double d1 = 1234567.1234567;
		double d2 = 1_234_567.123_456_7;
		System.out.println(d1 == d2);

	}

}
