package hu.ak_akademia.atos;

import java.time.LocalDate;
import java.time.Period;

public class Test {

	public static void main(String[] args) {
		LocalDate dateOfBirth = LocalDate.of(2000, 6, 20);
		int age = Period.between(dateOfBirth, LocalDate.now())
				.getYears();
		System.out.println(age);
	}

}
