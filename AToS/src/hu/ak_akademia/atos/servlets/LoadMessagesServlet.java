package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.StringDao;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.message.SelectChatPartnersForUsernamePreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.message.SelectChatPartnersForUsernameResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.message.SelectChatPartnersForUsernameSqlBuilder;

public class LoadMessagesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loggedInUsername = ((UserInfo) request.getSession()
				.getAttribute("loggedInUser")).getUsername();

		StringDao stringDao = new StringDao();
		stringDao.openConnection();
		List<String> usernames = stringDao.read(new SelectChatPartnersForUsernameSqlBuilder(), new SelectChatPartnersForUsernamePreparedStatementWriter(loggedInUsername), new SelectChatPartnersForUsernameResultSetReader());
		stringDao.closeConnection();

		request.setAttribute("usernames", usernames);
		request.getRequestDispatcher("/auth/messages.jsp")
				.forward(request, response);
	}

}