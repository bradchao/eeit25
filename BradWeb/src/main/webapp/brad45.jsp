<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<sql:update var="n" dataSource="brad">
	INSERT INTO cust
		(cname,tel,birthday)
	VALUES
		('Kevin','1234567','1999-01-02')
</sql:update>
