package hu.ak_akademia.atos.db.resultsetreader.meetuptagmap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.MeetupTagMap;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllMeetupTagMapSetReader implements ResultSetReader<MeetupTagMap> {

	@Override
	public List<MeetupTagMap> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<MeetupTagMap> results = new ArrayList<>();
		while (resultSet.next()) {
			long meetupTagMapId = resultSet.getLong("meetup_tag_map_id");
			long meetupId = resultSet.getLong("meetup_id");
			String tag = resultSet.getString("tag");

			MeetupTagMap meetupTagMap = MeetupTagMap.builder()
					.withMeetupTagMapId(meetupTagMapId)
					.withMeetupId(meetupId)
					.withTag(tag)
					.build();

			results.add(meetupTagMap);
		}
		return results;
	}

}