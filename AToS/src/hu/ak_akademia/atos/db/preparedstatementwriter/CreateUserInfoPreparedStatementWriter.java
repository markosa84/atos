package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.UserInfo;

public class CreateUserInfoPreparedStatementWriter implements PreparedStatementWriter<UserInfo> {

	private final UserInfo userInfo;

	public CreateUserInfoPreparedStatementWriter(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, userInfo.getUserName());
		preparedStatement.setString(i++, userInfo.getFirstName());
		preparedStatement.setString(i++, userInfo.getLastName());
		preparedStatement.setString(i++, userInfo.getEmail());
		preparedStatement.setString(i++, userInfo.getPasswordHash());
		preparedStatement.setLong(i++, userInfo.getCityId());
		preparedStatement.setDate(i++, Date.valueOf(userInfo.getDateOfBirth()));
		preparedStatement.setLong(i++, userInfo.getGenderId());
		preparedStatement.setBoolean(i++, userInfo.getShowMeInSearch());
		preparedStatement.setBoolean(i++, userInfo.getShowAllDetails());
		preparedStatement.setBoolean(i++, userInfo.getPaid());
	}

}