package hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByNameSearchUserFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT search_user_filter_id, username, display_name, interest_id, city_id, gender_id, age_from, age_to FROM search_user_filter WHERE display_name = ?";
	}

}