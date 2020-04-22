package hu.ak_akademia.atos.db.resultsetreader.searchmeetupfilter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.SearchMeetupFilter;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllSearchMeetupFilterResultSetReader implements ResultSetReader<SearchMeetupFilter> {

	@Override
	public List<SearchMeetupFilter> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<SearchMeetupFilter> results = new ArrayList<>();
		while (resultSet.next()) {
			long searchMeetupFilterId = resultSet.getLong("search_meetup_filter_id");
			long interestId = resultSet.getLong("interest_id");
			String displayName = resultSet.getString("display_name");
			String description = resultSet.getString("descripption");
			boolean online = resultSet.getBoolean("online");
			long cityId = resultSet.getLong("city_id");
			String location = resultSet.getString("location");
			LocalDateTime dateAndTimeFrom;
			LocalDateTime dateAndTimeTo;
			Double durationFrom = resultSet.getDouble("duration_from");
			Double durationTo = resultSet.getDouble("duration_to");
			Integer participantLimitFrom = resultSet.getInt("participant_limit_from");
			Integer participantLimitTo = resultSet.getInt("participant_limit_to");

			SearchMeetupFilter searchMeetupFilter = SearchMeetupFilter.builder()
					.withSearchMeetupFilterId(searchMeetupFilterId)
					.withInterestId(interestId)
					.withDisplayName(displayName)
					.withDescription(description)
					.withOnline(online)
					.withCityId(cityId)
					.withLocation(location)
					.withDateAndTimeFrom(dateAndTimeFrom)
					.withDateAndTimeTo(dateAndTimeTo)
					.withDurationFrom(durationFrom)
					.withDurationTo(durationTo)
					.withParticipantLimitFrom(participantLimitFrom)
					.withParticipantLimitTo(participantLimitTo)
					.build();
		}
		return results;
	}
}
