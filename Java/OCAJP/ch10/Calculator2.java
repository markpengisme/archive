package ch10;
// 3. sum by type casting
public final class Calculator2 {

	public static Double sum(Number... numbers) {
		Double d = 0.0;
		for (Number n : numbers) {
			d += n.doubleValue();
		}
		return d;
	}

	public static void main(String[] args) {

		System.out.println(sum(1, 2));

		System.out.println(sum(1.0f, 2));

		System.out.println(sum(1, 2.0f));

	}

}
