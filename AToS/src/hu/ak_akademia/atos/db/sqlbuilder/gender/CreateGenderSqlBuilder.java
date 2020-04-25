package hu.ak_akademia.atos.db.sqlbuilder.gender;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateGenderSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO gender (gender_id, name) VALUES (nextval('gender_seq'), ?)";
	}

}