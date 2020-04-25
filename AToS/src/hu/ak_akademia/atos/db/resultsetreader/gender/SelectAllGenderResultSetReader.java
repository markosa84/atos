package hu.ak_akademia.atos.db.resultsetreader.gender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllGenderResultSetReader implements ResultSetReader<Gender> {

	@Override
	public List<Gender> read(ResultSet resultSet) throws SQLException {
		List<Gender> results = new ArrayList<>();
		while (resultSet.next()) {
			long genderId = resultSet.getLong("gender_id");
			String name = resultSet.getString("name");

			Gender gender = Gender.builder()
					.withGenderId(genderId)
					.withName(name)
					.build();

			results.add(gender);
		}
		return results;
	}

}