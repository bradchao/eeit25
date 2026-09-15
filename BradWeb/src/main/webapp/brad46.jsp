<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/brad"
	user="root"
	password="root"	
	/>	
<sql:query var="rs">
	SELECT * FROM food
	LIMIT 10
</sql:query>

<table border="1" width="100%"> 
	<c:forEach items="${rs.rows }" var="food">
		<tr>
			<td>${food.id }</td>
			<td>${food.name }</td>
			<td>${food.tel }</td>
		</tr>
	</c:forEach>
</table>



