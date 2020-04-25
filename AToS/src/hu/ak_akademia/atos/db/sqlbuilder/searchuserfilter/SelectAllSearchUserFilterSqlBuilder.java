package hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllSearchUserFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT search_user_filter_id, interest_id,city_id,gender_id FROM search_user_filter";
	}

}