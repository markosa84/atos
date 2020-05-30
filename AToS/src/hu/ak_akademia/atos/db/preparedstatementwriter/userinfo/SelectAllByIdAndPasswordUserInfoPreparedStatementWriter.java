package hu.ak_akademia.atos.db.preparedstatementwriter.userinfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByIdAndPasswordUserInfoPreparedStatementWriter implements PreparedStatementWriter<UserInfo> {

	private final String username;
	private final String passwordHash;

	public SelectAllByIdAndPasswordUserInfoPreparedStatementWriter(String username, String passwordHash) {
		this.username = username;
		this.passwordHash = passwordHash;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, passwordHash);
	}

}