package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateInterestSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO interests (interest_id, name, description) VALUES (nextval('interest_seq'), ?, ?)";
	}

}