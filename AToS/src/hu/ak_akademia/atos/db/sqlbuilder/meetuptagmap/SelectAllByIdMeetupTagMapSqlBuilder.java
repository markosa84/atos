package hu.ak_akademia.atos.db.sqlbuilder.meetuptagmap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdMeetupTagMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT meetup_tag_map_id, meetup_id, tag FROM meetup_tag_map WHERE meetup_tag_map_id = ?";
	}

}