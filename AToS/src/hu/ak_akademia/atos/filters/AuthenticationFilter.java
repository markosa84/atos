package hu.ak_akademia.atos.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean isLoggedIn = (session != null && session.getAttribute("loggedInUser") != null);
		String loginURI = httpRequest.getContextPath() + "/login";
		boolean isLoginRequest = httpRequest.getRequestURI()
				.equals(loginURI);
		boolean isLoginPage = httpRequest.getRequestURI()
				.endsWith("login.jsp");
		boolean isImage = httpRequest.getRequestURI()
				.contains("/images/");
		boolean isRegistration = httpRequest.getRequestURI()
				.endsWith("registration.jsp");

		if (isLoggedIn && (isLoginRequest || isLoginPage)) {
			// the admin is already logged in and he's trying to login again
			// then forwards to the admin's homepage
			RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/home.jsp");
			dispatcher.forward(request, response);
		} else if (isLoggedIn || isLoginRequest || isImage) {
			// continues the filter chain
			// allows the request to reach the destination
			chain.doFilter(request, response);
		} else if (!isRegistration) {
			chain.doFilter(request, response);
		} else {
			// the admin is not logged in, so authentication is required
			// forwards to the Login page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}