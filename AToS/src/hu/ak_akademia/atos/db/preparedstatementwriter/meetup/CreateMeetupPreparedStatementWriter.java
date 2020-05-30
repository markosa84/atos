package hu.ak_akademia.atos.db.preparedstatementwriter.meetup;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import hu.ak_akademia.atos.db.entity.Meetup;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateMeetupPreparedStatementWriter implements PreparedStatementWriter<Meetup> {

	private final Meetup meetup;

	public CreateMeetupPreparedStatementWriter(Meetup meetup) {
		this.meetup = meetup;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, meetup.getUsername());
		preparedStatement.setLong(i++, meetup.getInterestId());
		preparedStatement.setString(i++, meetup.getName());
		preparedStatement.setString(i++, meetup.getDescription());
		preparedStatement.setBoolean(i++, meetup.getOnline());
		preparedStatement.setLong(i++, meetup.getCityId());
		preparedStatement.setString(i++, meetup.getLocation());
		preparedStatement.setTimestamp(i++, Timestamp.valueOf(meetup.getDateAndTime()));
		preparedStatement.setDouble(i++, meetup.getDuration());
		preparedStatement.setInt(i++, meetup.getParticipantLimit());
	}

}