package hu.ak_akademia.atos.db.sqlbuilder.searchmeetupfiltertagmap;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdSearchMeetupFilterTagMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT search_meetup_filter_tag_map_id, search_meetup_filter_id, tag FROM search_meetup_filter_tag_map WHERE search_meetup_filter_tag_map_id = ?";
	}

}