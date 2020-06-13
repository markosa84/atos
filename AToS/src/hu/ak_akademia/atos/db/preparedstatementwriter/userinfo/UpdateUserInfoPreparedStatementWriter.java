package hu.ak_akademia.atos.db.preparedstatementwriter.userinfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.atos.util.DateUtil;

public class UpdateUserInfoPreparedStatementWriter implements PreparedStatementWriter<UserInfo> {

	private final UserInfo userInfo;
	private final String oldPasswordHash;

	public UpdateUserInfoPreparedStatementWriter(UserInfo userInfo, String oldPasswordHash) {
		this.userInfo = userInfo;
		this.oldPasswordHash = oldPasswordHash;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, userInfo.getFirstName());
		preparedStatement.setString(i++, userInfo.getLastName());
		preparedStatement.setString(i++, userInfo.getEmail());
		preparedStatement.setString(i++, userInfo.getPasswordHash());
		preparedStatement.setLong(i++, userInfo.getCityId());
		preparedStatement.setDate(i++, DateUtil.convert(userInfo.getDateOfBirth()));
		preparedStatement.setLong(i++, userInfo.getGenderId());
		preparedStatement.setBoolean(i++, userInfo.getShowMeInSearch());
		preparedStatement.setBoolean(i++, userInfo.getShowAllDetails());
		preparedStatement.setBoolean(i++, userInfo.getPaid());
		preparedStatement.setString(i++, userInfo.getUsername());
		preparedStatement.setString(i++, oldPasswordHash);
	}

}