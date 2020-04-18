package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateUserInterestMapSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO user_interest_map (userInterestMapId, username, interestId, ) VALUES (?, ?, ?)";
	}
}