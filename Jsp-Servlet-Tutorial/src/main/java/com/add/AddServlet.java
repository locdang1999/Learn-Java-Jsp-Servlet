package com.add;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int a = Integer.parseInt(request.getParameter("num1"));
		int b = Integer.parseInt(request.getParameter("num2"));

		int sum = a + b;
		sum = sum * sum;

//		System.out.println(sum);
//		PrintWriter out = response.getWriter();
//		out.println("Result is: " + sum);
		
		request.setAttribute("sum", sum);
		
		RequestDispatcher rd = request.getRequestDispatcher("sq");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		int a = Integer.parseInt(request.getParameter("num1"));
//		int b = Integer.parseInt(request.getParameter("num2"));
//		
//		int sum = a + b;
//		sum = sum*sum;
//		
//		System.out.println(sum);
//		PrintWriter out = response.getWriter();
//		out.println("Result is: " + sum);
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		int a = Integer.parseInt(request.getParameter("num1"));
////		int b = Integer.parseInt(request.getParameter("num2"));
////		
////		int sum = a + b;
////		
////		System.out.println(sum);
////		PrintWriter out = response.getWriter();
////		out.println("Result is: " + sum);
//	}

}
