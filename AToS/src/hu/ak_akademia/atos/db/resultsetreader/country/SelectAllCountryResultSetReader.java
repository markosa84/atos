package hu.ak_akademia.atos.db.resultsetreader.country;

import hu.ak_akademia.atos.db.entity.Country;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllCountryResultSetReader implements ResultSetReader<Country> {

	@Override
	public List<Country> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
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