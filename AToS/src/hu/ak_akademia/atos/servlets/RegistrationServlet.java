package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.CreateUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.CreateUserInfoSqlBuilder;
import hu.ak_akademia.atos.logic.UserBalanceValidator;
import hu.ak_akademia.atos.util.DateUtil;
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

		UserBalanceValidator userInfoValidator = new UserBalanceValidator();

		String previousValues = userInfoValidator.getPreviousValues(username, firstName, lastName, email, cityIdAsString, dateOfBirthAsString, genderIdAsString, showMeInSearchAsString, showAllDetailsAsString);

		Set<String> invalidFields = new HashSet<>();
		validate(userInfoValidator, username, firstName, lastName, email, password, passwordConfirm, cityIdAsString, dateOfBirthAsString, genderIdAsString, invalidFields);
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
					.withDateOfBirth(DateUtil.convert(dateOfBirthAsString))
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

	private void validate(UserBalanceValidator userInfoValidator, String username, String firstName, String lastName, String email, String password, String passwordConfirm, String cityIdAsString, String dateOfBirthAsString, String genderIdAsString, Set<String> invalidFields) {
		userInfoValidator.validateUsername(username, invalidFields);
		userInfoValidator.validateFirstName(firstName, invalidFields);
		userInfoValidator.validateLastName(lastName, invalidFields);
		userInfoValidator.validateEmail(email, invalidFields);
		userInfoValidator.validatePassword(password, invalidFields);
		userInfoValidator.validatePasswordConfirm(password, passwordConfirm, invalidFields);
		userInfoValidator.validateCity(cityIdAsString, invalidFields);
		userInfoValidator.validateGender(genderIdAsString, invalidFields);
		userInfoValidator.validateDateOfBirth(dateOfBirthAsString, invalidFields);
	}

}