package users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListUserServlet
 */
@WebServlet("/showdata")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String queryGetListUser = "SELECT * FROM user";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserServlet() {
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
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		// Link the bootrap
		pw.println("<link\r\n" + "      rel=\"stylesheet\"\r\n"
				+ "      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "      crossorigin=\"anonymous\"\r\n" + "    />");

		// load the JDBC driver
		try {
			// Generate the connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgmt?useSSL=false", "root",
					"");
			pw.println("<marquee><h2 class=\"text-primary\">List Users</h2></marquee>");

			PreparedStatement ps = con.prepareStatement(queryGetListUser);

			// ResultSet
			ResultSet rs = ps.executeQuery();

			pw.println("<div class='container' style='margin-top:50px;'>");

			pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");

			pw.println("<table class='table table-hover table-striped'>");
			pw.println("<thead>");
			pw.println("<tr>");
			pw.println("<th>ID</th>");
			pw.println("<th>Name</th>");
			pw.println("<th>Email</th>");
			pw.println("<th>Mobile</th>");
			pw.println("<th>DOB</th>");
			pw.println("<th>Gender</th>");
			pw.println("<th>City</th>");
			pw.println("<th></th>");
			pw.println("</tr>");
			pw.println("</thead>");
			pw.println("<tbody>");
			while (rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getInt(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getString(4) + "</td>");
				pw.println("<td>" + rs.getString(5) + "</td>");
				pw.println("<td>" + rs.getString(7) + "</td>");
				pw.println("<td>" + rs.getString(6) + "</td>");
				pw.println("<td><a href='editurl?id=" + rs.getInt(1)
						+ "'><button class='btn btn-outline-warning'>Update</button></a>&nbsp;<a href='deleteurl?id="
						+ rs.getInt(1) + "'><button class='btn btn-outline-danger'>Delete</button></a></td>");
				pw.println("</tr>");

			}
			pw.println("</tbody>");
			pw.println("</table>");

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
//		doGet(request, response);
	}

}
