package ch05;

public class WithVariable {

	public static void main(String[] args) {

		final double PI = 3.14159;

		int r = 5;

		// 給一個半徑 (r=5)，計算其 圓周 => PI * 2r
		System.out.println("圓周 = " + PI * 2 * r);

		// 給一個半徑 (r=5)，計算其 面積 => PI * r * r
		System.out.println("面積 = " + PI * r * r);

		r = 10;

		// 半徑變2倍，計算其 圓周
		System.out.println("圓周 = " + PI * 2 * r);

		// 半徑變2倍，計算其 面積
		System.out.println("面積 = " + PI * r * r);

	}
}
