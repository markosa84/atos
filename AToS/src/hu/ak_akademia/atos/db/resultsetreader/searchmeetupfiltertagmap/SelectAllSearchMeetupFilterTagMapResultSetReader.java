package hu.ak_akademia.atos.db.resultsetreader.searchmeetupfiltertagmap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.SearchMeetupFilterTagMap;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllSearchMeetupFilterTagMapResultSetReader implements ResultSetReader<SearchMeetupFilterTagMap> {

	@Override
	public List<SearchMeetupFilterTagMap> read(ResultSet resultSet) throws SQLException {
		List<SearchMeetupFilterTagMap> results = new ArrayList<>();
		while (resultSet.next()) {
			long searchMeetupFilterTagMapId = resultSet.getLong("search_meetup_filter_tag_map_id");
			long searchMeetupFilterId = resultSet.getLong("search_meetup_filter_id");
			String tag = resultSet.getString("tag");

			SearchMeetupFilterTagMap searchMeetupFilterTagMap = SearchMeetupFilterTagMap.builder()
					.withSearchMeetupFilterTagMapId(searchMeetupFilterTagMapId)
					.withSearchMeetupFilterId(searchMeetupFilterId)
					.withTag(tag)
					.build();

			results.add(searchMeetupFilterTagMap);
		}
		return results;
	}

}
