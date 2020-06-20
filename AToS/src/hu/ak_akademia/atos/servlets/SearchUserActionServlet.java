package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.SearchUserFilterDao;
import hu.ak_akademia.atos.db.dao.UserInfoDao;
import hu.ak_akademia.atos.db.entity.SearchUserFilter;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter.DeleteByIdSearchUserFilterPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.searchuserfilter.SelectAllByIdSearchUserFilterPreparedStatementWriter;
import hu.ak_akademia.atos.db.preparedstatementwriter.userinfo.DynamicUserInfoPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.searchuserfilter.SelectAllSearchUserFilterResultSetReader;
import hu.ak_akademia.atos.db.resultsetreader.userinfo.SelectAllUserInfoResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter.DeleteByIdSearchUserFilterSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.searchuserfilter.SelectAllByIdSearchUserFilterSqlBuilder;
import hu.ak_akademia.atos.db.sqlbuilder.userinfo.DynamicUserInfoSqlBuilder;
import hu.ak_akademia.atos.util.RequestUtil;

public class SearchUserActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		List<String> parameters = parameterMap.entrySet()
				.stream()
				.map(Entry::getKey)
				.filter(key -> key.startsWith("delete") || key.startsWith("execute"))
				.collect(Collectors.toList());
		String actionString = parameters.get(0);
		// delete_7
		// execute_7
		String[] elements = actionString.split("_");
		String action = elements[0];
		String filterIdAsString = elements[1];
		long filterId = Long.parseLong(filterIdAsString);

		SearchUserFilterDao searchUserFilterDao = new SearchUserFilterDao();
		searchUserFilterDao.openConnection();
		if ("delete".equals(action)) {
			searchUserFilterDao.delete(new DeleteByIdSearchUserFilterSqlBuilder(), new DeleteByIdSearchUserFilterPreparedStatementWriter(SearchUserFilter.builder()
					.withSearchUserFilterId(filterId)
					.build()));
			response.sendRedirect(request.getContextPath() + "/loadSearchUser?deleteSuccessful=true");
		} else if ("execute".equals(action)) {
			List<SearchUserFilter> searchUserFilters = searchUserFilterDao.read(new SelectAllByIdSearchUserFilterSqlBuilder(), new SelectAllByIdSearchUserFilterPreparedStatementWriter(filterId), new SelectAllSearchUserFilterResultSetReader());
			if (searchUserFilters.isEmpty()) {
				response.sendRedirect(request.getContextPath() + "/loadSearchUser");
			} else {
				SearchUserFilter searchUserFilter = searchUserFilters.get(0);

				UserInfoDao userInfoDao = new UserInfoDao();
				userInfoDao.openConnection();
				List<UserInfo> userInfos = userInfoDao.read(new DynamicUserInfoSqlBuilder(searchUserFilter), new DynamicUserInfoPreparedStatementWriter(searchUserFilter), new SelectAllUserInfoResultSetReader());
				userInfoDao.closeConnection();
				request.setAttribute("userInfos", userInfos);

				RequestUtil.loadGenderMap(request);

				request.getRequestDispatcher("/auth/searchUserResults.jsp")
						.forward(request, response);
			}
		}
		searchUserFilterDao.closeConnection();
	}

}