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
		<c:set var="names" value="${['Brad','Andy','Tony','Eric','Mark'] }"></c:set>
		names[0] = ${names[0] }<br />
		names[2] = ${names[2] }<br />
		<hr />
		<table border="1" width="100%">
			<tr>
				<th>Index</th>
				<th>Name</th>
				<th>Count</th>
				<th>First</th>
				<th>Last</th>
			</tr>
			<c:forEach items="${names }" var="name" varStatus="status">
				<tr>
					<td>${status.index }</td>
					<td>${name }</td>
					<td>${status.count }</td>
					<td>${status.first }</td>
					<td>${status.last }</td>
				</tr>
			</c:forEach>
		</table>
	
	</body>
</html>