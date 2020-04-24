package hu.ak_akademia.atos.db.resultsetreader.interests;

import hu.ak_akademia.atos.db.entity.Interest;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllInterestsResultSetReader implements ResultSetReader<Interest> {

	@Override
	public List<Interest> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<Interest> results = new ArrayList<>();
		while (resultSet.next()) {

			Long interestId = resultSet.getLong("interest_id");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");

			Interest interests = Interest.builder()
					.withInterestId(interestId)
					.withName(name)
					.withDescription(description)
					.build();

			results.add(interests);
		}
		return results;
	}
}