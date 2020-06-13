package hu.ak_akademia.atos.db.dao;

import java.util.List;

import hu.ak_akademia.atos.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.SqlBuilder;

/**
 * DAO = Data Access Object
 */
public interface DatabaseDao<E> {

	void openConnection();

	// CRUD

	void create(SqlBuilder sqlBuilder, PreparedStatementWriter<E> preparedStatementWriter);

	<C> List<E> read(SqlBuilder sqlBuilder, PreparedStatementWriter<C> preparedStatementWriter, ResultSetReader<E> resultSetReader);

	<C> void update(SqlBuilder sqlBuilder, PreparedStatementWriter<C> preparedStatementWriter);

	<C> void delete(SqlBuilder sqlBuilder, PreparedStatementWriter<C> preparedStatementWriter);

	void closeConnection();

}