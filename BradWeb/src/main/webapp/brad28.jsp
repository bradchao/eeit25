<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="brad29.jsp" %>
<%
	String name = request.getParameter("name");
	char c2 = name.charAt(1);
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		<div>Hello, World</div>
	</body>
</html>