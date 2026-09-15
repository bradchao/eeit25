<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.getLocale().get
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		Method: ${pageContext.request.method }<br />
		Locale: ${pageContext.request.locale }<br />	
		Country: ${pageContext.request.locale.displayCountry }<br />	
		Country: ${pageContext.request.locale.country }<br />	
	</body>
</html>