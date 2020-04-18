package hu.ak_akademia.atos.db.sqlbuilder.searchmeetupfilter;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdSearchMeetupFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT search_meetup_filter_id, interest_id, city_id FROM search_meetup_filter WHERE search_meetup_filter_id = ?";
	}

}