package hu.ak_akademia.atos.db.preparedstatementwriter.city;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateCityPreparedStatementWriter implements PreparedStatementWriter<City> {

	private final City city;

	public CreateCityPreparedStatementWriter(City city) {
		this.city = city;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, city.getCountryId());
		preparedStatement.setString(i++, city.getName());
	}

}