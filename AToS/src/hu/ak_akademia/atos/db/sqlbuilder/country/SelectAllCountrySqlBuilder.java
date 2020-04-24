package hu.ak_akademia.atos.db.sqlbuilder.country;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllCountrySqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT country_id, name FROM country";
	}
	
}
