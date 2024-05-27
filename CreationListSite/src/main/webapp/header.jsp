<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ヘッダー</title>
</head>
<body>
	<h1>
		<a href="TopPage.jsp">創作図書館</a>
	</h1>
</body>
<style>
@import url('https://fonts.googleapis.com/css?family=Noto+Serif+JP'); 
body {
	font-family: 'Helvetica Neue', Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background: linear-gradient(135deg, #f0f0f0, #c0c0c0);
}

h1 {
	position: absolute;
	top: 20px;
	left: 50%;
	transform: translateX(-50%);
	font-size: 2.5em;
	color: #333;
	background: rgba(255, 255, 255, 0.8);
	padding: 10px 20px;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	font-family: 'Noto Serif JP', sans-serif;
}

a {
	color: inherit;
	text-decoration: none;
	transition: color 0.3s, text-shadow 0.3s;
}

a:hover {
	color: #0073e6;
	text-shadow: 0 0 5px rgba(0, 115, 230, 0.5);
}
</style>
</html>

