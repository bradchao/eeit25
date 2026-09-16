<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.api.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<%
	/*
	SELECT o.OrderID, o.OrderDate, e.LastName, c.CompanyName, c.ContactName, p.ProductName, od.UnitPrice, od.Quantity
	FROM `orders` o
	JOIN customers c ON o.CustomerID = c.CustomerID
	JOIN employees e ON o.EmployeeID = e.EmployeeID
	JOIN orderdetails od ON o.OrderID = od.OrderID
	JOIN products p ON od.ProductID = p.ProductID
	WHERE o.OrderID = ?
	*/
%>
<c:catch var="err">
	<sql:query var="rs" dataSource="north">
		SELECT o.OrderID, o.OrderDate, e.LastName, c.CompanyName, c.ContactName, p.ProductName, od.UnitPrice, od.Quantity
		FROM `orders` o
		JOIN customers c ON o.CustomerID = c.CustomerID
		JOIN employees e ON o.EmployeeID = e.EmployeeID
		JOIN orderdetails od ON o.OrderID = od.OrderID
		JOIN products p ON od.ProductID = p.ProductID
		WHERE o.OrderID = ?
		<sql:param>${param.orderId }</sql:param>			
	</sql:query>
	
	${BradUtil.order2JSON(rs.rows) }
	
</c:catch>
${err }