package hu.ak_akademia.atos.db.sqlbuilder.tag;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdTagSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT tag FROM tag WHERE tag = ?";
	}

}