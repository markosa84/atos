package hu.ak_akademia.atos.db.resultsetreader.userinterestmap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.UserInterestMap;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllUserInterestMapResultSetReader implements ResultSetReader<UserInterestMap> {

	@Override
	public List<UserInterestMap> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<UserInterestMap> results = new ArrayList<>();
		while (resultSet.next()) {
			long userInterestMapId = resultSet.getLong("user_interest_map_id");
			String username = resultSet.getString("username");
			long interestId = resultSet.getLong("interest_id");

			UserInterestMap userInterestMap = UserInterestMap.builder()
					.withUserInterestMapId(userInterestMapId)
					.withUsername(username)
					.withInterestId(interestId)
					.build();
		}
		return results;
	}

}
