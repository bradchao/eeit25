<%@page import="org.json.JSONObject"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	BufferedReader reader = request.getReader();
	String line; StringBuffer sb = new StringBuffer();
	while ( (line = reader.readLine()) != null){
		sb.append(line);
	}
	System.out.println(sb);
	*/
	
	InputStream in = request.getInputStream();
	byte[] all = in.readAllBytes();
	String json = new String(all, StandardCharsets.UTF_8);
	
	JSONObject root = new JSONObject(json);
	String op = root.getString("op");
	JSONObject params = root.getJSONObject("params");
	String x = params.getString("x");
	String y = params.getString("y");
	
	System.out.printf("%s : %s : %s\n", x, y, op);
	
	
	
%>