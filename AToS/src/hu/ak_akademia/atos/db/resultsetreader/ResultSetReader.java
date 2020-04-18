package hu.ak_akademia.atos.db.resultsetreader;

import java.util.List;

public interface ResultSetReader<E> {

	List<E> read();

}