package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateTagSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO tag (tag) VALUES (?)";
	}

}