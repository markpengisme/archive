package ch15;

import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class CompareDemo {

	private static void oldWay() {
		Date nowDate = new Date();
		System.out.println(nowDate);

		Date nowDateTime = new Date();
		System.out.println(nowDateTime);

		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.JANUARY, 1);
		c.add(Calendar.DATE, 5);
		c.add(Calendar.DATE, -1);
		Date jan = c.getTime();
		System.out.println(jan);
		
		SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
		System.out.println(sf.format(nowDate));
		System.out.println(sf.format(nowDateTime));

	}

	private static void newWay() {
		LocalDate nowDate = LocalDate.now();
		System.out.println(nowDate);

		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println(nowDateTime);

		LocalDate jan = 
				LocalDate
				.of(2015, Month.JANUARY, 1)
				.plusDays(5)
				.minusDays(1);	//fluent way
		System.out.println(jan);
		
		DateTimeFormatter sf = DateTimeFormatter.ofPattern("hh:mm");
		//System.out.println(sf.format(nowDate));	
		// java.time.temporal.UnsupportedTemporalTypeException
		System.out.println(sf.format(nowDateTime));
	}

	public static void main(String[] args) {
		oldWay();
		System.out.println("-----------------");
		newWay();
	}

}
