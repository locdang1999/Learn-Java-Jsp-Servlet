package com.dev.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String phone = request.getParameter("contact");
		String rePassword = request.getParameter("re_pass");

//				PrintWriter out = response.getWriter();
//				out.print(username);
//				out.print(email);
//				out.print(password);
//				out.print(phone);

		RequestDispatcher dispatcher = null;
		Connection con = null;

		if (username == null || username.equals("")) {
			request.setAttribute("status", "InvalidUsername");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (email == null || email.equals("")) {
			request.setAttribute("status", "InvalidEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (password == null || password.equals("")) {
			request.setAttribute("status", "InvalidPassword");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (rePassword == null || rePassword.equals("")) {
			request.setAttribute("status", "InvalidRePassword");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (!password.equals(rePassword)) {
			request.setAttribute("status", "MatchPassword");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (phone == null || phone.equals("")) {
			request.setAttribute("status", "InvalidContact");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		} else if (phone.length() < 9 || phone.length() > 12) {
			request.setAttribute("status", "InvalidContactLength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beststore?useSSL=false", "root", "");
			PreparedStatement pst = con
					.prepareStatement("INSERT INTO users(username ,password ,email ,phone ) VALUES (? ,? ,? ,?)");
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, phone);

			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");

			if (rowCount > 0) {
				request.setAttribute("status", "success");
//						dispatcher = request.getRequestDispatcher("login.jsp");

			} else {
				request.setAttribute("status", "failed");
//						dispatcher = request.getRequestDispatcher("registration.jsp");
			}

			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
