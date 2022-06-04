package ch15;
// 1. LocalDateDemo
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		System.out.println("Now: " + now);

		LocalDate birthDate = LocalDate.of(1995, 5, 23); // Java's Birthday
		System.out.println("Java's Bday: " + birthDate);
		System.out.println("Is Java's Bday in the past? " + birthDate.isBefore(now));
		System.out.println("Is Java's Bday in a leap year? " + birthDate.isLeapYear());
		System.out.println("Java's Bday day of the week: " + birthDate.getDayOfWeek());
		System.out.println("Java's Bday day of the Month: " + birthDate.getDayOfMonth());
		System.out.println("Java's Bday day of the Year: " + birthDate.getDayOfYear());

		LocalDate nowAfter1Month = now.plusMonths(1);
		System.out.println("The date after 1 month: " + nowAfter1Month);

		LocalDate nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("First Monday after now: " + nextMonday);
		
		LocalDate birthDate1 = LocalDate.of(1995, Month.MAY, 23); // Java's Birthday
		System.out.println("Is the same date? " + birthDate.isEqual(birthDate1));
	}

}
