package hu.ak_akademia.atos.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.atos.AtosRuntimeException;
import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

public abstract class AbstractDatabaseDao<E> implements DatabaseDao<E> {

	protected Connection connection;

	@Override
	public void openConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/atos", "atos", "admin");
		} catch (SQLException e) {
			throw new AtosRuntimeException("Az adatbázishoz való csatlakozás sikertelen.", e);
		}
	}

	@Override
	public void create(SqlBuilder sqlBuilder, PreparedStatementWriter<E> preparedStatementWriter) {
		try {
			String sql = sqlBuilder.buildSqlStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatementWriter.write(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new AtosRuntimeException("Hiba az adatbázisba történő adatbeszúrás közben.", e);
		}
	}

	@Override
	public E read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(E entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new AtosRuntimeException("Az adatbázishoz való csatlakozás nem sikerült lezárni.", e);
			}
		}
	}

}