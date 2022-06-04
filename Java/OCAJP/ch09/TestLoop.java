package ch09;

// 2. getSquareRoot/doubleYourMoney/commentBlock
public class TestLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getSquareRoot();
		doubleYourMoney();
		commentBlock();
	}

	public static void getSquareRoot() {
		float input = 10;
		float squareRoot = input;
		float accurate = 0.01f;
		while (squareRoot * squareRoot - input > accurate) {
			squareRoot = (squareRoot + input / squareRoot) / 2;
			System.out.println("trying...  " + squareRoot);
		}
		System.out.println("The square root of " + input + " (accurate=" + accurate + ") => " + squareRoot);
	}

	public static void doubleYourMoney() {
		double money = 500;
		double interest = 0.18;
		int years = 0;
		while (money <= 1000) {
			money += money * interest;
			years++;
			System.out.println("Year " + years + ": " + money);
		}
	}

	public static void commentBlock() {
		System.out.println(" /*");
		int counter = 0;
		while (counter < 4) {
			System.out.println(" *");
			counter++;
		}
		System.out.println(" */");
	}


	public static void loopArray() {
		long[] longArray = new long[9];

		// 設定陣列內容
		for (int i = 0; i < longArray.length; i++) {
			longArray[i] = Math.round(Math.random() * 100);
		}
		// 讀取陣列內容
		for (int i = 0; i < longArray.length; i++) {
			System.out.println(i + ": " + longArray[i]);
		}

	}


}
