<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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

	<h2>Connect DB</h2>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/usermgmt" user="root"
		password="Admin1234567@" />
	<sql:query var="rs" dataSource="${db}">SELECT * FROM user </sql:query>
	<c:forEach items="${rs.rows}" var="item">
		<c:out value="${item.id}"></c:out> : <c:out value="${item.name}"></c:out><br />
	</c:forEach>
</body>
</html>