<!--
 -- JSP Tags
 -- Declaration
 -- Directive
 -- Scriptlet
 -- Expression
 -->

<!-- Declaration -->
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.Statement, java.util.Random" errorPage="error.jsp"%> <!-- errorPage: change error page when main page error  -->
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<%
	int coef = 3;
	%>
	<h1>Hello World!</h1>
	<%
	out.println(5 + 7);
	%>
	My Fay Number is:<%=coef%>
	My Fay Number1 is:
	<%
	out.println(coef);
	%>
	<%
	request.getParameter("name");
	%>
	<%
	// Implicit Object in JSP
	pageContext.setAttribute("name", "Roger", PageContext.SESSION_SCOPE);
	config.getInitParameter("name");
	%>
	<br/>
	<%
	// Exception Handling in JSP
	try {
		int k = 9 / 0;

	} catch (Exception e) {
		out.println("Error" + e.getMessage());
	}
	%>
	
	<%
	int k = 9 / 0;
	%>
</body>
</html>