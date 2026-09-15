<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name1 = "Brad1";
	//pageContext.setAttribute("name", name1);
	
	String name2 = "Brad2";
	request.setAttribute("name", name2);

	String name3 = "Brad3";
	session.setAttribute("name", name3);

	String name4 = "Brad4";
	application.setAttribute("name", name4);

%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Brad Big Company</title>
	</head>
	<body>
		Name: ${name }<br />
		Name(page): ${pageScope.name }<br />
		Name(request): ${requestScope.name }<br />
		Name(session): ${sessionScope.name }<br />
		Name(application): ${applicationScope.name }<br />
		<%
			session.invalidate();
		%>
	</body>
</html>