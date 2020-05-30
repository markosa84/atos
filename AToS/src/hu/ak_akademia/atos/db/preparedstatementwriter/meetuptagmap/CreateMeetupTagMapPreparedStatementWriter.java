package hu.ak_akademia.atos.db.preparedstatementwriter.meetuptagmap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.MeetupTagMap;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateMeetupTagMapPreparedStatementWriter implements PreparedStatementWriter<MeetupTagMap> {

	private final MeetupTagMap meetupTagMap;

	public CreateMeetupTagMapPreparedStatementWriter(MeetupTagMap meetupTagMap) {
		this.meetupTagMap = meetupTagMap;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, meetupTagMap.getMeetupId());
		preparedStatement.setString(i++, meetupTagMap.getTag());

	}

}