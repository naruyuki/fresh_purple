<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>創作編集ページ</title>
</head>
<body>
	<h2>
		<a href="Toppage.jsp">創作図書館</a>
	</h2>
	<nav id="menubar" class="nav-fix-pos">
		<ul>
			<li><a href="">Back<span>前に戻る</span></a></li>
			<li><a href="Mypage.jsp">Mypage<span>マイページ</span></a></li>
		</ul>
	</nav>
	<div class="button-container">
	
	<button class="btn save-btn">変更を完了する</button>
	
	</div>
	
	<div class="button-container2">
	
	<button class="btn post-btn">作品の削除</button></div>
	
</body>
<style>
@import url('https://fonts.googleapis.com/css?family=Noto+Serif+JP');

#menubar {
	overflow: hidden;
	position: relative;
	z-index: 1;
	background: rgba(255, 255, 255, 0.95);
	width: 100%;
	top: 120px;
	background-color: #3CB371;
}

#menubar ul {
	padding: 0;
	margin: 0;
	list-style: none;
	display: flex;
	justify-content: space-between;
}

#menubar ul li {
	flex: 1;
	text-align: center;
}

#menubar ul li a {
	text-decoration: none;
	display: block;
	height: 80px;
	padding-top: 20px;
	border-left: 1px solid #ccc;
	font-size: 20px;
	color: white;
}

#menubar ul li:first-child a {
	border-left: none;
}

#menubar li a span {
	display: block;
	font-size: 60%;
}

#menubar li a:hover, #menubar li.current a {
	background: #28F086;
	color: #fff;
}

h2 {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	font-size: 2.5em;
	color: #333;
	background: rgba(255, 255, 255, 0.8);
	font-family: 'Noto Serif JP', sans-serif;
}

a {
	color: inherit;
	text-decoration: none;
	transition: color 0.3s, text-shadow 0.3s;
	text-align: center;
}

a:hover {
	color: #28F086;
	text-shadow: 0 0 5px rgba(0, 115, 230, 0.5);
}
.btn {
    margin-top: auto;
    justify-content:center;
    text-align: center;
}
.button-container {
    position: fixed;
    bottom: 20px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    gap: 20px;
}

button.btn {
    padding: 10px 30px;
    font-size: 16px;
    cursor: pointer;
    border: none;
    border-radius: 5px;
    transition: background-color 0.3s, box-shadow 0.3s;
}

button.btn.save-btn {
    background-color: #28F086;
    color: white;
}

button.btn.save-btn:hover {
    background-color: #28F086;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}

button.btn.post-btn {
    background-color: #28F086;
    color: white;
}

button.btn.post-btn:hover {
    background-color: #28F086;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    
}
.button-container2 {
    position: fixed;
    bottom: 440px;
    left: 90%;
    transform: translateX(-50%);
    display: flex;
    gap: 20px;
}

</style>
</html>