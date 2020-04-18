package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.UserInterestMap;

public class CreateUserInterestMapPreparedStatementWriter implements PreparedStatementWriter<UserInterestMap> {

	private final UserInterestMap userInterestMap;

	public CreateUserInterestMapPreparedStatementWriter(UserInterestMap userInterestMap) {
		this.userInterestMap = userInterestMap;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, userInterestMap.getUsername());
		preparedStatement.setLong(i++, userInterestMap.getInterestId());
	}

}