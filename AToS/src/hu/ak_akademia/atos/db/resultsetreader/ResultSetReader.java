package hu.ak_akademia.atos.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetReader<E> {

	List<E> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException;

}