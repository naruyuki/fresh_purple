<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★ログイン★</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="login-container">
		<h2>ログイン</h2>
		<form action="login" method="post">
			<input type="text" name="user_id" placeholder="ユーザー名" required>
			<input type="password" name="password" placeholder="パスワード" required>

			<%
			if (session.getAttribute("error") != null) {
			%>

			<p style="color: red"><%=session.getAttribute("error")%></p>

			<%
			}
			%>

			<button type="submit">ログイン</button>
			<a href="Registration.jsp">新規会員登録</a> <a href="TopPage.jsp">戻る</a>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.login-container {
	background-color: #fff;
	padding: 2em;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	text-align: center;
	max-width: 400px;
	width: 100%;
}

.login-container h2 {
	margin-bottom: 1.5em;
	color: #333;
}

.login-container input[type="text"], .login-container input[type="password"]
	{
	width: calc(100% - 2em);
	padding: 0.5em;
	margin-bottom: 1em;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 1em;
}

.login-container button {
	padding: 0.7em 1.5em;
	color: #fff;
	background-color: #007BFF;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 1em;
}

.login-container button:hover {
	background-color: #0056b3;
}

.login-container a {
	display: block;
	margin-top: 1em;
	color: #007BFF;
	text-decoration: none;
}

.login-container a:hover {
	text-decoration: underline;
}
</style>
</html>