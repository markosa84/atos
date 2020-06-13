package hu.ak_akademia.atos.db.preparedstatementwriter.userinfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class DynamicUserInfoPreparedStatementWriter implements PreparedStatementWriter<UserInfo> {

	private final SearchUserFilter filter;

	public DynamicUserInfoPreparedStatementWriter(SearchUserFilter filter) {
		this.filter = filter;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, filter.getInterestId());
		preparedStatement.setLong(i++, filter.getCityId());
		if (filter.getGenderId() != null) {
			preparedStatement.setLong(i++, filter.getGenderId());
		}
		if (filter.getAgeFrom() != null) {
			preparedStatement.setInt(i++, filter.getAgeFrom());
		}
		if (filter.getAgeTo() != null) {
			preparedStatement.setInt(i++, filter.getAgeTo());
		}
	}

}