package hu.ak_akademia.atos.db.preparedstatementwriter.tag;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.Tag;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateTagPreparedStatementWriter implements PreparedStatementWriter<Tag> {

	private final Tag tag;

	public CreateTagPreparedStatementWriter(Tag tag) {
		this.tag = tag;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, tag.getTag());

	}

}
