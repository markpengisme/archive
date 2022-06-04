package ch15;
// 6. DateTimeFormatterParseDemo
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterParseDemo {

	public static void main(String[] args) {
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("MM dd yyyy");
		LocalDate date = LocalDate.parse("01 02 2015", dFormat);
		System.out.println(date); 
		
		DateTimeFormatter tFormat = DateTimeFormatter.ofPattern("HH mm ss");
		LocalTime time = LocalTime.parse("11 22 57", tFormat);		
		System.out.println(time); 
	}

}
