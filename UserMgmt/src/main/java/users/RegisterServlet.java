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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String query = "INSERT INTO user(name, email, mobile, dob, gender, city) VALUES(?, ?, ?, ?, ?, ?)";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		// Link the bootrap
		pw.println("<link\r\n"
				+ "      rel=\"stylesheet\"\r\n"
				+ "      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "      crossorigin=\"anonymous\"\r\n"
				+ "    />");
		
		// Get Value
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");

		// load the JDBC driver
		try {
			// Generate the connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgmt?useSSL=false", "root",
					"");
			PreparedStatement ps = con.prepareStatement(query);
			// Set the values
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, dob);
			ps.setString(5, gender);
			ps.setString(6, city);

			// execute the query
			int count = ps.executeUpdate();

			pw.println("<div class='card' style='margin: auto; width:300px; margin-top:100px'>");
			if (count == 1) {
				pw.println("<h2 class='bg-success text-light text-center'>Record Registered Successfully</h2>");
			} else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Registered</h2>");
			}

			pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");
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

}
