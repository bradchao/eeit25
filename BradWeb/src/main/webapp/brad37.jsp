<%@page import="tw.brad.api.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Student s1 = new Student("Brad");
	s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed();
	pageContext.setAttribute("student", s1);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		${student.name }<br />
		${student.bike.speed }<br />
	</body>
</html>