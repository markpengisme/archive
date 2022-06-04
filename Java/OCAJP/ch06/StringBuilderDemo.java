package ch06;
// 4
public class StringBuilderDemo {

	public static void main(String[] args) {

		StringBuilder sb1 = new StringBuilder(8);

		sb1.append("jim");
		sb1.append(" ");
		sb1.append("tzeng");

		System.out.println("sb1: " + sb1.toString());
		System.out.println("sb1 object capacity: " + sb1.capacity());
		System.out.println("sb1 sub string: " + sb1.substring(0, 5));
		// System.out.println("sb1 sub string: " + sb1.substring(0, 10)); 	// error at runtime

		StringBuilder sb2 = new StringBuilder();
		sb2.append("123456789");
		sb2.insert(3, "-");
		sb2.insert(7, "-");
		System.out.println("sb2: " + sb2.toString());
		
		StringBuilder sb3 = new StringBuilder("12345678");
		sb3.delete(3, 5);
		System.out.println("sb3: " + sb3.toString());
	}
}