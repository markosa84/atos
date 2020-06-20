package hu.ak_akademia.atos.db.preparedstatementwriter.message;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.Message;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllMessagesBetweenUsersPreparedStatementWriter implements PreparedStatementWriter<Message> {

	private final String username1;
	private final String username2;

	public SelectAllMessagesBetweenUsersPreparedStatementWriter(String username1, String username2) {
		this.username1 = username1;
		this.username2 = username2;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, username1);
		preparedStatement.setString(i++, username2);
		preparedStatement.setString(i++, username2);
		preparedStatement.setString(i++, username1);
	}

}