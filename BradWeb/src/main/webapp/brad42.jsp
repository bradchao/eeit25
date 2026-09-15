<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		<c:set var="x" value="10"></c:set>
		x = ${x }<br />
		<c:set var="x" value="3" scope="request"></c:set>
		x = ${requestScope.x }<br />
		<c:set var="y">100</c:set>
		y = ${y }<hr />
		<span>Hello, <span>
		<c:out value="${param.name }" default="World"></c:out>
		
	</body>
</html>