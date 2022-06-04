package ch15;
// 4. PeriodDemo(between, plus, static)
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo {

	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}
	
	private static void demo1() {
		
		LocalDate christmas = LocalDate.of(2016, Month.DECEMBER, 25);
		LocalDate today = LocalDate.now();
		System.out.println("today: " + today);
		long days = ChronoUnit.DAYS.between(today, christmas);
		System.out.println("There are " + days + " days until Christmas");

		Period periodUntilXMas = Period.between(today, christmas);
		System.out.println("There are " 
				+ periodUntilXMas.getYears() + " years, " 
				+ periodUntilXMas.getMonths() + " months, " 
				+ periodUntilXMas.getDays() + " days "
				+ "until Christmas");
		System.out.println();
	}

	private static void demo2() {
		LocalDate today = LocalDate.now();
		LocalDate d1 = LocalDate.now();
		d1 = plusDay(d1);
		System.out.println("d1: " + d1);
		
		LocalDate d2 = LocalDate.now();
		d2 =plusDayByPeriod(today, Period.ofMonths(1));
		d2 =plusDayByPeriod(d2, Period.ofDays(1));
		d2 =plusDayByPeriod(d2, Period.ofWeeks(1));
		d2 =plusDayByPeriod(d2, Period.ofYears(1));
		System.out.println("d2: " + d2);
		System.out.println();
	}
	
	private static LocalDate plusDay(LocalDate d) {
		d = d.plusMonths(1).plusDays(1).plusWeeks(1).plusYears(1);
		return d;
	}
	
	// method is reusable
	private static LocalDate plusDayByPeriod(LocalDate d, Period p) {
		d = d.plus(p);
		return d;
	}


	private static void demo3() {
		
		// Period p1 = Period.ofMonths(1).ofWeeks(1); // same as next line cause static
		Period p1 = Period.ofWeeks(1);
		System.out.println("Today + p1: " + LocalDate.now().plus(p1));
		
		Period p2 = Period.ofMonths(1);
		p2 = Period.ofWeeks(1);
		System.out.println("Today + p1: " + LocalDate.now().plus(p2));

	}
	

}
