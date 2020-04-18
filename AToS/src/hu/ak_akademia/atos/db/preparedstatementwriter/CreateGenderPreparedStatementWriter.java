package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.Gender;

public class CreateGenderPreparedStatementWriter implements PreparedStatementWriter<Gender> {

	private final Gender gender;

	public CreateGenderPreparedStatementWriter(Gender gender) {
		this.gender = gender;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, gender.getName());
	}

}