package ch10;
// 1-1. no static
public class Circle0 {

	private double radius;
	final double PI = 3.1415926;

	public void setRadius(double r) {
		this.radius = r;
	}

	public double getArea() {
		return this.radius * this.radius * PI;
	}

	public static void main(String[] args) {

		// 建立一個 Circle:c1物件, 其半徑=1, 並取得其面積
		Circle0 c1 = new Circle0();
		c1.setRadius(1);
		System.out.println(c1.getArea());

		// 建立一個 Circle:c2物件, 其半徑=10, 並取得其面積
		Circle0 c2 = new Circle0();
		c2.setRadius(10);
		System.out.println(c2.getArea());

	}

}
