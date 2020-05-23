package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;

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
import hu.ak_akademia.atos.db.preparedstatementwriter.DummyPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.gender.SelectAllGenderResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.SelectAllGenderSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.SelectAllUserInfoSqlBuilder;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserInfoDao userInfoDao = new UserInfoDao();
		userInfoDao.openConnection();
		List<UserInfo> users = userInfoDao.read(new SelectAllUserInfoSqlBuilder(), new DummyPreparedStatementWriter(),
				new SelectAllUserInfoResultSetReader());
		userInfoDao.closeConnection();

		request.setAttribute("users", users);

		request.getRequestDispatcher("/editProfile.jsp")
				.forward(request, response);
	}

}