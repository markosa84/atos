package hu.ak_akademia.atos.db.preparedstatementwriter.gender;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByIdGenderPreparedStatementWriter implements PreparedStatementWriter<Gender> {

	private long genderId;

	public SelectAllByIdGenderPreparedStatementWriter(long genderId) {
		this.genderId = genderId;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, genderId);
	}

}