<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getAttribute("label").toString();
	out.println(name);
	%>
	<br /> ${label}
	<br />
	<c:out value="Hello World"></c:out>
	<br />
	<c:out value="${label}" />
	<%-- <c:import url="https://www.google.com/" /> --%>
	<br /> ${student.name}
	<br />
	<c:forEach items="${studentLst}" var="st">
	${st.name} <br />
	</c:forEach>
</body>
</html>