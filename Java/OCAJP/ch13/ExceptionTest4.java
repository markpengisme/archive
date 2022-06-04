package ch13;
// 2.4 throws exception
public class ExceptionTest4 {
	public static void checkedException() throws Exception {
		if (Math.random() > 0.01) {
			throw new Exception();
		} 
	}
	public static void doThat() throws Exception {
		System.out.println("Start doThat()");
		checkedException();
		System.out.println("End doThat()");
	}
	public static void doThis() throws Exception {
		System.out.println("Start doThis()");
		doThat();
		System.out.println("End doThis()");
	}
	public static void main(String[] args) {
		System.out.println("============ Start main() ============");
		try {
			doThis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============ End main() ============");
	}
}
