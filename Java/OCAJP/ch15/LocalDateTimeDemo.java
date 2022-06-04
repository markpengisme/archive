package ch15;
// 3. LocalDateTimeDemo
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo {

	public static void main(String[] args) {

		LocalDate flightDate = LocalDate.of(2014, Month.MAY, 2);
		LocalTime flightTime = LocalTime.of(21, 45);
		LocalDateTime flight = LocalDateTime.of(flightDate, flightTime);
		System.out.println("Flight leaves: " + flight);

		LocalDateTime seminarStart = LocalDateTime.of(2016, Month.MAY, 2, 9, 30);
		System.out.println("Seminar starts: " + seminarStart);
		LocalDateTime seminarEnd = seminarStart.plusDays(2).plusHours(8);
		System.out.println("Seminar ends: " + seminarEnd);
		
		System.out.println("Now: " + LocalDateTime.now());

	}

}
