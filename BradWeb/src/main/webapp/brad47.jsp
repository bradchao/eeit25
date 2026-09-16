<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.api.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx" var="data"></c:import>
<c:set var="hotels" value="${BradUtil.parseHotels(data) }" />
<sql:setDataSource
	driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/brad"
	user="root"
	password="root"	
	/>	
<sql:update>
	DELETE FROM hotels
</sql:update>
<sql:update>
	ALTER TABLE hotels AUTO_INCREMENT = 1
</sql:update>
<c:catch var="e">
	<c:forEach items="${hotels }" var="hotel">
		<sql:update>
			INSERT INTO hotels (name,addr,tel) VALUES (?,?,?)
			<sql:param>${hotel.name }</sql:param>
			<sql:param>${hotel.addr }</sql:param>
			<sql:param>${hotel.tel }</sql:param>
		</sql:update>
	</c:forEach>
</c:catch>

<c:choose>
	<c:when test="${!empty e }">${e }</c:when>
	<c:otherwise>Finish</c:otherwise>
</c:choose>

