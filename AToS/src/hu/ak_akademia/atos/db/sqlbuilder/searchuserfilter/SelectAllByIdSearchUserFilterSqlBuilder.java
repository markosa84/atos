package hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdSearchUserFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT search_user_filter_id, display_name, interest_id, city_id, gender_id, from_age, to_age FROM search_user_filter WHERE search_user_filter_id = ?";
	}

}