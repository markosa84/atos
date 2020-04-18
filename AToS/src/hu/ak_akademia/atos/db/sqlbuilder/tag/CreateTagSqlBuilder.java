package hu.ak_akademia.atos.db.sqlbuilder.tag;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateTagSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO tag (tag) VALUES (?)";
	}

}