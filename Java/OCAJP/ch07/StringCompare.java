package ch07;
// 2
public class StringCompare {

	public static void main(String[] args) {
		String s1 = "jim";
		String s2 = "jim";
		String s3 = new String ("jim");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));

	}

}
