package hu.ak_akademia.atos.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.dao.GenderDao;
import hu.ak_akademia.atos.db.dao.InterestDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.entity.Interest;
import hu.ak_akademia.atos.db.preparedstatementwriter.DummyPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.gender.SelectAllGenderResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.interests.SelectAllInterestsResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.SelectAllGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.interests.SelectAllInterestsSqlBuilder;

public class RequestUtil {

	private RequestUtil() {
		// to prevent instantiation
	}

	public static void loadGenderMap(HttpServletRequest request) {
		GenderDao genderDao = new GenderDao();
		genderDao.openConnection();
		List<Gender> genders = genderDao.read(new SelectAllGenderSqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllGenderResultSetReader());
		genderDao.closeConnection();
		Map<Long, String> genderMap = genders.stream()
				.collect(Collectors.toMap(Gender::getGenderId, Gender::getName));
		request.setAttribute("genderMap", genderMap);
	}

	public static void loadInterestMap(HttpServletRequest request) {
		InterestDao interestDao = new InterestDao();
		interestDao.openConnection();
		List<Interest> interests = interestDao.read(new SelectAllInterestsSqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllInterestsResultSetReader());
		interestDao.closeConnection();
		Map<Long, String> interestMap = interests.stream()
				.collect(Collectors.toMap(Interest::getInterestId, Interest::getName));
		request.setAttribute("interestMap", interestMap);
	}

	public static void loadCityMap(HttpServletRequest request) {
		CityDao cityDao = new CityDao();
		cityDao.openConnection();
		List<City> cities = cityDao.read(new SelectAllCitySqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllCityResultSetReader());
		cityDao.closeConnection();
		Map<Long, String> cityMap = cities.stream()
				.collect(Collectors.toMap(City::getCityId, City::getName));
		request.setAttribute("cityMap", cityMap);
	}

}