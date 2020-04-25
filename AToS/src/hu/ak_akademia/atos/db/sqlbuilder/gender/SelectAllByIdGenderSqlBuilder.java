package hu.ak_akademia.atos.db.sqlbuilder.gender;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdGenderSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT gender_id, name FROM city WHERE gender_id = ?";
	}

}