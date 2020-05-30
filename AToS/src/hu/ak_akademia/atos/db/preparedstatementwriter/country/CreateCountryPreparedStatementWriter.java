package hu.ak_akademia.atos.db.preparedstatementwriter.country;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.Country;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateCountryPreparedStatementWriter implements PreparedStatementWriter<Country> {

	private final Country country;

	public CreateCountryPreparedStatementWriter(Country country) {
		this.country = country;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, country.getName());
	}

}