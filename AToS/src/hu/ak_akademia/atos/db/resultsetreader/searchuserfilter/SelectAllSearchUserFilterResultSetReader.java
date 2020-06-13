package hu.ak_akademia.atos.db.resultsetreader.searchuserfilter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllSearchUserFilterResultSetReader implements ResultSetReader<SearchUserFilter> {

	@Override
	public List<SearchUserFilter> read(ResultSet resultSet) throws SQLException {
		List<SearchUserFilter> results = new ArrayList<>();
		while (resultSet.next()) {
			long searchUserFilterId = resultSet.getLong("search_user_filter_id");
			String displayName = resultSet.getString("display_name");
			Long interestId = resultSet.getLong("interest_id");
			Long cityId = resultSet.getLong("city_id");
			Long genderId = resultSet.getLong("gender_id");
			genderId = resultSet.wasNull() ? null : genderId;
			Integer ageFrom = resultSet.getInt("age_from");
			ageFrom = resultSet.wasNull() ? null : ageFrom;
			Integer ageTo = resultSet.getInt("age_to");
			ageTo = resultSet.wasNull() ? null : ageTo;

			SearchUserFilter searchUserFilter = SearchUserFilter.builder()
					.withSearchUserFilterId(searchUserFilterId)
					.withDisplayName(displayName)
					.withInterestId(interestId)
					.withCityId(cityId)
					.withGenderId(genderId)
					.withAgeFrom(ageFrom)
					.withAgeTo(ageTo)
					.build();

			results.add(searchUserFilter);
		}
		return results;
	}

}