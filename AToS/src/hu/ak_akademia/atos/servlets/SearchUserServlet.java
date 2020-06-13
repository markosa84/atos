package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.SelectAllByIdUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.SelectAllByIdUserInfoSqlBuilder;

public class SearchUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");

		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.openConnection();
		List<UserInfo> userBalances = userInfoDao.read(new SelectAllByIdUserInfoSqlBuilder(), new SelectAllByIdUserInfoPreparedStatementWriter(username), new SelectAllUserInfoResultSetReader());
		userInfoDao.closeConnection();

		if (userBalances.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/auth/searchUser.jsp?invalidUsername=true");
		} else {
			UserInfo searchedUser = (UserInfo) request.getSession()
					.getAttribute("searchedUser");
			request.setAttribute("username", searchedUser.getUserName());
			response.sendRedirect(request.getContextPath() + "/auth/searchUser.jsp");
		}
	}
}
