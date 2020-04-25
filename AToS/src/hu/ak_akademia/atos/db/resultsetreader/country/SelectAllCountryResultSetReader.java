package hu.ak_akademia.atos.db.resultsetreader.country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.Country;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllCountryResultSetReader implements ResultSetReader<Country> {

	@Override
	public List<Country> read(ResultSet resultSet) throws SQLException {
		List<Country> results = new ArrayList<>();
		while (resultSet.next()) {
			Long countryId = resultSet.getLong("country_id");
			String name = resultSet.getString("name");

			Country country = Country.builder()
					.withCountryId(countryId)
					.withName(name)
					.build();

			results.add(country);
		}
		return results;
	}
}