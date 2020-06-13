package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.SearchUserFilterDao;
import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter.SelectAllByUsernameSearchUserFilterPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.searchuserfilter.SelectAllSearchUserFilterResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter.SelectAllByUsernameSearchUserFilterSqlBuilder;

public class LoadSearchUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo loggedInUser = (UserInfo) request.getSession()
				.getAttribute("loggedInUser");

		SearchUserFilterDao searchUserFilterDao = new SearchUserFilterDao();
		searchUserFilterDao.openConnection();
		List<SearchUserFilter> filters = searchUserFilterDao.read(new SelectAllByUsernameSearchUserFilterSqlBuilder(), new SelectAllByUsernameSearchUserFilterPreparedStatementWriter(loggedInUser.getUsername()), new SelectAllSearchUserFilterResultSetReader());
		searchUserFilterDao.closeConnection();

//		if (request.getParameter("saveSuccessful") != null) {
//			request.setAttribute("saveSuccessful", "true");
//		}

		request.setAttribute("filters", filters);
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue()[0]);
		}

		request.getRequestDispatcher("/auth/searchUser.jsp")
				.forward(request, response);
	}

}