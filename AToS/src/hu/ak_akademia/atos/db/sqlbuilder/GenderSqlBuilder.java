package hu.ak_akademia.atos.db.sqlbuilder;

public class GenderSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO gender (gender_id, name) VALUES (gender_seq.nextval, ?)";
	}

}