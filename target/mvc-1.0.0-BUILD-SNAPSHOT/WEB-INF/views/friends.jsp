<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul{
list-style-type:none;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
	<ul>
		<c:forEach var="userList" items="${users}">
			<li>Username: <c:out value="${userList.username}"/> </li>
			<li>Password: <c:out value="${userList.password}"/> </li>
			<li>Email: <c:out value="${userList.email}"/> </li>
			<br/>
		</c:forEach>
	</ul>
</body>
</html>