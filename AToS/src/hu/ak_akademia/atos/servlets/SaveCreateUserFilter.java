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
import hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter.CreateSearchUserFilterPreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter.CreateSearchUserFilterSqlBuilder;
import hu.ak_akademia.atos.logic.CityValidator;
import hu.ak_akademia.atos.logic.GenderValidator;
import hu.ak_akademia.atos.logic.InterestValidator;
import hu.ak_akademia.atos.logic.UserFilterValidator;

public class SaveCreateUserFilter extends HttpServlet {

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
			SearchUserFilter searchUserFilter = SearchUserFilter.builder()
					.withDisplayName(filterName)
					.withInterestId(Long.parseLong(interestIdAsString))
					.withCityId(Long.parseLong(cityIdAsString))
					.withGenderId(Long.parseLong(genderIdAsString))
					.withFromAge(Integer.parseInt(ageFromAsString))
					.withToAge(Integer.parseInt(ageToAsString))
					.build();

			SearchUserFilterDao searchUserFilterDao = new SearchUserFilterDao();
			searchUserFilterDao.openConnection();
			searchUserFilterDao.create(new CreateSearchUserFilterSqlBuilder(), new CreateSearchUserFilterPreparedStatementWriter(searchUserFilter));
			searchUserFilterDao.closeConnection();
			response.sendRedirect(request.getContextPath() + "/loadCreateUserFilter");
		} else {
			StringJoiner invalidFieldJoiner = new StringJoiner("&", "&", "");
			for (String invalidField : invalidFields) {
				invalidFieldJoiner.add(invalidField + "=true");
			}
			response.sendRedirect(request.getContextPath() + "/createUserFilter.jsp?" + previousValues + invalidFieldJoiner);
		}
	}

	private void validate(UserFilterValidator userFilterValidator, String filterName, String interestIdAsString, String cityIdAsString, String genderIdAsString, String ageFromAsString, String ageToAsString, Set<String> invalidFields) {
		userFilterValidator.validateFilterName(filterName, invalidFields);
		new InterestValidator().validateInterest(interestIdAsString, invalidFields);
		new CityValidator().validateCity(cityIdAsString, invalidFields);
		if (!genderIdAsString.trim()
				.isEmpty()) {
			new GenderValidator().validateGender(genderIdAsString, invalidFields);
		}
		if (!ageFromAsString.trim()
				.isEmpty()) {
			userFilterValidator.validateAgeFrom(ageFromAsString, invalidFields);
		}
		if (!ageToAsString.trim()
				.isEmpty()) {
			userFilterValidator.validateAgeTo(ageToAsString, invalidFields);
		}
		if (!ageFromAsString.trim()
				.isEmpty()
				&& !ageToAsString.trim()
						.isEmpty()) {
			userFilterValidator.validateAgeInterval(ageFromAsString, ageToAsString, invalidFields);
		}
	}

}