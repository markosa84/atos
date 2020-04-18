package hu.ak_akademia.atos.db.sqlbuilder.meetup;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateMeetupSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO meetup (meetup_id, username, interest_id, name, description, online, city_id, location, date_and_time, duration, participant_limit) VALUES (nextval('meetup_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

}