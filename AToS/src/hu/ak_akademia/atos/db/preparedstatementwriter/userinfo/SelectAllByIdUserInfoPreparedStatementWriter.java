package hu.ak_akademia.atos.db.preparedstatementwriter.userinfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByIdUserInfoPreparedStatementWriter implements PreparedStatementWriter<UserInfo> {

	private String username;

	public SelectAllByIdUserInfoPreparedStatementWriter(String username) {
		this.username = username;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, username);
	}

}