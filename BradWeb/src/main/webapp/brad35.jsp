<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.api.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<form action='brad35.jsp'>
			<input type='number' name='x' value="${param.x }" />
			+
			<input type='number' name='y' value="${param.y }" />
			<input type='submit' value='=' />
			<span>${BradUtil.calc(param.x, param.y) }</span>
		</form>	
	</body>
</html>