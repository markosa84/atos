package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.MeetUpTagMap;

public class CreateMeetUpTagMapPreparedStatementWriter implements PreparedStatementWriter<MeetUpTagMap> {

	private final MeetUpTagMap meetUpTagMap;

	public CreateMeetUpTagMapPreparedStatementWriter(MeetUpTagMap meetUpTagMap) {
		this.meetUpTagMap = meetUpTagMap;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, meetUpTagMap.getMeetupTagMapId());
		preparedStatement.setLong(i++, meetUpTagMap.getMeetupId());
		preparedStatement.setString(i++, meetUpTagMap.getTag());
		
	}


}
