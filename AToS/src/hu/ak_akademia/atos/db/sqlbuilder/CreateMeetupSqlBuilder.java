package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateMeetupSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO meetup (meetupId, username, interestId, name, description, online, cityId, location, dateAndTime, duration, participantLimit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

}