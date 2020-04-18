package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.Message;

public class CreateMessagePreparedStatementWriter implements PreparedStatementWriter<City> {

	private final Message message;

	public CreateMessagePreparedStatementWriter(Message message) {
		this.message = message;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setLong(i++, message.getMessageId());
		preparedStatement.setString(i++, message.getUsernameFrom());
		preparedStatement.setString(i++, message.getUsernameTo());
		preparedStatement.setTimestamp(i++, Timestamp.valueOf(message.getDateAndTime()));
	}

}
