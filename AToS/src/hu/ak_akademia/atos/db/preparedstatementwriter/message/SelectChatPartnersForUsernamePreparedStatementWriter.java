package hu.ak_akademia.atos.db.preparedstatementwriter.message;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectChatPartnersForUsernamePreparedStatementWriter implements PreparedStatementWriter<String> {

	private final String username;

	public SelectChatPartnersForUsernamePreparedStatementWriter(String username) {
		this.username = username;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, username);
	}

}