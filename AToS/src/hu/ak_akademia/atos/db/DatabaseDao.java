package hu.ak_akademia.atos.db;

/**
 * DAO = Data Access Object
 */
public interface DatabaseDao<E> {

	void openConnection();

	// CRUD
	void create(E entity);

	E read();

	void update(E entity);

	void delete(E entity);

	void closeConnection();

}