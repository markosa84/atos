package hu.ak_akademia.atos.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.ProfilePicture;

public class CreateProfilePicturePreparedStatementWriter implements PreparedStatementWriter<ProfilePicture> {

	private final ProfilePicture profilePicture;

	public CreateProfilePicturePreparedStatementWriter(ProfilePicture profilePicture) {
		this.profilePicture = profilePicture;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, profilePicture.getDescription());
		preparedStatement.setBytes(i++, profilePicture.getImageContent());
		preparedStatement.setString(i++, profilePicture.getUsername());
	}

}