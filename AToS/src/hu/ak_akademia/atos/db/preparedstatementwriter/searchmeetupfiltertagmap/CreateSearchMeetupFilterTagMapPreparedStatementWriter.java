package hu.ak_akademia.atos.db.preparedstatementwriter.searchmeetupfiltertagmap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.SearchMeetupFilterTagMap;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateSearchMeetupFilterTagMapPreparedStatementWriter implements PreparedStatementWriter<SearchMeetupFilterTagMap> {

	private final SearchMeetupFilterTagMap searchMeetupFilterTagMap;

	public CreateSearchMeetupFilterTagMapPreparedStatementWriter(SearchMeetupFilterTagMap searchMeetupFilterTagMap) {
		this.searchMeetupFilterTagMap = searchMeetupFilterTagMap;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, searchMeetupFilterTagMap.getSearchMeetupFilterId());
		preparedStatement.setString(i++, searchMeetupFilterTagMap.getTag());
	}

}