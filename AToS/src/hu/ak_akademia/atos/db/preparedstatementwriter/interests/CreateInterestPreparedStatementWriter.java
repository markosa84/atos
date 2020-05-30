package hu.ak_akademia.atos.db.preparedstatementwriter.interests;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.db.entity.Interest;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateInterestPreparedStatementWriter implements PreparedStatementWriter<Interest> {

	private final Interest interest;

	public CreateInterestPreparedStatementWriter(Interest interest) {
		this.interest = interest;
	}

	@Override
	public void write(PreparedStatement preparedStatement) throws SQLException {
		int i = 1;
		preparedStatement.setString(i++, interest.getName());
		preparedStatement.setString(i++, interest.getDescription());
	}

}