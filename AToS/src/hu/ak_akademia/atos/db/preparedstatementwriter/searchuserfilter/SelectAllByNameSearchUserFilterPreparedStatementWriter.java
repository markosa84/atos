package hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByNameSearchUserFilterPreparedStatementWriter implements PreparedStatementWriter<SearchUserFilter> {

	private final String filterName;

	public SelectAllByNameSearchUserFilterPreparedStatementWriter(String filterName) {
		this.filterName = filterName;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, filterName);
	}

}