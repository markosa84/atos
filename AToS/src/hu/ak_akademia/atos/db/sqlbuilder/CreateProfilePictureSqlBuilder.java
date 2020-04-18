package hu.ak_akademia.atos.db.sqlbuilder;

public class CreateProfilePictureSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "INSERT INTO profile_picture (picture_id, description, image_content, username) VALUES (nextval('picture_seq'), ?, ?, ?)";
	}

}