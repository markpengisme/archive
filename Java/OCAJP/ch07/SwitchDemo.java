package ch07;
// 5
public class SwitchDemo {
	
	public static void SumMonthDaysBySwitch(int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31 days");
			break;
		case 2:
			System.out.println("28 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30 days");
			break;
		default:
			System.out.println("Invalid month");
			break;
		}
	}
	
	public static void SumMonthDaysByIf(int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("31 days");
		} else if (month == 2) {
			System.out.println("28 days");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("30 days");
		} else {
			System.out.println("Invalid month");
		}
	}

	public static void main(String[] args) {
		SumMonthDaysByIf(2);
		SumMonthDaysBySwitch(2);
	}

}
