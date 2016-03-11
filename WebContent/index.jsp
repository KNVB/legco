<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="hk.legco.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	out.println(getServletContext().getRealPath("/WEB-INF")+"<br>");
	DbOp dbo=new DbOp("D:\\SITO3\\workspace\\legco\\legco.db");
	Vector<String>  partyNameList=dbo.getPartyNameList();
	for (Enumeration<String>partyNameLists=partyNameList.elements();partyNameLists.hasMoreElements();)
	{
		out.println(partyNameLists.nextElement()+"<br>");
	}
	dbo.close();
%>
</body>
</html>