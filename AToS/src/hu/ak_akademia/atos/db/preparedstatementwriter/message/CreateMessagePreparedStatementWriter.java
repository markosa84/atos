package hu.ak_akademia.atos.db.preparedstatementwriter.message;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import hu.ak_akademia.atos.db.entity.Message;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateMessagePreparedStatementWriter implements PreparedStatementWriter<Message> {

	private final Message message;

	public CreateMessagePreparedStatementWriter(Message message) {
		this.message = message;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, message.getUsernameFrom());
		preparedStatement.setString(i++, message.getUsernameTo());
		preparedStatement.setTimestamp(i++, Timestamp.valueOf(message.getDateAndTime()));
		preparedStatement.setString(i++, message.getMessageText());
	}

}