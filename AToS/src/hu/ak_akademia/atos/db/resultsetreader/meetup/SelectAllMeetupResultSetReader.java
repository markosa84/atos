package hu.ak_akademia.atos.db.resultsetreader.meetup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.Meetup;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllMeetupResultSetReader implements ResultSetReader<Meetup> {

	@Override
	public List<Meetup> read(ResultSet resultSet) throws SQLException {
		List<Meetup> results = new ArrayList<>();
		while (resultSet.next()) {
			long meetupId = resultSet.getLong("meetup_id");
			String username = resultSet.getString("username");
			long interestId = resultSet.getLong("interest_id");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			boolean online = resultSet.getBoolean("online");
			long cityId = resultSet.getLong("city_id");
			String location = resultSet.getString("location");
			LocalDateTime dateAndTime = resultSet.getTimestamp("date_and_time")
					.toLocalDateTime();
			double duration = resultSet.getLong("duration");
			int participantLimit = resultSet.getInt("participant_limit");

			Meetup meetup = Meetup.builder()
					.withMeetupId(meetupId)
					.withUsername(username)
					.withInterestId(interestId)
					.withName(name)
					.withDescription(description)
					.withOnline(online)
					.withCityId(cityId)
					.withLocation(location)
					.withDateAndTime(dateAndTime)
					.withDuration(duration)
					.withParticipantLimit(participantLimit)
					.build();

			results.add(meetup);
		}
		return results;
	}

}