package hu.ak_akademia.atos.db.resultsetreader.tag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.Tag;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllTagResultSetReader implements ResultSetReader<Tag> {

	@Override
	public List<Tag> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<Tag> results = new ArrayList<>();
		while (resultSet.next()) {
			String tagName = resultSet.getString("tag");
			Tag tag = Tag.builder()
					.withTag(tagName)
					.build();

			results.add(tag);
		}
		return results;
	}

}