package ch05;

public class TempSpaceDemo {

	public static void main(String[] args) {
	
		int x = 3 * 4;
		System.out.println(x); // =12

		int a = 55555 * 66666;
		System.out.println(a);
		// 55555 * 66666 = 3703629630

		long b = 55555 * 66666;
		System.out.println(b);

		long c = (long) (55555 * 66666);
		System.out.println(c);

		long d = ((long) 55555) * 66666;
		System.out.println(d);

	}

}
