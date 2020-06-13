package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.dao.GenderDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.entity.Gender;
import hu.ak_akademia.atos.db.preparedstatementwriter.DummyPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.gender.SelectAllGenderResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllCitySqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.gender.SelectAllGenderSqlBuilder;

public class LoadRegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDao cityDao = new CityDao();
		cityDao.openConnection();
		List<City> cities = cityDao.read(new SelectAllCitySqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllCityResultSetReader());
		cityDao.closeConnection();

		GenderDao genderDao = new GenderDao();
		genderDao.openConnection();
		List<Gender> genders = genderDao.read(new SelectAllGenderSqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllGenderResultSetReader());
		genderDao.closeConnection();

		request.setAttribute("cities", cities);
		request.setAttribute("genders", genders);
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue()[0]);
		}

		request.getRequestDispatcher("/registration.jsp")
				.forward(request, response);
	}

}