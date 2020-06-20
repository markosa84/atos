package hu.ak_akademia.atos.db.resultsetreader.message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectChatPartnersForUsernameResultSetReader implements ResultSetReader<String> {

	@Override
	public List<String> read(ResultSet resultSet) throws SQLException {
		List<String> usernames = new ArrayList<>();
		while (resultSet.next()) {
			String username = resultSet.getString("username");
			usernames.add(username);
		}
		return usernames;
	}

}