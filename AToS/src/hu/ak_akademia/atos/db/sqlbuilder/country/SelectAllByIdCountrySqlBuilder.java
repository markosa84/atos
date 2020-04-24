package hu.ak_akademia.atos.db.sqlbuilder.country;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdCountrySqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT country_id, name FROM country WHERE country_id = ?";
	}

}