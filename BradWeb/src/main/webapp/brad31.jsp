<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="org.json.JSONObject"%>
<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	int result = Integer.parseInt(x) + Integer.parseInt(y);
	
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