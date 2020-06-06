package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.SelectAllByIdAndPasswordUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.SelectAllByIdAndPasswordUserInfoSqlBuilder;
import hu.ak_akademia.atos.util.PasswordHandler;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordHash = PasswordHandler.generateHash(password);

		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.openConnection();
		List<UserInfo> userInfos = userInfoDao.read(new SelectAllByIdAndPasswordUserInfoSqlBuilder(), new SelectAllByIdAndPasswordUserInfoPreparedStatementWriter(username, passwordHash), new SelectAllUserInfoResultSetReader());
		userInfoDao.closeConnection();

		if (userInfos.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/login.jsp?invalidUsernameOrPassword=true");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", userInfos.get(0));
			response.sendRedirect(request.getContextPath() + "/auth/home.jsp");
		}
	}

}