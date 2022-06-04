package ch13;
// 2.5 try-catch + throws
public class ExceptionTest5 {
	public static void checkedException() throws Exception {
		if (Math.random() > 0.01) {
			throw new Exception();
		} 
	}
	public static void doThat() {
		System.out.println("Start doThat()");
		try {
			checkedException();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
