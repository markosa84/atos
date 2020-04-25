package hu.ak_akademia.atos.db.resultsetreader.message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.Message;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllMessageResultSetReader implements ResultSetReader<Message> {

	@Override
	public List<Message> read(ResultSet resultSet) throws SQLException {
		List<Message> results = new ArrayList<>();
		while (resultSet.next()) {
			Long messageId = resultSet.getLong("message_id");
			String usernameFrom = resultSet.getString("username_from");
			String usernameTo = resultSet.getString("username_to");
			LocalDateTime dateAndTime = resultSet.getTimestamp("date_and_time")
					.toLocalDateTime();
			String messageText = resultSet.getString("message_text");

			Message message = Message.builder()
					.withMessageId(messageId)
					.withUsernameFrom(usernameFrom)
					.withUsernameTo(usernameTo)
					.withDateAndTime(dateAndTime)
					.withMessageText(messageText)
					.build();

			results.add(message);
		}
		return results;
	}
}
