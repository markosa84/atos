package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementWriter<E> {

	void write(PreparedStatement preparedStatement) throws SQLException;

}