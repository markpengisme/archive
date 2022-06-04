package ch10;

public class CalculatorTester {

	public static void main(String[] args) {
		int totalOne = Calculator.sum(2, 5);
		System.out.println(totalOne);
		float totalTwo = Calculator.sum(12.9f, 12);
		System.out.println(totalTwo);
		float totalThree = Calculator.sum(12, 12.9f);
		System.out.println(totalThree);

	}

}
