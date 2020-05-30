package hu.ak_akademia.atos.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import hu.ak_akademia.atos.db.dao.AbstractDatabaseDao;
import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.dao.CountryDao;
import hu.ak_akademia.atos.db.dao.DatabaseDao;
import hu.ak_akademia.atos.db.dao.GenderDao;
import hu.ak_akademia.atos.db.dao.InterestDao;
import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.dao.UserInterestMapDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.Country;
import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.entity.Interest;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.entity.UserInterestMap;
import hu.ak_akademia.atos.db.preparedstatementwriter.DummyPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.city.CreateCityPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.country.CreateCountryPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.gender.CreateGenderPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.interests.CreateInterestPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.CreateUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinterestmap.CreateUserInterestMapPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.country.SelectAllCountryResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.gender.SelectAllGenderResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.interests.SelectAllInterestsResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.CreateCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.country.CreateCountrySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.country.SelectAllCountrySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.CreateGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.SelectAllGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.interests.CreateInterestSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.interests.SelectAllInterestsSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.CreateUserInfoSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.SelectAllUserInfoSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinterestmap.CreateUserInterestMapSqlBuilder;

public class InitDb extends AbstractDatabaseDao<Object> {

	private static final Random random = new Random(20200425);
	private static final int USER_INFO_LIMIT = 1_000;

