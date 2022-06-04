package ch12;
// 1.1 auto call implict super()
class SuperXParent {
	public SuperXParent() {
		System.out.println("動物界");
	}
}

class Super4Parent extends SuperXParent {
	public Super4Parent() {
		System.out.println("脊索動物門");
	}
}

class Super3Parent extends Super4Parent {
	public Super3Parent() {
		System.out.println("哺乳綱");
	}
}

class Super2Parent extends Super3Parent {
	public Super2Parent() {
		System.out.println("靈長目");
	}
}

class Super1Parent extends Super2Parent {
	public Super1Parent() {
		System.out.println("人科");
	}
}

class Parent extends Super1Parent {
	public Parent() {
		System.out.println("人屬");
	}
}

class People extends Parent {
	public People() {
		System.out.println("智人");
	}
}

public class TestConstructors1 {
	public static void main(String[] args) {
		People c = new People();
		System.out.println(c.getClass());
	}
}
