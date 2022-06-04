package ch13;
// 2.2 Unchecked Exception
public class ExceptionTest2 {
	public static void uncheckedException() {
		int[] intArray = new int[5];
		intArray[5] = 27;
	}
	public static void doThat() {
		System.out.println("Start doThat()");
		uncheckedException();
		System.out.println("End doThat()");
	}
	public static void doThis() {
		System.out.println("Start doThis()");
		doThat();
		System.out.println("End doThis()");
	}
	public static void main(String[] args) {
		System.out.println("============ Start main() ============");
		doThis();
		System.out.println("============ End main() ============");
	}
}
