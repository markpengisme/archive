package ch06;
// 3
public class StringTest {

	public static void main(String[] args) {
		
		String name = "Jim Tzeng ";
		int length = name.length();
		System.out.println(length);
		
		name = name.trim();
		String lc = name + " TEACHES".toLowerCase();
		lc = (name + " TEACHES").toLowerCase();
		System.out.println(lc);
		
		String lastName = name.substring(4);
		System.out.println(lastName);

		System.out.println(lc.substring(4, 12));

		boolean end = name.endsWith("Tzeng");
		System.out.println(end);

	}
}
