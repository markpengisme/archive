package ch05;

public class WithVariable2 {
	public static void main(String[] args) {

		int r = 5;
		showResult(r);

		r = 10;
		showResult(r);

	}

	private static void showResult(int r) {
		final double PI = 3.14159;
		System.out.println("圓周 = " + PI * 2 * r);
		System.out.println("面積 = " + PI * r * r);
	}
}
