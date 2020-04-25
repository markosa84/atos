package hu.ak_akademia.atos.db.resultsetreader.city;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllCityResultSetReader implements ResultSetReader<City> {

	@Override
	public List<City> read(ResultSet resultSet) throws SQLException {
		List<City> results = new ArrayList<>();
		while (resultSet.next()) {
			long cityId = resultSet.getLong("city_id");
			long countryId = resultSet.getLong("country_id");
			String name = resultSet.getString("name");

			City city = City.builder()
					.withCityId(cityId)
					.withCountryId(countryId)
					.withName(name)
					.build();

			results.add(city);
		}
		return results;
	}

}