package hu.ak_akademia.atos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	public void create(E entity) {
		// TODO Auto-generated method stub

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