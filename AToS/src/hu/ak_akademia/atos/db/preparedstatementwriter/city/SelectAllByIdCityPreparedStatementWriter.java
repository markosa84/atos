package hu.ak_akademia.atos.db.preparedstatementwriter.city;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByIdCityPreparedStatementWriter implements PreparedStatementWriter<City> {

	private long cityId;

	public SelectAllByIdCityPreparedStatementWriter(long cityId) {
		this.cityId = cityId;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, cityId);
	}

}