package hu.ak_akademia.atos.db.sqlbuilder.city;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdCitySqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT city_id, country_id, name FROM city WHERE city_id = ?";
	}

}