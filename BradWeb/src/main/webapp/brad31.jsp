<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="org.json.JSONObject"%>
<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String op = request.getParameter("op");
	StringBuffer result = new StringBuffer();
	switch(op){
		case "1": result.append(Integer.parseInt(x) + Integer.parseInt(y));break;
		case "2": result.append(Integer.parseInt(x) - Integer.parseInt(y));break;
		case "3": result.append(Integer.parseInt(x) * Integer.parseInt(y));break;
		case "4": 
			result.append(Integer.parseInt(x) / Integer.parseInt(y))
					.append(" ... ")
					.append(Integer.parseInt(x) % Integer.parseInt(y));
			break;
	}
	//out.print(result);
	/*
		{
			result: 13
		}
	*/
	JSONObject obj = new JSONObject();
	obj.put("result", result);
	out.print(obj);
	
%>