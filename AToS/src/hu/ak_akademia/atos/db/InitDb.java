package hu.ak_akademia.atos.db;

import java.time.LocalDate;

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
import hu.ak_akademia.atos.db.sqlbuilder.CreateCountrySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.CreateGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.city.CreateCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.CreateUserInfoSqlBuilder;

public class InitDb {

	public static void main(String[] args) {
		System.out.println("Adatbázis feltöltése mintaadatokkal elkezdődött.");
		populateGender();
		populateCountry();
		populateCity();
		populateUserInfo();
		System.out.println("Adatbázis feltöltése kész.");
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
				.withDateOfBirth(LocalDate.of(1997, 3, 6))
				.withGenderId(2L)
				.withShowMeInSearch(true)
				.withShowAllDetails(true)
				.withPaid(true)
				.build();
		DatabaseDao<UserInfo> dao = new UserInfoDao();
		dao.openConnection();
		dao.create(new CreateUserInfoSqlBuilder(), new CreateUserInfoPreparedStatementWriter(userInfo));
		dao.closeConnection();
		System.out.println("kész");
	}

}