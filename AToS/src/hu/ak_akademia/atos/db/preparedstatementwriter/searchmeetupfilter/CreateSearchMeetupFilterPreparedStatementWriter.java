package hu.ak_akademia.atos.db.preparedstatementwriter.searchmeetupfilter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import hu.ak_akademia.atos.db.entity.SearchMeetupFilter;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateSearchMeetupFilterPreparedStatementWriter implements PreparedStatementWriter<SearchMeetupFilter> {

	private final SearchMeetupFilter searchMeetupFilter;

	public CreateSearchMeetupFilterPreparedStatementWriter(SearchMeetupFilter searchMeetupFilter) {
		this.searchMeetupFilter = searchMeetupFilter;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, searchMeetupFilter.getInterestId());
		preparedStatement.setString(i++, searchMeetupFilter.getDisplayName());
		preparedStatement.setString(i++, searchMeetupFilter.getDescription());
		preparedStatement.setBoolean(i++, searchMeetupFilter.getOnline());
		preparedStatement.setLong(i++, searchMeetupFilter.getCityId());
		preparedStatement.setString(i++, searchMeetupFilter.getLocation());
		preparedStatement.setTimestamp(i++, Timestamp.valueOf(searchMeetupFilter.getDateAndTimeFrom()));
		preparedStatement.setTimestamp(i++, Timestamp.valueOf(searchMeetupFilter.getDateAndTimeTo()));
		preparedStatement.setDouble(i++, searchMeetupFilter.getDurationFrom());
		preparedStatement.setDouble(i++, searchMeetupFilter.getDurationTo());
		preparedStatement.setInt(i++, searchMeetupFilter.getParticipantLimitFrom());
		preparedStatement.setInt(i++, searchMeetupFilter.getParticipantLimitTo());
	}

}