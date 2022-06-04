package ch10;
// 1-2. static
public class Circle1 {

	private double radius;
	static final double PI = 3.1415926;

	public void setRadius(double r) {
		this.radius = r;
	}

	public double getArea() {
		return this.radius * this.radius * PI;
	}

	// 此為公式，結果只和輸入參數有關
	static double areaFormula(double r) {
		return r * r * PI;
	}

	public static void main(String[] args) {

		System.out.println(Circle1.PI);

		// 圓半徑為1，求面積
		System.out.println(Circle1.areaFormula(1));

		// 圓半徑為10，求面積
		System.out.println(Circle1.areaFormula(10));

	}

}
