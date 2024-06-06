package com.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		int sum = (int) request.getAttribute("sum");
//		int sum = Integer.parseInt(request.getParameter("sum"));
//		HttpSession session = request.getSession();
//		int sum = (int) session.getAttribute("sum");
		int sum = 0;
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("sum")) {
				sum = Integer.parseInt(cookie.getValue());
			}
		}

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body style='background-color:red'>");
		out.print("Hello Sq " + sum);
		out.println("</body>");
		out.println("</html>");

		System.out.println("sq called.");
	}
}
