package hu.ak_akademia.atos.db.sqlbuilder.meetupusermap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdMeetupUserMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT meetup_user_map_id, meetup_id, username FROM meetup_user_map WHERE meetup_user_map_id = ?";
	}

}