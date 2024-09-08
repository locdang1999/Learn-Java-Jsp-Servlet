package users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteurl")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String queryDeleteUser = "DELETE FROM user WHERE id=?";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		// Link the bootrap
		pw.println("<link\r\n" + "      rel=\"stylesheet\"\r\n"
				+ "      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "      crossorigin=\"anonymous\"\r\n" + "    />");

		// Get the Values
		int id = Integer.parseInt(request.getParameter("id"));

		// load the JDBC driver
		try {
			// Generate the connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgmt?useSSL=false", "root",
					"");
			PreparedStatement ps = con.prepareStatement(queryDeleteUser);
			// Set the values
			ps.setInt(1, id);

			// execute the query
			int count = ps.executeUpdate();

			pw.println("<div class='card' style='margin: auto; width:300px; margin-top:100px'>");
			if (count == 1) {
				pw.println("<h2 class='bg-success text-light text-center'>Record Deleted Successfully</h2>");
			} else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Deleted</h2>");
			}
			pw.println("<div class='btn-toolbar' role='toolbar' aria-label='Toolbar with button groups'>");
			pw.println("<div class=\"btn-group mr-2\" role=\"group\" aria-label=\"First group\">");
			pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
			pw.println("</div>");
			pw.println(" <div class=\"btn-group mr-2\" role=\"group\" aria-label=\"Second group\">");
			pw.println("<a href='showdata'><button class='btn btn-outline-success'>Show Users</button></a>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("</div>");
			pw.close();
		} catch (SQLException e) {
			// TODO: handle exception
			pw.println("<h2 class='bg-danger text-light text-center'>" + e.getMessage() + "</h2>");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
