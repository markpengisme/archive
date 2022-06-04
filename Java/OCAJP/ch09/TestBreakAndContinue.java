package ch09;
// 5. break & continue
public class TestBreakAndContinue {

	public static void main(String[] args) {
		useBreak();
		useContinue();
	}

	public static void useBreak() {
		int passScore = 60;
		int[] scores = { 40, 36, 52, 58, 65, 34, 93 };
		int passAt = 0;
		for (int s : scores) {
			passAt++;
			if (s > passScore) {
				break;
			}
		}
		System.out.println("Finally pass at: " + passAt);
	}

	public static void useContinue() {
		int passScore = 60;
		int[] scores = { 40, 36, 52, 58, 65, 34, 93 };
		for (int s : scores) {
			if (s > passScore)
				continue;
			System.out.println("the score: " + s + " is failed to pass.");
		}
	}

}
