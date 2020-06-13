package hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByIdSearchUserFilterPreparedStatementWriter implements PreparedStatementWriter<SearchUserFilter> {

	private final String filterName;

	public SelectAllByIdSearchUserFilterPreparedStatementWriter(String filterName) {
		this.filterName = filterName;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, filterName);
	}

}