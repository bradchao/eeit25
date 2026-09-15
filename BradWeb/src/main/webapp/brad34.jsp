<%@page import="tw.brad.api.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Bike b1 = new Bike();
	pageContext.setAttribute("bike", b1);
	b1.upSpeed().upSpeed().upSpeed().upSpeed();

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		Bike: ${bike}<br />
		PI: ${Math.PI}<br />
		Random: ${Math.random() }<br />
		Name: ${param.name }<br />
	</body>
</html>