	public static void main(String[] args) {
		try {
			new InitDb().run();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void run() throws FileNotFoundException, IOException, SQLException {
		System.out.println("Adatbázis feltöltése mintaadatokkal elkezdődött.");
		List<String> countryAndCityNamesAndMappings = load("res/countries-cities.txt");

		openConnection();
		ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
		scriptRunner.runScript(new FileReader("db/init-db.sql"));
		closeConnection();

		populateGender();
		populateCountry(countryAndCityNamesAndMappings);
		populateCity(countryAndCityNamesAndMappings);
		populateInterest();
		populateUserInfo();
		populateUserInterestMap();
	}

	private static void populateGender() {
		System.out.print("Gender tábla feltöltése...");
		Gender gender1 = Gender.builder()
				.withName("Woman")
				.build();
		Gender gender2 = Gender.builder()
				.withName("Man")
				.build();
		DatabaseDao<Gender> dao = new GenderDao();
		dao.openConnection();
		dao.create(new CreateGenderSqlBuilder(), new CreateGenderPreparedStatementWriter(gender1));
		dao.create(new CreateGenderSqlBuilder(), new CreateGenderPreparedStatementWriter(gender2));
		dao.closeConnection();
		System.out.println("kész");
	}

	private static void populateCountry(List<String> countryAndCityNamesAndMappings) {
		System.out.print("Country tábla feltöltése...");
		List<String> countryNames = countryAndCityNamesAndMappings.stream()
				.map(line -> line.split("\\t")[1].trim())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		DatabaseDao<Country> dao = new CountryDao();
		dao.openConnection();
		for (String countryName : countryNames) {
			Country country = Country.builder()
					.withName(countryName)
					.build();
			dao.create(new CreateCountrySqlBuilder(), new CreateCountryPreparedStatementWriter(country));
		}
		dao.closeConnection();
		System.out.println("kész");
	}

	private static void populateCity(List<String> countryAndCityNamesAndMappings) {
		System.out.print("City tábla feltöltése...");
		CountryDao countryDao = new CountryDao();
		countryDao.openConnection();
		List<Country> countries = countryDao.read(new SelectAllCountrySqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllCountryResultSetReader());
		countryDao.closeConnection();
		Map<String, Long> countryNameToCountryIdMap = countries.stream()
				.collect(Collectors.toMap(Country::getName, Country::getCountryId));
		List<City> cities = countryAndCityNamesAndMappings.stream()
				.map(line -> City.builder()
						.withCountryId(countryNameToCountryIdMap.get(line.split("\\t")[1]))
						.withName(line.split("\\t")[0])
						.build())
				.collect(Collectors.toList());
		DatabaseDao<City> dao = new CityDao();
		dao.openConnection();
		for (City city : cities) {
			dao.create(new CreateCitySqlBuilder(), new CreateCityPreparedStatementWriter(city));
		}
		dao.closeConnection();
		System.out.println("kész");
	}

	private static void populateInterest() {
		InterestDao interestDao = new InterestDao();
		interestDao.openConnection();
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Társkeresés")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Kutyasétáltatás")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Szabadidőpartner")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Futópartner")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Társasjáték")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Ivócimbora")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Airsoft")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Paintball")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Koncertpartner")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Házibuli")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Kiállítás")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Couchsurfing")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Mozizás")
				.build()));
		interestDao.create(new CreateInterestSqlBuilder(), new CreateInterestPreparedStatementWriter(Interest.builder()
				.withName("Kirándulás")
				.build()));
		interestDao.closeConnection();
	}

	private static void populateUserInfo() {
		System.out.print("User_info tábla feltöltése...");
		List<UserInfo> userInfos = generateUserInfo();
		DatabaseDao<UserInfo> dao = new UserInfoDao();
		dao.openConnection();
		for (UserInfo userInfo : userInfos) {
			dao.create(new CreateUserInfoSqlBuilder(), new CreateUserInfoPreparedStatementWriter(userInfo));
		}
		dao.closeConnection();
		System.out.println("kész");
	}

	private static List<UserInfo> generateUserInfo() {
		List<String> firstNames = load("res/first-names.txt");
		List<String> lastNames = load("res/last-names.txt");
		CityDao cityDao = new CityDao();
		cityDao.openConnection();
		List<City> cities = cityDao.read(new SelectAllCitySqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllCityResultSetReader());
		cityDao.closeConnection();
		GenderDao genderDao = new GenderDao();
		genderDao.openConnection();
		List<Gender> genders = genderDao.read(new SelectAllGenderSqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllGenderResultSetReader());
		genderDao.closeConnection();
		List<UserInfo> userInfos = new ArrayList<>(USER_INFO_LIMIT);
		for (int counter = 0; counter < USER_INFO_LIMIT; counter++) {
			String randomFirstName = firstNames.get(random.nextInt(firstNames.size()));
			String randomLastName = lastNames.get(random.nextInt(lastNames.size()));
			String email = randomFirstName + "." + randomLastName + "@gmail.com";
			String username = randomLastName.substring(0, 3)
					.toLowerCase()
					+ randomFirstName.substring(0, 3)
							.toLowerCase()
					+ counter;
			String passwordHash = new Random().ints(48, 123)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
					.limit(10)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();
			Long cityId = cities.get(random.nextInt(cities.size()))
					.getCityId();
			LocalDate dateOfBirth = LocalDate.of(random.nextInt(91) + 1920, random.nextInt(12) + 1, 1)
					.plusDays(random.nextInt(31));
			Long genderId = genders.get(random.nextInt(genders.size()))
					.getGenderId();
			Boolean showMeInSearch = random.nextBoolean();
			Boolean showAllDetails = random.nextBoolean();
			Boolean paid = random.nextBoolean();

			UserInfo userInfo = UserInfo.builder()
					.withUserName(removeAccents(username.toLowerCase()))
					.withFirstName(randomFirstName)
					.withLastName(randomLastName)
					.withEmail(removeAccents(email).toLowerCase())
					.withPasswordHash(passwordHash)
					.withCityId(cityId)
					.withDateOfBirth(dateOfBirth)
					.withGenderId(genderId)
					.withShowMeInSearch(showMeInSearch)
					.withShowAllDetails(showAllDetails)
					.withPaid(paid)
					.build();
			userInfos.add(userInfo);
		}
		return userInfos;
	}

	private static void populateUserInterestMap() {
		System.out.print("User_interest_map tábla feltöltése...");
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.openConnection();
		List<UserInfo> users = userInfoDao.read(new SelectAllUserInfoSqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllUserInfoResultSetReader());
		userInfoDao.closeConnection();
		InterestDao interestDao = new InterestDao();
		interestDao.openConnection();
		List<Interest> interests = interestDao.read(new SelectAllInterestsSqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllInterestsResultSetReader());
		interestDao.closeConnection();
		UserInterestMapDao userInterestMapDao = new UserInterestMapDao();
		userInterestMapDao.openConnection();
		for (UserInfo user : users) {
			int numberOfInterests = random.nextInt(3) + 1;
			for (int i = 0; i < numberOfInterests; i++) {
				int randomIndex = random.nextInt(interests.size());
				Interest randomInterest = interests.get(randomIndex);
				UserInterestMap userInterestMap = UserInterestMap.builder()
						.withUsername(user.getUserName())
						.withInterestId(randomInterest.getInterestId())
						.build();
				userInterestMapDao.create(new CreateUserInterestMapSqlBuilder(), new CreateUserInterestMapPreparedStatementWriter(userInterestMap));
			}
		}
		userInterestMapDao.closeConnection();
		System.out.println("kész");
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