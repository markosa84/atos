package hu.ak_akademia.atos.db.resultsetreader.userinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.resultsetreader.ResultSetReader;

public class SelectAllUserInfoResultSetReader implements ResultSetReader<UserInfo> {

	@Override
	public List<UserInfo> searchMeetupFilterTagMap(ResultSet resultSet) throws SQLException {
		List<UserInfo> results = new ArrayList<>();
		while (resultSet.next()) {
			String username = resultSet.getString("username");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String email = resultSet.getString("email");
			String passwordHash = resultSet.getString("password_hash");
			long cityId = resultSet.getLong("city_id");
			LocalDate dateOfBirth = resultSet.getDate("date_of_birth")
					.toLocalDate();
			long genderId = resultSet.getLong("gender_id");
			boolean showMeInSearch = resultSet.getBoolean("show_me_in_search");
			boolean showAllDetails = resultSet.getBoolean("show_all_details");
			boolean paid = resultSet.getBoolean("paid");

			UserInfo userInfo = UserInfo.builder()
					.withUserName(username)
					.withFirstName(firstName)
					.withLastName(lastName)
					.withEmail(email)
					.withPasswordHash(passwordHash)
					.withCityId(cityId)
					.withDateOfBirth(dateOfBirth)
					.withGenderId(genderId)
					.withShowMeInSearch(showMeInSearch)
					.withShowAllDetails(showAllDetails)
					.withPaid(paid)
					.build();

			results.add(userInfo);
		}
		return results;
	}

}