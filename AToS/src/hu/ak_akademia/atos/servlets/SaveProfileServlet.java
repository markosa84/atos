package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.SelectAllByIdUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.UpdateUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.SelectAllByIdUserInfoSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.UpdateUserInfoSqlBuilder;
import hu.ak_akademia.atos.logic.CityValidator;
import hu.ak_akademia.atos.logic.GenderValidator;
import hu.ak_akademia.atos.logic.UserInfoValidator;
import hu.ak_akademia.atos.util.DateUtil;
import hu.ak_akademia.atos.util.PasswordHandler;

public class SaveProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String oldPassword = request.getParameter("oldPassword");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String cityIdAsString = request.getParameter("city");
		String dateOfBirthAsString = request.getParameter("dateOfBirth");
		String genderIdAsString = request.getParameter("gender");
		String showMeInSearchAsString = request.getParameter("showMeInSearch");
		String showAllDetailsAsString = request.getParameter("showAllDetails");

		UserInfoValidator userInfoValidator = new UserInfoValidator();

		String previousValues = userInfoValidator.getPreviousValues(username, firstName, lastName, email, cityIdAsString, dateOfBirthAsString, genderIdAsString, showMeInSearchAsString, showAllDetailsAsString);

		Set<String> invalidFields = new HashSet<>();
		validate(userInfoValidator, username, firstName, lastName, email, oldPassword, password, passwordConfirm, cityIdAsString, dateOfBirthAsString, genderIdAsString, invalidFields);
		boolean showMeInSearch = showMeInSearchAsString != null;
		boolean showAllDetails = showAllDetailsAsString != null;

		if (invalidFields.isEmpty()) {
			UserInfoDao userInfoDao = new UserInfoDao();
			userInfoDao.openConnection();
			List<UserInfo> userInfos = userInfoDao.read(new SelectAllByIdUserInfoSqlBuilder(), new SelectAllByIdUserInfoPreparedStatementWriter(username), new SelectAllUserInfoResultSetReader());
			UserInfo oldUserInfo = userInfos.get(0);
			String oldPasswordHash = isPasswordChanging(oldPassword, password, passwordConfirm) ? PasswordHandler.generateHash(oldPassword) : oldUserInfo.getPasswordHash();
			UserInfo userInfo = UserInfo.builder()
					.withUsername(username)
					.withFirstName(firstName)
					.withLastName(lastName)
					.withEmail(email)
					.withCityId(Long.parseLong(cityIdAsString))
					.withGenderId(Long.parseLong(genderIdAsString))
					.withPasswordHash(isPasswordChanging(oldPassword, password, passwordConfirm) ? PasswordHandler.generateHash(password) : oldUserInfo.getPasswordHash())
					.withDateOfBirth(DateUtil.convert(dateOfBirthAsString))
					.withPaid(oldUserInfo.getPaid())
					.withShowAllDetails(showAllDetails)
					.withShowMeInSearch(showMeInSearch)
					.build();
			userInfoDao.update(new UpdateUserInfoSqlBuilder(), new UpdateUserInfoPreparedStatementWriter(userInfo, oldPasswordHash));
			userInfoDao.closeConnection();
			request.getSession()
					.setAttribute("loggedInUser", userInfo);
			response.sendRedirect(request.getContextPath() + "/loadEditProfile?saveSuccessful");
		} else {
			StringJoiner invalidFieldJoiner = new StringJoiner("&", "&", "");
			for (String invalidField : invalidFields) {
				invalidFieldJoiner.add(invalidField + "=true");
			}
			response.sendRedirect(request.getContextPath() + "/loadEditProfile?" + previousValues + invalidFieldJoiner);
		}
	}

	private void validate(UserInfoValidator userInfoValidator, String username, String firstName, String lastName, String email, String oldPassword, String password, String passwordConfirm, String cityIdAsString, String dateOfBirthAsString, String genderIdAsString, Set<String> invalidFields) {
		userInfoValidator.validateFirstName(firstName, invalidFields);
		userInfoValidator.validateLastName(lastName, invalidFields);
		if (isPasswordChanging(oldPassword, password, passwordConfirm)) {
			userInfoValidator.validateOldPassword(username, oldPassword, invalidFields);
			userInfoValidator.validatePassword(password, invalidFields);
			userInfoValidator.validatePasswordConfirm(password, passwordConfirm, invalidFields);
		}
		new CityValidator().validateCity(cityIdAsString, invalidFields);
		new GenderValidator().validateGender(genderIdAsString, invalidFields);
		userInfoValidator.validateDateOfBirth(dateOfBirthAsString, invalidFields);
	}

	private boolean isPasswordChanging(String oldPassword, String password, String passwordConfirm) {
		return oldPassword != null && !oldPassword.isBlank() || password != null && !password.isBlank() || passwordConfirm != null && !passwordConfirm.isBlank();
	}

}