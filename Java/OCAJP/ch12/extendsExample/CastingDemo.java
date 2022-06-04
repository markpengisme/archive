package ch12.extendsExample;
// 6. polymorphism casting
public class CastingDemo {

	public static void main(String[] args) {

		Clothing c = new Trousers('M', 1, "my trouser", 'B', 1200.5);
		c.display(); // OK
		// c.getGender(); // will compile error!!


		// casting(Compile ok) 
		Trousers t = (Trousers) c;
		// Shirt s = (Shirt) c;

		t.getGender(); // OK
		// s.getFit(); // Runtime Error, Trousers can't be cast to Shirt

	}

}
