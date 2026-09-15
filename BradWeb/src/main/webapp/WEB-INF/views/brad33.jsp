<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		<h1>${title}, ${name}</h1>
		<h1><%= request.getAttribute("title") %>, <%= request.getAttribute("name") %></h1>
		<div>目前時間: ${time}</div>
		<a href="${pageContext.request.contextPath }/brad33.html">Home</a>
		<a href="brad33.html">Home</a>
	</body>
</html>