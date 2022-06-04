package ch10;
// 2. overload
public final class Calculator {

	public static int sum(int i1, int i2) {
		return i1 + i2;
	}

	public static float sum(float f1, int i2) {
		return f1 + i2;
	}

	public static float sum(int i1, float f2) {
		return i1 + f2;
	}

}
