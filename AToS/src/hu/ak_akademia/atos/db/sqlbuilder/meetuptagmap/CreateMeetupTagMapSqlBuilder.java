package hu.ak_akademia.atos.db.sqlbuilder.meetuptagmap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateMeetupTagMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO meetup_tag_map (meetup_tag_map_id, meetup_id, tag) VALUES (nextval('meetup_tag_map_seq'), ?, ?)";
	}

}