<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: yellow">
	<%
	int a = Integer.parseInt(request.getParameter("num1"));
	int b = Integer.parseInt(request.getParameter("num2"));

	int sum = a + b;
	sum = sum * sum;
	out.println("Output: " + sum);
	%>
</body>
</html>