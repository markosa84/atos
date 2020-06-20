package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.MessageDao;
import hu.ak_akademia.atos.db.entity.Message;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.message.SelectAllMessagesBetweenUsersPreparedStatementWriter;
import hu.ak_akademia.atos.db.resultsetreader.message.SelectAllMessageResultSetReader;
import hu.ak_akademia.atos.db.sqlbuilder.message.SelectAllMessagesBetweenUsersSqlBuilder;

public class LoadSendMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameFrom = ((UserInfo) request.getSession()
				.getAttribute("loggedInUser")).getUsername();
		String usernameTo = request.getParameter("username");
		if (usernameTo == null) {
			usernameTo = (String) request.getAttribute("username");
		}

		MessageDao messageDao = new MessageDao();
		messageDao.openConnection();
		List<Message> messages = messageDao.read(new SelectAllMessagesBetweenUsersSqlBuilder(), new SelectAllMessagesBetweenUsersPreparedStatementWriter(usernameFrom, usernameTo), new SelectAllMessageResultSetReader());
		messageDao.closeConnection();

		request.setAttribute("username", usernameTo);
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("/auth/sendMessage.jsp")
				.forward(request, response);
	}

}