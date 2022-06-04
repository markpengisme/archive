package ch05;

public class OperatorsTest {

	public static void main(String[] args) {
		int count = 20;
		int a, b, c, d;
		a = count++;
		b = count;
		c = ++count;
		d = count + 1;
		System.out.println(a + b + c + d);
		System.out.println("Result=" + a + b + c + d);
		System.out.println(a + b + "Result=" + c + d);
		System.out.println("Result=" + a + (b + c) + d);
	}

}
