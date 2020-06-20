package hu.ak_akademia.atos.db.sqlbuilder.message;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectChatPartnersForUsernameSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT username_to username ");
		sql.append("FROM message ");
		sql.append("WHERE username_from = ? ");
		sql.append("GROUP BY username_from, ");
		sql.append("	username_to ");
		sql.append("UNION ");
		sql.append("SELECT username_from username ");
		sql.append("FROM message ");
		sql.append("WHERE username_to = ? ");
		sql.append("GROUP BY username_from, ");
		sql.append("	username_to ");
		return sql.toString();
	}

}