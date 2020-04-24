package hu.ak_akademia.atos.db.sqlbuilder.interests;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdInterestsSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT interest_id, name, description FROM interests WHERE interest_id = ?";
	}

}