package hu.ak_akademia.atos.db.sqlbuilder.country;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateCountrySqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO country (country_id, name) VALUES (nextval('country_seq'), ?)";
	}

}