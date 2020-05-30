package hu.ak_akademia.atos.db.sqlbuilder.userinfo;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdAndPasswordUserInfoSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT * FROM user_info WHERE username = ? AND password_hash = ?";
	}

}