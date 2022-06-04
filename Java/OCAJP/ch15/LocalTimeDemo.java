package ch15;
// 2. LocalDateDemo
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

	public static void main(String[] args) {

		LocalTime now = LocalTime.now();
		System.out.println("Now is: " + now);

		LocalTime nowPlus = now.plusHours(1).plusMinutes(35);
		System.out.println("The Time after 1 hour 15 minutes: " + nowPlus);

		LocalTime nowHrsMins = now.truncatedTo(ChronoUnit.MINUTES);
		System.out.println("Truncate the current time to minutes: " + nowHrsMins);
		System.out.println("Now is " + now.toSecondOfDay() + "seconds after midnight");

		LocalTime lunch = LocalTime.of(12, 5);
		System.out.println("Do I miss lunch? " + lunch.isBefore(now));

		long minsUntilLunch = now.until(lunch, ChronoUnit.MINUTES);
		System.out.println("Minutes until lunch: " + minsUntilLunch);

		LocalTime bedtime = LocalTime.of(23, 20);
		long hrsToBedtime = now.until(bedtime, ChronoUnit.HOURS);
		System.out.println("How many hours until bedtime? " + hrsToBedtime);
	}

}
