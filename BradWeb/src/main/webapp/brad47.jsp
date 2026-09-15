<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.api.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx" var="data"></c:import>
${data}
<c:set var="hotels" value="${BradUtil.parseHotels(data) }" />