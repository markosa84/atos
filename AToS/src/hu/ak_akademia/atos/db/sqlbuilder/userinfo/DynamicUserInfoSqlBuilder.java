package hu.ak_akademia.atos.db.sqlbuilder.userinfo;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class DynamicUserInfoSqlBuilder implements SqlBuilder {

	private final SearchUserFilter filter;

	public DynamicUserInfoSqlBuilder(SearchUserFilter filter) {
		this.filter = filter;
	}

	@Override
	public String buildSqlStatement() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ui.username, ");
		sql.append("	ui.first_name, ");
		sql.append("	ui.last_name, ");
		sql.append("	ui.email, ");
		sql.append("	ui.password_hash, ");
		sql.append("	ui.city_id, ");
		sql.append("	ui.date_of_birth, ");
		sql.append("	ui.gender_id, ");
		sql.append("	ui.show_me_in_search, ");
		sql.append("	ui.show_all_details, ");
		sql.append("	ui.paid ");
		sql.append("FROM user_info ui INNER JOIN user_interest_map uim ON ui.username = uim.username ");
		sql.append("WHERE uim.interest_id = ? ");
		sql.append("AND ui.city_id = ? ");
		if (filter.getGenderId() != null) {
			sql.append("AND ui.gender_id = ? ");
		}
		if (filter.getAgeFrom() != null) {
			sql.append("AND (current_date - ui.date_of_birth) / 365 >= ? ");
		}
		if (filter.getAgeTo() != null) {
			sql.append("AND (current_date - ui.date_of_birth) / 365 <= ? ");
		}
		return sql.toString();
	}

}