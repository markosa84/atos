package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.SearchUserFilterDao;
import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.entity.SearchUserFilter.Builder;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter.CreateSearchUserFilterPreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter.CreateSearchUserFilterSqlBuilder;
import hu.ak_akademia.atos.logic.CityValidator;
import hu.ak_akademia.atos.logic.GenderValidator;
import hu.ak_akademia.atos.logic.InterestValidator;
import hu.ak_akademia.atos.logic.UserFilterValidator;

public class SaveCreateUserFilterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filterName = request.getParameter("filterName");
		String interestIdAsString = request.getParameter("interest");
		String cityIdAsString = request.getParameter("city");
		String genderIdAsString = request.getParameter("gender");
		String ageFromAsString = request.getParameter("ageFrom");
		String ageToAsString = request.getParameter("ageTo");

		UserFilterValidator userFilterValidator = new UserFilterValidator();

		String previousValues = userFilterValidator.getPreviousValues(filterName, interestIdAsString, cityIdAsString, genderIdAsString, ageFromAsString, ageToAsString);

		Set<String> invalidFields = new HashSet<>();
		validate(userFilterValidator, filterName, interestIdAsString, cityIdAsString, genderIdAsString, ageFromAsString, ageToAsString, invalidFields);

		if (invalidFields.isEmpty()) {
			UserInfo loggedInUser = (UserInfo) request.getSession()
					.getAttribute("loggedInUser");

			Builder searchUserFilterBuilder = SearchUserFilter.builder()
					.withUsername(loggedInUser.getUsername())
					.withDisplayName(filterName)
					.withInterestId(Long.parseLong(interestIdAsString))
					.withCityId(Long.parseLong(cityIdAsString));
			if (isGenderSpecified(genderIdAsString)) {
				searchUserFilterBuilder.withGenderId(Long.parseLong(genderIdAsString));
			}
			if (isAgeSpecified(ageFromAsString)) {
				searchUserFilterBuilder.withAgeFrom(Integer.parseInt(ageFromAsString));
			}
			if (isAgeSpecified(ageToAsString)) {
				searchUserFilterBuilder.withAgeTo(Integer.parseInt(ageToAsString));
			}
			SearchUserFilter searchUserFilter = searchUserFilterBuilder.build();

			SearchUserFilterDao searchUserFilterDao = new SearchUserFilterDao();
			searchUserFilterDao.openConnection();
			searchUserFilterDao.create(new CreateSearchUserFilterSqlBuilder(searchUserFilter), new CreateSearchUserFilterPreparedStatementWriter(searchUserFilter));
			searchUserFilterDao.closeConnection();
			response.sendRedirect(request.getContextPath() + "/loadSearchUser?saveSuccessful=true");
		} else {
			StringJoiner invalidFieldJoiner = new StringJoiner("&", "&", "");
			for (String invalidField : invalidFields) {
				invalidFieldJoiner.add(invalidField + "=true");
			}
			response.sendRedirect(request.getContextPath() + "/loadCreateUserFilter?" + previousValues + invalidFieldJoiner);
		}
	}

	private boolean isAgeSpecified(String ageAsString) {
		return !ageAsString.trim()
				.isEmpty();
	}

	private boolean isGenderSpecified(String genderIdAsString) {
		return !genderIdAsString.trim()
				.isEmpty() && !"-1".equals(genderIdAsString.trim());
	}

	private void validate(UserFilterValidator userFilterValidator, String filterName, String interestIdAsString, String cityIdAsString, String genderIdAsString, String ageFromAsString, String ageToAsString, Set<String> invalidFields) {
		userFilterValidator.validateFilterName(filterName, invalidFields);
		new InterestValidator().validateInterest(interestIdAsString, invalidFields);
		new CityValidator().validateCity(cityIdAsString, invalidFields);
		if (isGenderSpecified(genderIdAsString)) {
			new GenderValidator().validateGender(genderIdAsString, invalidFields);
		}
		if (isAgeSpecified(ageFromAsString)) {
			userFilterValidator.validateAgeFrom(ageFromAsString, invalidFields);
		}
		if (isAgeSpecified(ageToAsString)) {
			userFilterValidator.validateAgeTo(ageToAsString, invalidFields);
		}
		if (isAgeSpecified(ageFromAsString) && isAgeSpecified(ageToAsString)) {
			userFilterValidator.validateAgeInterval(ageFromAsString, ageToAsString, invalidFields);
		}
	}

}