package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.dao.GenderDao;
import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.city.SelectAllByIdCityPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.gender.SelectAllByIdGenderPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.CreateUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.SelectAllByIdUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.gender.SelectAllGenderResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllByIdCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.SelectAllByIdGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.CreateUserInfoSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.SelectAllByIdUserInfoSqlBuilder;
import hu.ak_akademia.atos.util.PasswordHandler;

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String cityIdAsString = request.getParameter("city");
		String dateOfBirthAsString = request.getParameter("dateOfBirth");
		String genderIdAsString = request.getParameter("gender");
		String showMeInSearchAsString = request.getParameter("showMeInSearch");
		String showAllDetailsAsString = request.getParameter("showAllDetails");

		String previousValues = getPreviousValues(username, firstName, lastName, email, cityIdAsString, dateOfBirthAsString, genderIdAsString, showMeInSearchAsString, showAllDetailsAsString);

		Set<String> invalidFields = new HashSet<>();
		validate(username, firstName, lastName, email, password, passwordConfirm, cityIdAsString, dateOfBirthAsString, genderIdAsString, invalidFields);
		boolean showMeInSearch = showMeInSearchAsString != null;
		boolean showAllDetails = showAllDetailsAsString != null;

		if (invalidFields.isEmpty()) {
			UserInfo userInfo = UserInfo.builder()
					.withUserName(username)
					.withFirstName(firstName)
					.withLastName(lastName)
					.withEmail(email)
					.withCityId(Long.parseLong(cityIdAsString))
					.withGenderId(Long.parseLong(genderIdAsString))
					.withPasswordHash(PasswordHandler.generateHash(password))
					.withDateOfBirth(convertToDate(dateOfBirthAsString))
					.withPaid(false)
					.withShowAllDetails(showAllDetails)
					.withShowMeInSearch(showMeInSearch)
					.build();
			UserInfoDao userInfoDao = new UserInfoDao();
			userInfoDao.openConnection();
			userInfoDao.create(new CreateUserInfoSqlBuilder(), new CreateUserInfoPreparedStatementWriter(userInfo));
			userInfoDao.closeConnection();
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		} else {
			StringJoiner invalidFieldJoiner = new StringJoiner("&", "&", "");
			for (String invalidField : invalidFields) {
				invalidFieldJoiner.add(invalidField + "=true");
			}
			response.sendRedirect(request.getContextPath() + "/registration?" + previousValues + invalidFieldJoiner);
		}

	}

	private String getPreviousValues(String username, String firstName, String lastName, String email, String cityIdAsString, String dateOfBirthAsString, String genderIdAsString, String showMeInSearchAsString, String showAllDetailsAsString) {
		StringJoiner joiner = new StringJoiner("&");
		joiner.add("username=" + username);
		joiner.add("firstName=" + firstName);
		joiner.add("lastName=" + lastName);
		joiner.add("email=" + email);
		joiner.add("city=" + cityIdAsString);
		joiner.add("dateOfBirth=" + dateOfBirthAsString);
		joiner.add("gender=" + genderIdAsString);
		if (showMeInSearchAsString != null) {
			joiner.add("showMeInSearch");
		}
		if (showAllDetailsAsString != null) {
			joiner.add("showAllDetails");
		}
		return joiner.toString();
	}

	private void validate(String username, String firstName, String lastName, String email, String password, String passwordConfirm, String cityIdAsString, String dateOfBirthAsString, String genderIdAsString, Set<String> invalidFields) {
		validateUsername(username, invalidFields);
		validateFirstName(firstName, invalidFields);
		validateLastName(lastName, invalidFields);
		validateEmail(email, invalidFields);
		validatePassword(password, invalidFields);
		validatePasswordConfirm(password, passwordConfirm, invalidFields);
		validateCity(cityIdAsString, invalidFields);
		validateGender(genderIdAsString, invalidFields);
		validateDateOfBirth(dateOfBirthAsString, invalidFields);
	}

	private void validateDateOfBirth(String dateOfBirthAsString, Set<String> invalidFields) {
		if (isInvalidLength(dateOfBirthAsString)) {
			invalidFields.add("dateOfBirthInvalid");
			return;
		}
		LocalDate dateOfBirth = null;
		try {
			dateOfBirth = convertToDate(dateOfBirthAsString);
		} catch (DateTimeParseException e) {
			invalidFields.add("dateOfBirthInvalid");
			return;
		}
		if (dateOfBirth.isAfter(LocalDate.now()
				.minusYears(18L))) {
			invalidFields.add("dateOfBirthInvalid");
			return;
		}
	}

	private LocalDate convertToDate(String dateOfBirthAsString) {
		return LocalDate.parse(dateOfBirthAsString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	private void validateGender(String genderIdAsString, Set<String> invalidFields) {
		if (isInvalidLength(genderIdAsString)) {
			invalidFields.add("genderInvalid");
			return;
		}
		long genderId = -1;
		try {
			genderId = Long.parseLong(genderIdAsString);
		} catch (NumberFormatException e) {
			invalidFields.add("genderInvalid");
			return;
		}
		GenderDao genderDao = new GenderDao();
		genderDao.openConnection();
		List<Gender> genders = genderDao.read(new SelectAllByIdGenderSqlBuilder(), new SelectAllByIdGenderPreparedStatementWriter(genderId), new SelectAllGenderResultSetReader());
		genderDao.closeConnection();
		if (genders.isEmpty()) {
			invalidFields.add("genderInvalid");
			return;
		}
	}

	private void validateCity(String cityIdAsString, Set<String> invalidFields) {
		if (isInvalidLength(cityIdAsString)) {
			invalidFields.add("cityInvalid");
			return;
		}
		long cityId = -1;
		try {
			cityId = Long.parseLong(cityIdAsString);
		} catch (NumberFormatException e) {
			invalidFields.add("cityInvalid");
			return;
		}
		CityDao cityDao = new CityDao();
		cityDao.openConnection();
		List<City> cities = cityDao.read(new SelectAllByIdCitySqlBuilder(), new SelectAllByIdCityPreparedStatementWriter(cityId), new SelectAllCityResultSetReader());
		cityDao.closeConnection();
		if (cities.isEmpty()) {
			invalidFields.add("cityInvalid");
			return;
		}
	}

	private void validatePasswordConfirm(String password, String passwordConfirm, Set<String> invalidFields) {
		if (isInvalidLength(passwordConfirm) || !passwordConfirm.equals(password) || invalidFields.contains("passwordInvalid")) {
			invalidFields.add("passwordConfirmInvalid");
		}
	}

	private void validatePassword(String password, Set<String> invalidFields) {
		if (isInvalidLength(password, 8, 15) || !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*](?=\\S+$).{8,15}$")) {
			invalidFields.add("passwordInvalid");
		}
	}

	private void validateEmail(String email, Set<String> invalidFields) {
		if (isInvalidLength(email, 100)) {
			invalidFields.add("emailInvalid");
		}
	}

	private void validateLastName(String lastName, Set<String> invalidFields) {
		if (isInvalidLength(lastName, 100)) {
			invalidFields.add("lastNameInvalid");
		}
	}

	private void validateFirstName(String firstName, Set<String> invalidFields) {
		if (isInvalidLength(firstName, 100)) {
			invalidFields.add("firstNameInvalid");
		}
	}

	private void validateUsername(String username, Set<String> invalidFields) {
		if (username == null || username.trim()
				.isEmpty() || username.length() < 3 || username.length() > 20) {
			invalidFields.add("usernameInvalid");
			return;
		}
		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.openConnection();
		List<UserInfo> userinfos = userInfoDao.read(new SelectAllByIdUserInfoSqlBuilder(), new SelectAllByIdUserInfoPreparedStatementWriter(username), new SelectAllUserInfoResultSetReader());
		userInfoDao.closeConnection();
		if (!userinfos.isEmpty()) {
			invalidFields.add("usernameInvalid");
			return;
		}
	}

	private boolean isInvalidLength(String field) {
		return field == null || field.trim()
				.isEmpty();
	}

	private boolean isInvalidLength(String field, int maxLength) {
		return isInvalidLength(field) || field.length() > maxLength;
	}

	private boolean isInvalidLength(String field, int minLength, int maxLength) {
		return isInvalidLength(field, maxLength) || field.length() < minLength;
	}

}