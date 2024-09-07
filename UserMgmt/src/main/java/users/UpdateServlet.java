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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/editurl")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String queryGetUser = "SELECT * FROM user WHERE id=?";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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

		// Get Value
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String[] citys = { "HoChiMinh", "HaNoi", "SocTrang", "VungTau", "NhaTrang", "BinhDuong", "BacLieu", "CaMau",
				"BinhPhuoc", "DongNai", "TraVinh", "CanTho", "PhuYen", "PhanThiet", "SaPa", "LaoCai", "Hue", "BacNinh",
				"HaiPhong", "BacCan", "MongCai", "LangSon", "BinhDinh", "DaNang", "NgheAn", "HaTinh", "VinhPhuc",
				"QuangNam", "QuangNgai", "QuangBinh", "LamDong", "TayNguyen", "ThaiNguyen", "ThaiBinh" };

		// load the JDBC driver
		try {
			// Generate the connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermgmt?useSSL=false", "root",
					"");

			PreparedStatement ps = con.prepareStatement(queryGetUser);
			ps.setInt(1, id);

			// ResultSet
			ResultSet rs = ps.executeQuery();
			rs.next();
			String check = rs.getString(7).equals("male") ? "checked" : "";
			String checkF = rs.getString(7).equals("female") ? "checked" : "";
			System.out.println();

			pw.println("<div class='container' style='margin-top:50px;'>");

			pw.println("<a href='home.html'><button class='btn btn-outline-success'>Home</button></a>");

			pw.println("<form action='edit?id=" + rs.getInt(1) + "' method='post' class='form card' id='frm'>");
			pw.println("<table class='table table-hover table-striped'>");
			pw.println("<tr>");
			pw.println("<td>Name</td>");
			pw.println("<td><input type='text' name='userName' required value=" + rs.getString(2) + " /></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Email</td>");
			pw.println("<td><input type='email' name='email' required value=" + rs.getString(3) + " /></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Mobile</td>");
			pw.println("<td><input type='text' name='mobile' required value=" + rs.getString(4) + " /></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>DOB</td>");
			pw.println("<td><input type='date' name='dob' required value=" + rs.getString(5) + " /></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Gender</td>");
			pw.println("<td><input type='radio' name='gender' value='male' " + check
					+ " /> Male &nbsp; <input type='radio' name='gender' value='female' " + checkF + " /> Female</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>City</td>");
			pw.println("<td><select name='city'>");
			for (String cityUser : citys) {
				String cityTitle = cityUser.replaceAll("([A-Z])", " $1").trim();
				if (rs.getString(6) != null && rs.getString(6).equals(cityUser)) {
					pw.println("<option value='" + cityUser + "' selected>" + cityTitle + "</option>");
				} else {
					pw.println("<option value='" + cityUser + "'>" + cityTitle + "</option>");
				}

			}
			pw.println("</select></td>");
			pw.println("</tr>");

			pw.println("<tr>");
			pw.println("<td><button type=\"submit\" class=\"btn btn-outline-success\">Update</button></td>");
			pw.println("<td><button type=\"reset\" class=\"btn btn-outline-danger\"><a href='showdata'>Cancel</a></button></td>");
			pw.println("</tr>");

			pw.println("</table>");
			pw.println("</form>");
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
