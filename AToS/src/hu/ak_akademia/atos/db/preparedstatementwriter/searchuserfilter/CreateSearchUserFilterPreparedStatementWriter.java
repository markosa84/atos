package hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateSearchUserFilterPreparedStatementWriter implements PreparedStatementWriter<SearchUserFilter> {

	private final SearchUserFilter searchUserFilter;

	public CreateSearchUserFilterPreparedStatementWriter(SearchUserFilter searchUserFilter) {
		this.searchUserFilter = searchUserFilter;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, searchUserFilter.getUsername());
		preparedStatement.setString(i++, searchUserFilter.getDisplayName());
		preparedStatement.setLong(i++, searchUserFilter.getInterestId());
		preparedStatement.setLong(i++, searchUserFilter.getCityId());
		if (searchUserFilter.getGenderId() != null) {
			preparedStatement.setLong(i++, searchUserFilter.getGenderId());
		}
		if (searchUserFilter.getAgeFrom() != null) {
			preparedStatement.setInt(i++, searchUserFilter.getAgeFrom());
		}
		if (searchUserFilter.getAgeTo() != null) {
			preparedStatement.setInt(i++, searchUserFilter.getAgeTo());
		}
	}

}