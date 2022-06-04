package ch12;
// 1.3 not first 
class Vehicle {
	int x;

	Vehicle() {
		this(10);
	}

	Vehicle(int x) {
		this.x = x;
	}
}

class Car extends Vehicle {
	int y;

	Car() {
		super();
		// this(20); // compile error
	}

	Car(int y) {
		this.y = y;
	}
}

public class TestConstructors3 {
	public static void main(String[] args) {		
		new Car();
	}
}
