package hu.ak_akademia.atos.db.sqlbuilder.searchmeetupfiltertagmap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateSearchMeetupFilterTagMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO search_meetup_filter_tag_map (search_meetup_filter_tag_map_id, search_meetup_filter_id, tag) VALUES (nextval('search_meetup_filter_tag_map_seq'), ?, ?)";
	}

}