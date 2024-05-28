<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
	<h2>
		<a href="Toppage.jsp">創作図書館</a>
	</h2>
	<nav id="menubar" class="nav-fix-pos">
		<ul>
			<li><a href="Writing.jsp">Creation<span>創作する</span></a></li>
			<li><a href="EditCreation.jsp">Works_edit<span>作品を編集する</span></a></li>
			<li><a href="EditUserInfo.jsp">Detail_change<span>登録内容を変更する</span></a></li>
			<li><a href="Logout.jsp">Logout<span>ログアウト</span></a></li>
			<li><a href="Deactivate.jsp">Unsubscribe<span>退会する</span></a></li>
		</ul>
	</nav>
	<select name="genre">
		<option value="creation">創作物一覧</option>
		<option value="favorite">お気に入り</option>
		<option value="draft">下書き一覧</option>
	</select>
	
	<%
		String id = (String)session.getAttribute("user_id");
	
		String name = (String)session.getAttribute("loginInfo");
		
		List<CreationList> likelist = (List)session.getAttribute("likelist");
		List<CreationList> mylist = (List)session.getAttribute("mylist");
		
	
		
	
	%>
	 <div class="user-info">
        <p>ユーザ名:<%= name %></p>
        <p>ユーザID: <%= id %></p>
        <a href="" class="icon" title="マイページ">
            <i class="fas fa-user-circle"></i>
        </a>
    </div>
	
</body>
<style>
@import url('https://fonts.googleapis.com/css?family=Noto+Serif+JP');

body {
	margin: 0;
	font-family: Arial, sans-serif;
}

.header {
	padding: 20px;
	border-bottom: 1px solid #ccc;
}

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
	font-size: 25px;
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

select {
	position: relative;
	top: 140px;
	left: 43%;
	appearance: none;
	background-color: #3CB371; /* シックな緑色 */
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	outline: none;
	width: 200px; /* 幅を指定 */
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

select:hover {
	background-color: #3cb371; /* マウスホバー時の色 */
}

select:focus {
	outline: none;
	box-shadow: 0 0 3px 2px rgba(46, 139, 87, 0.5);
}

/* 矢印のカスタマイズ */
select::after {
	content: '▼';
	position: absolute;
	right: 10px;
	pointer-events: none;
}

option {
	text-align: center;
}
h4{
position: absolute;
top: 360px;
font-family: Arial, sans-serif;
}
h3{
position: absolute;
top: 340px;
font-family: Arial, sans-serif;
}
.user-info {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
            position: absolute;
            top: 340px;
        }
        .user-info p {
            margin: 0 10px 0 0;
        }
        .user-info .a{
            font-size: 50px;
            color: cadetblue;
            position: absolute;
            top: 340px;
            size: 60px;
        }

</style>
</html>