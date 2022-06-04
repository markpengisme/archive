package ch07;
// 6
public class SwitchDemo2 {

	public static void SumMonthDaysBySwitch2(int month) {
		switch (month) {
		case 1:
			System.out.println("--1");
		case 3:
			System.out.println("--3");
		case 5:
			System.out.println("--5");
		case 7:
			System.out.println("--7");
		case 8:
			System.out.println("--8");
		case 10:
			System.out.println("--10");
		case 12:
			System.out.println("31 days");
			break;
		case 2:
			System.out.println("28 days");
			break;
		case 4:
			System.out.println("--4");
		case 6:
			System.out.println("--6");
		case 9:
			System.out.println("--9");
		case 11:
			System.out.println("30 days");
			break;
		default:
			System.out.println("Invalid month");
			break;
		}
	}

	public static void main(String[] args) {
		SumMonthDaysBySwitch2(3);
	}
}
