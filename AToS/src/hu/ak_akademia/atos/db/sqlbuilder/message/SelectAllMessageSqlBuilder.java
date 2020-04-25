package hu.ak_akademia.atos.db.sqlbuilder.message;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllMessageSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT message_id, usernameFrom, usernameTo, date_and_time, message_text FROM message";
	}

}