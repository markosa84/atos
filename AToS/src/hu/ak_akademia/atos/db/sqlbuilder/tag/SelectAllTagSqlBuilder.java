package hu.ak_akademia.atos.db.sqlbuilder.tag;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllTagSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT tag FROM tag";
	}

}