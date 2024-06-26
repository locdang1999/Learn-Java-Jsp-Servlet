<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Profile <br/>
	<%
	String url = "jdbc:mysql://localhost:3306/usermgmt";
	String username = "root";
	String password = "";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, username, password);
	
	String sql = "SELECT * FROM user LIMIT 1";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	rs.next();
	
	
	%>
	Rollno: <%=rs.getInt(1) %> <br/>
	Name: <%=rs.getString(2) %> <br/>
	Gmail: <%=rs.getString(3) %> <br/>
	Phone: <%=rs.getString(4) %>
</body>
</html>