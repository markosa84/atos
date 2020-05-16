package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.CityDao;
import hu.ak_akademia.atos.db.entity.City;
import hu.ak_akademia.atos.db.preparedstatementwriter.DummyPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.city.SelectAllCityResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.city.SelectAllCitySqlBuilder;

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDao dao = new CityDao();
		dao.openConnection();
		List<City> cities = dao.read(new SelectAllCitySqlBuilder(), new DummyPreparedStatementWriter(), new SelectAllCityResultSetReader());
		dao.closeConnection();
		request.setAttribute("cities", cities);
		request.getRequestDispatcher("/registration.jsp")
				.forward(request, response);
	}

}