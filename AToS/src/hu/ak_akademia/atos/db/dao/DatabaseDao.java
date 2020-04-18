package hu.ak_akademia.atos.db.dao;

import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

/**
 * DAO = Data Access Object
 */
public interface DatabaseDao<E> {

	void openConnection();

	// CRUD

	void create(SqlBuilder sqlBuilder, PreparedStatementWriter<E> preparedStatementWriter);

	E read();

	void update(E entity);

	void delete(E entity);

	void closeConnection();

}