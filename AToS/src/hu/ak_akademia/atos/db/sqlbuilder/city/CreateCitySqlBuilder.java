package hu.ak_akademia.atos.db.sqlbuilder.city;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateCitySqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO city (city_id, country_id, name) VALUES (nextval('city_seq'), ?, ?)";
	}

}