package ch13;
// 1. OutOfMemoryError
import java.util.ArrayList;
import java.util.List;

public class ErrorDemo {

	private static void test() {
		List<String> list = new ArrayList<String>();
		while (true) {
			String s = "OutOfMemoryError Test";
			list.add(s);
			if (list.size() % 1000000 == 0) {
				System.out.println(list.size() / 100000 + " million String created!");
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("============ Test Start!! ============");
		test();
		System.out.println("============ Test End!! ============");
	}
}
