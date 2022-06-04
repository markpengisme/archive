package ch13;
// 2.1 call stack
public class ExceptionTest1 {
	public static void doThat() {
		System.out.println("Start doThat()");
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
