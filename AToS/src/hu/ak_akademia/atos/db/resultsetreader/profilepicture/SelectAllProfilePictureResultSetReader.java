package hu.ak_akademia.atos.db.resultsetreader.profilepicture;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.ProfilePicture;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllProfilePictureResultSetReader implements ResultSetReader<ProfilePicture> {

	@Override
	public List<ProfilePicture> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<ProfilePicture> results = new ArrayList<>();
		while (resultSet.next()) {
			long pictureId = resultSet.getLong("picture_id");
			String description = resultSet.getString("description");
			String username = resultSet.getString("username");

			ProfilePicture profilePicture = ProfilePicture.builder()
					.withPictureId(pictureId)
					.withDescription(description)
					.withUsername(username)
					.build();

			results.add(profilePicture);
		}
		return results;
	}

}