package hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateSearchUserFilterSqlBuilder implements SqlBuilder {

	private final SearchUserFilter searchUserFilter;

	public CreateSearchUserFilterSqlBuilder(SearchUserFilter searchUserFilter) {
		this.searchUserFilter = searchUserFilter;
	}

	@Override
	public String buildSqlStatement() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO search_user_filter ( ");
		sql.append("	search_user_filter_id, ");
		sql.append("	username, ");
		sql.append("	display_name, ");
		sql.append("	interest_id, ");
		sql.append("	city_id ");
		if (searchUserFilter.getGenderId() != null) {
			sql.append("	, gender_id ");
		}
		if (searchUserFilter.getAgeFrom() != null) {
			sql.append("	, age_from ");
		}
		if (searchUserFilter.getAgeTo() != null) {
			sql.append("	, age_to ");
		}
		sql.append("	) ");
		sql.append("VALUES ( ");
		sql.append("	nextval('search_user_filter_seq'), ");
		sql.append("	?, ");
		sql.append("	?, ");
		sql.append("	?, ");
		sql.append("	? ");
		if (searchUserFilter.getGenderId() != null) {
			sql.append("	, ? ");
		}
		if (searchUserFilter.getAgeFrom() != null) {
			sql.append("	, ? ");
		}
		if (searchUserFilter.getAgeTo() != null) {
			sql.append("	, ? ");
		}
		sql.append("	) ");
		return sql.toString();
	}

}