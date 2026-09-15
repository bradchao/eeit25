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
<sql:update var="n">
	INSERT INTO cust
		(cname,tel,birthday)
	VALUES
		('Eric','1234567','1999-01-02')
</sql:update>
