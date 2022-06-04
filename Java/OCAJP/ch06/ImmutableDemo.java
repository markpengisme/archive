package ch06;
// 2
public class ImmutableDemo {

	public static void main(String[] args) {
		String name1 = "Jim";
		name1 = name1.concat(" is teaching");
		System.out.println(name1);
		String name2 = "Jim";
		name2.concat(" is teaching");
		System.out.println(name2);

	}

}
