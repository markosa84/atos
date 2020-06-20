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
import hu.ak_akademia.atos.util.RequestUtil;

public class LoadViewProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.openConnection();
		List<UserInfo> users = userInfoDao.read(new SelectAllByIdUserInfoSqlBuilder(), new SelectAllByIdUserInfoPreparedStatementWriter(username), new SelectAllUserInfoResultSetReader());
		userInfoDao.closeConnection();
		UserInfo user = users.get(0);

		RequestUtil.loadCityMap(request);
		RequestUtil.loadGenderMap(request);
		request.setAttribute("user", user);

		request.getRequestDispatcher("/auth/viewProfile.jsp")
				.forward(request, response);
	}

}