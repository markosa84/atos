package hu.ak_akademia.atos.db.sqlbuilder.meetup;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdMeetupSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT meetup_id, username, interest_id, name, description, online, city_id, location, date_and_time, duration, participant_limit FROM meetup WHERE meetup_id = ?";
	}

}