package hu.ak_akademia.atos.db.sqlbuilder;

public class SearchUserFilterSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO searchUserFilter (search_user_filter_id, display_name,interest_id, city_id, gender_id,from_age, to_age) VALUES (nextval('search_user_seq'), ?, ?,?,?,?,?)";
	}

}
