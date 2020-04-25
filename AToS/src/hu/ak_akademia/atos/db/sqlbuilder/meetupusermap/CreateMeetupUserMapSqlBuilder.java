package hu.ak_akademia.atos.db.sqlbuilder.meetupusermap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateMeetupUserMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO meetup_user_map (meetup_user_map_id, meetup_id, username) VALUES (nextval('meetup_user_map_seq'), ?, ?)";
	}

}