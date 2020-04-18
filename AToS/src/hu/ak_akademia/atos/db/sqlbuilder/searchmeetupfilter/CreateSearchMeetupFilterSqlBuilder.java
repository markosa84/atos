package hu.ak_akademia.atos.db.sqlbuilder.searchmeetupfilter;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateSearchMeetupFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO search_meetup_filter (search_meetup_filter_id, interest_id, display_name, description, online, city_id, location, date_and_time_from, date_and_time_to, duration_from, duration_to, participant_limit_from, participant_limit_to) VALUES (nextval('search_meetup_filter_seq'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

}