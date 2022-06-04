package ch10;
// 1-3. static + Math.PI
public class Circle2 {

	private double radius;

	public void setRadius(double r) {
		this.radius = r;
	}

	public double getArea() {
		return areaFormula(this.radius);
	}

	// 此為公式，結果只和輸入參數有關
	static double areaFormula(double r) {
		return r * r * Math.PI;
	}

	public static void main(String[] args) {

		System.out.println(Circle1.PI);

		// 圓半徑為1，求面積
		System.out.println(Circle1.areaFormula(1));

		// 圓半徑為10，求面積
		System.out.println(Circle1.areaFormula(10));

	}

}
