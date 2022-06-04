package ch12;
// 1.2 the first action is to call parent class
class Super {
	Super(String s) {
		System.out.println("Super");
	}
}

class Sub extends Super {

	Sub(String s) {
		super(s);
		System.out.println("Sub");
	}

	Sub(String s1, String s2) {
		this(s1);	// will compile?
		System.out.println("Sub");
	}

}

public class TestConstructors2 {
	public static void main(String[] args) {		
		new Sub("Jim");
		System.out.println("--------");
		new Sub("Hi", "Jim");
	}
}
