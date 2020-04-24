package hu.ak_akademia.atos.db.sqlbuilder.profilepicture;

import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public class SelectAllByIdProfilePictureSqlBuilder implements SqlBuilder {

	@Override
	public String buildSqlStatement() {
		return "SELECT picture_id, description, image_content, username FROM profile_picture WHERE picture_id = ?";
	}

}