package hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class DeleteByIdSearchUserFilterPreparedStatementWriter implements PreparedStatementWriter<SearchUserFilter> {

	private final SearchUserFilter searchUserFilter;

	public DeleteByIdSearchUserFilterPreparedStatementWriter(SearchUserFilter searchUserFilter) {
		this.searchUserFilter = searchUserFilter;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, searchUserFilter.getSearchUserFilterId());
	}

}