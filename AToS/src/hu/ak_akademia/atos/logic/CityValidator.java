package hu.ak_akademia.atos.logic;

import java.util.List;
import java.util.Set;

import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.preparedstatementwriter.city.SelectAllByIdCityPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllByIdCitySqlBuilder;

public class CityValidator {

	private LengthValidator lengthValidator = new LengthValidator();

	public void validateCity(String cityIdAsString, Set<String> invalidFields) {
		if (lengthValidator.isInvalidLength(cityIdAsString)) {
			invalidFields.add("cityInvalid");
			return;
		}
		long cityId = -1;
		try {
			cityId = Long.parseLong(cityIdAsString);
		} catch (NumberFormatException e) {
			invalidFields.add("cityInvalid");
			return;
		}
		CityDao cityDao = new CityDao();
		cityDao.openConnection();
		List<City> cities = cityDao.read(new SelectAllByIdCitySqlBuilder(), new SelectAllByIdCityPreparedStatementWriter(cityId), new SelectAllCityResultSetReader());
		cityDao.closeConnection();
		if (cities.isEmpty()) {
			invalidFields.add("cityInvalid");
			return;
		}
	}

}