package hu.ak_akademia.atos.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	private DateUtil() {
		// to prevent instantiation
	}

	public static LocalDate convert(String date) {
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));
	}

	public static java.sql.Date convert(LocalDate date) {
		return java.sql.Date.valueOf(date);
	}

}