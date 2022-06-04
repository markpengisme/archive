package ch15;
// 5. DateTimeFormatterDemo
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterDemo {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.of(2016,03, 23, 11,20,21);
		DateTimeFormatter f = null;
		
		f = DateTimeFormatter.ISO_LOCAL_DATE;
		System.out.println(now.format(f)); 
		// 2016-03-23
		
		f = DateTimeFormatter.ISO_ORDINAL_DATE;
		System.out.println(now.format(f)); 
		// 2016-083 (days of year)
		
		f = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		System.out.println(now.format(f)); 
		// 2016-03-23T11:20:21
		
		f = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy G, hh:mm a");
		System.out.println(now.format(f));
		// Wednesday, March 23, 2016 AD, 11:20 AM
		
		f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.n"); 
		System.out.println(now.format(f));
		// 2016-03-23 11:20:21.0
		
		f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		System.out.println(now.format(f));
		// Mar 23, 2016, 11:20:21 AM
		
		f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(now.format(f));
		// 3/23/16, 11:20 AM
		

		

		
	}

}
