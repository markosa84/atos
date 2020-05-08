package hu.ak_akademia.atos.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.dao.CountryDao;
import hu.ak_akademia.atos.db.dao.DatabaseDao;
import hu.ak_akademia.atos.db.dao.GenderDao;
import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.Country;
import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.CreateCityPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.CreateCountryPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.CreateGenderPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.CreateUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.city.CreateCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.country.CreateCountrySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.CreateGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.CreateUserInfoSqlBuilder;

public class InitDb {

	private static final Random random = new Random(20200425);
	private static final int LIMIT = 100;

	public static void main(String[] args) {
		System.out.println("Adatbázis feltöltése mintaadatokkal elkezdődött.");
		List<String> firstNames = load("res/first-names.txt");
		List<String> lastNames = load("res/last-names.txt");
		List<String> cities = load("res/cities.txt");
		try {
			long startTime = System.nanoTime();
			for (int i = 0; i < LIMIT; i++) {
				UserInfo userInfo = generateUserInfo(firstNames, lastNames, i);
//				for (int j = 0; j < LIMIT; j++) {
//					System.out.println(i + " / " + LIMIT + " kész.");
//				}
				if (i % 100 == 0) {
					System.out.println(i + " / " + LIMIT + " kész.");
				}
			}
			long endTime = System.nanoTime();
			long elapsedTime = endTime - startTime;
			System.out.println("Kész.");
			System.out.println("Eltelt idő: " + (elapsedTime / 1_000_000_000L) + " másodperc.");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void populateGender() {
		System.out.print("Gender tábla feltöltése...");
		Gender gender1 = Gender.builder()
				.withName("nő")
				.build();
		Gender gender2 = Gender.builder()
				.withName("férfi")
				.build();
		DatabaseDao<Gender> dao = new GenderDao();
		dao.openConnection();
		dao.create(new CreateGenderSqlBuilder(), new CreateGenderPreparedStatementWriter(gender1));
		dao.create(new CreateGenderSqlBuilder(), new CreateGenderPreparedStatementWriter(gender2));
		dao.closeConnection();
		System.out.println("kész");
	}

	private static void populateCountry() {
		System.out.print("Country tábla feltöltése...");
		Country country1 = Country.builder()
				.withName("Magyarország")
				.build();
		Country country2 = Country.builder()
				.withName("USA")
				.build();
		DatabaseDao<Country> dao = new CountryDao();
		dao.openConnection();
		dao.create(new CreateCountrySqlBuilder(), new CreateCountryPreparedStatementWriter(country1));
		dao.create(new CreateCountrySqlBuilder(), new CreateCountryPreparedStatementWriter(country2));
		dao.closeConnection();
		System.out.println("kész");
	}

	private static void populateCity() {
		System.out.print("City tábla feltöltése...");
		City city1 = City.builder()
				.withCountryId(1L)
				.withName("Budapest")
				.build();
		City city2 = City.builder()
				.withCountryId(1L)
				.withName("Debrecen")
				.build();
		City city3 = City.builder()
				.withCountryId(2L)
				.withName("New York")
				.build();
		DatabaseDao<City> dao = new CityDao();
		dao.openConnection();
		dao.create(new CreateCitySqlBuilder(), new CreateCityPreparedStatementWriter(city1));
		dao.create(new CreateCitySqlBuilder(), new CreateCityPreparedStatementWriter(city2));
		dao.create(new CreateCitySqlBuilder(), new CreateCityPreparedStatementWriter(city3));
		dao.closeConnection();
		System.out.println("kész");
	}

	private static void populateUserInfo() {
		System.out.print("User_info tábla feltöltése...");
		UserInfo userInfo = UserInfo.builder()
				.withUserName("kardesz97")
				.withFirstName("Milán")
				.withLastName("Karda")
				.withEmail("kardamilan@yahoo.hu")
				.withPasswordHash("Password123")
				.withCityId(1L)
				.withDateOfBirth(LocalDate.of(1997, 03, 06))
				.withGenderId(2L)
				.build();
		DatabaseDao<UserInfo> dao = new UserInfoDao();
		dao.openConnection();
		dao.create(new CreateUserInfoSqlBuilder(), new CreateUserInfoPreparedStatementWriter(userInfo));
		dao.closeConnection();
		System.out.println("kész");
	}

	private static UserInfo generateUserInfo(List<String> firstNames, List<String> lastNames, int counter) {
		Random random = new Random();
		String randomFirstName = firstNames.get(random.nextInt(firstNames.size()));
		String randomLastName = lastNames.get(random.nextInt(lastNames.size()));
		String email = randomFirstName + "." + randomLastName + "@gmail.com";
		String username = randomLastName.substring(0, 3) + randomFirstName.substring(0, 3) + counter;
		String passwordHash;

		UserInfo userInfo = UserInfo.builder()
				.withUserName(removeAccents(username.toLowerCase()))
				.withFirstName(randomFirstName)
				.withLastName(randomLastName)
				.withEmail(removeAccents(email).toLowerCase())
				.withPasswordHash("Password123")
				.withCityId(1L)
				.withDateOfBirth(LocalDate.of(1997, 03, 06))
				.withGenderId(2L)
				.build();

		DatabaseDao<UserInfo> dao = new UserInfoDao();
		dao.openConnection();
		dao.create(new CreateUserInfoSqlBuilder(), new CreateUserInfoPreparedStatementWriter(userInfo));
		dao.closeConnection();
		return userInfo;
	}

	private static String removeAccents(String text) {
		Map<String, String> replacement = new HashMap<>();
		replacement.put("á", "a");
		replacement.put("é", "e");
		replacement.put("í", "i");
		replacement.put("ó", "o");
		replacement.put("ö", "o");
		replacement.put("ő", "o");
		replacement.put("ú", "u");
		replacement.put("ü", "u");
		replacement.put("ű", "u");
		for (Entry<String, String> entry : replacement.entrySet()) {
			text = text.replaceAll(entry.getKey(), entry.getValue());
		}
		return text;
	}

	private static List<String> load(String fileName) {
		List<String> elements = new ArrayList<>();
		try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
			while (scanner.hasNextLine()) {
				String element = scanner.nextLine();
				elements.add(element);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Hiba a betöltés közben.");
			e.printStackTrace();
		}
		return elements;
	}

}