package ch11;
// 1. testing
public class PersonTest {

	public static void testPerson0() {
		Person0 p = new Person0();
		p.age = 200;
		System.out.println(p.age);
	}

	public static void testPerson1() {
		Person1 p = new Person1();
		// p.age = 200; //compile error
		p.setAge(200);
		System.out.println(p.getAge());
		// System.out.println(p.age); //compile error
	}

	public static void main(String[] args) {
		testPerson0();
		testPerson1();
	}
}
