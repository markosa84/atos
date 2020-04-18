package hu.ak_akademia.atos.db.sqlbuilder;

public class MessageSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO message (message_id, username_from, username_to, date_and_time, message_text) VALUES (nextval('message_id_seq'), ?, ?,?,?)";
	}
}
