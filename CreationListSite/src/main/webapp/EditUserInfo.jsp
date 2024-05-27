<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★会員情報変更★</title>
</head>
<body>

<form action="edituserinfo" method="post">

	<p>新しい名前を入力してください。</p>
	<input type="text" name="name">
	<input type="hidden" name="user_id" value=<%= session.getAttribute("user_id")%>>
	<input type="submit" value="変更">
	
</form>




</form>

</body>
</html>