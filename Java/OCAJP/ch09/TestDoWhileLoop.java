package ch09;
// 6. do...while
public class TestDoWhileLoop {

	public static void main(String[] args) {
		testDoWhileLoop();
		testWhileLoop();
	}

	public static void testDoWhileLoop() {
		int count = 0;
		do {
			System.out.println("DoWhile Count is: " + count);
		} while (count < 0);
	}

	public static void testWhileLoop() {
		int count = 0;
		while (count < 0) {
			System.out.println("While Count is: " + count);
			count++;
		}
	}

}
