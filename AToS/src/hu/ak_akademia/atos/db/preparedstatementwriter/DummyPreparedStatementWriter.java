package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DummyPreparedStatementWriter implements PreparedStatementWriter<Object> {

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
	}

}