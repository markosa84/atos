package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateUserInterestMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO user_interest_map (user_interest_map_id, username, interest_id) VALUES (nextval('user_interest_map_seq'), ?, ?)";
	}

}