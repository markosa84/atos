package hu.ak_akademia.atos.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.atos.db.dao.MessageDao;
import hu.ak_akademia.atos.db.entity.Message;
import hu.ak_akademia.atos.db.entity.UserInfo;
import hu.ak_akademia.atos.db.preparedstatementwriter.message.CreateMessagePreparedStatementWriter;
import hu.ak_akademia.atos.db.sqlbuilder.message.CreateMessageSqlBuilder;

public class SaveMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernameFrom = ((UserInfo) request.getSession()
				.getAttribute("loggedInUser")).getUsername();
		String usernameTo = request.getParameter("usernameTo");
		String messageText = request.getParameter("message");

		Message message = Message.builder()
				.withUsernameFrom(usernameFrom)
				.withUsernameTo(usernameTo)
				.withMessageText(messageText)
				.withDateAndTime(LocalDateTime.now())
				.build();

		MessageDao messageDao = new MessageDao();
		messageDao.openConnection();
		messageDao.create(new CreateMessageSqlBuilder(), new CreateMessagePreparedStatementWriter(message));
		messageDao.closeConnection();

		request.setAttribute("username", usernameTo);
		request.getRequestDispatcher("/loadSendMessage")
				.forward(request, response);
	}

}