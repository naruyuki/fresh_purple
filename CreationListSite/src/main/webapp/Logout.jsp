<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="logout-container">
	<h2>ログアウト</h2>
		<p>このページではログアウト処理を行います。</p>
		
		<form action="logout" method="post">
			<button type="submit">ログアウト</button><br>
			<a href="TopPage.jsp">キャンセル</a>
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

.logout-container {
	background-color: #fff;
	padding: 2em;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	text-align: center;
	max-width: 400px;
	width: 100%;
}

.logout-container h2 {
	margin-bottom: 1.5em;
	color: #333;
}

.logout-container button {
	padding: 0.7em 1.5em;
	color: #fff;
	background-color: #FF4B4B;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 1em;
}

.logout-container button:hover {
	background-color: #CC0000;
}

.logout-container a {
	display: block;
	margin-top: 1em;
	color: #007BFF;
	text-decoration: none;
}

.logout-container a:hover {
	text-decoration: underline;
}
</style>
</html>