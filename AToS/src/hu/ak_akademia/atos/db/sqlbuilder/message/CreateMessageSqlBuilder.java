package hu.ak_akademia.atos.db.sqlbuilder.message;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class CreateMessageSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO message (message_id, username_from, username_to, date_and_time, message_text) VALUES (nextval('message_seq'), ?, ?, ?, ?)";
	}

}