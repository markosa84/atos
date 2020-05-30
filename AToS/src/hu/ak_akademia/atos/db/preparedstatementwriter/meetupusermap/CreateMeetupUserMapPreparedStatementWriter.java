package hu.ak_akademia.atos.db.preparedstatementwriter.meetupusermap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.MeetupUserMap;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateMeetupUserMapPreparedStatementWriter implements PreparedStatementWriter<MeetupUserMap> {

	private final MeetupUserMap meetupUserMap;

	public CreateMeetupUserMapPreparedStatementWriter(MeetupUserMap meetupUserMap) {
		this.meetupUserMap = meetupUserMap;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, meetupUserMap.getMeetupId());
		preparedStatement.setString(i++, meetupUserMap.getUsername());
	}

}