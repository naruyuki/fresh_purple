<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★登録完了★</title>
</head>
<body>
<%@ include file="header.jsp"%>
 <h2>登録完了</h2>
 <%String message=""; %>
 <%message= (String)session.getAttribute("message"); %>
 <p><%=message %></p>
</body>
</html>