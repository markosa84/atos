package hu.ak_akademia.atos.db.resultsetreader.meetupusermap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.MeetupUserMap;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllMeetupUserMapResultSetReader implements ResultSetReader<MeetupUserMap> {

	@Override
	public List<MeetupUserMap> read(ResultSet resultSet) throws SQLException {
		List<MeetupUserMap> results = new ArrayList<>();
		while (resultSet.next()) {
			long userInterestMapId = resultSet.getLong("meetup_user_map_id");
			long meetupId = resultSet.getLong("meetup_id");
			String username = resultSet.getString("username");

			MeetupUserMap meetupUserMap = MeetupUserMap.builder()
					.withMeetupUserMapId(userInterestMapId)
					.withMeetupId(meetupId)
					.withUsername(username)
					.build();

			results.add(meetupUserMap);
		}
		return results;
	}

}