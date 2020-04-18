package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateUserInfoSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO user_info (username, first_name, last_name, email, password_hash, city_id, date_of_birth, gender_id, show_me_in_search, show_all_details, paid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

}