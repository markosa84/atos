package hu.ak_akademia.atos.db.preparedstatementwriter.interests;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class SelectAllByIdInterestsPreparedStatementWriter implements PreparedStatementWriter<SearchUserFilter> {

	private final long interestId;

	public SelectAllByIdInterestsPreparedStatementWriter(long interestId) {
		this.interestId = interestId;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(1, interestId);
	}

}