


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>トップページ</title>
</head>
<body>




	<h2>
		<a href="TopPage.jsp">創作図書館</a>
	</h2>
	<nav id="menubar" class="nav-fix-pos">
		<ul>
			<%if(session.getAttribute("loginInfo") == null){
				%>
					<li><a href="Registration.jsp">New_registration<span>新規登録</span></a></li>
					<li><a href="Login.jsp">Login<span>ログイン</span></a></li>
				
				<%
			}else{
				%>
					<li><a href="mypage">Mypage<span>マイページ</span></a></li>
					<li><a href="Logout.jsp">Mypage<span>ログアウト</span></a></li>
					
				<%
			}
			%>
		
					</ul>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<body>
	<div class="search-container">
	
		<form action="search" method="post">
		
			<input type="text" name = "search" class="search-box" placeholder="著者検索...">
			<button class="search-button">
				<svg viewBox="0 0 24 24">
	                <path
						d="M21.71 20.29l-3.4-3.39A9.456 9.456 0 0020 11.5C20 6.81 16.19 3 11.5 3S3 6.81 3 11.5 6.81 20 11.5 20c2.26 0 4.31-.78 5.91-2.09l3.4 3.39c.19.18.44.29.7.29.26 0 .52-.1.71-.29.39-.39.39-1.03 0-1.42zM11.5 18c-3.59 0-6.5-2.91-6.5-6.5S7.91 5 11.5 5s6.5 2.91 6.5 6.5S15.09 18 11.5 18z" />
	            </svg>
			</button>
		
		</form>
		
	</div>

	<h3>ランキング</h3>


	<button class="search-button2" onclick="filterItems('週間')">週間
	</button>
	<button class="search-button2" onclick="filterItems('恋愛')">恋愛
	</button>
	<button class="search-button2" onclick="filterItems('ファンタジー')">
		文芸</button>
	<button class="search-button2" onclick="filterItems('SF')">SF
	</button>
	<button class="search-button2" onclick="filterItems('異世界')">
		異世界</button>
		
		
		
		<%

List<CreationList> list = new ArrayList<CreationList>();

String user_id =(String) session.getAttribute("user_id");

if(request.getAttribute("list") == null){
	
	CreationDAO dao = new CreationDAO();
	
	list = dao.GetListForMonth();
	
}else{
	
	list = (List)request.getAttribute("list");
	
}



for(CreationList a : list){
	
	%>
	
	<table >
	
		<tr>
			<th><a href="detail?user_id=<%= user_id %>&creation_title=<%= a.getCreation_title() %>&creation_id=<%=a.getCreation_id() %>"><%= a.getCreation_title() %></th>

		</tr>
		<tr>
			<td>著者：<%= a.getName() %></td>

		</tr>
		<tr>
			<td>いいね：<%=a.getReview_count() %></td>
			
			

		</tr>
	
	
	
	
	</table>
	
	
	

	
	<%
}

%>
		

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

.search-container {
	display: flex;
	align-items: center;
	max-width: 400px;
	margin: 0 auto;
}

.search-box {
	flex: 1;
	padding: 10px 15px;
	border: 1px solid #ccc;
	border-radius: 20px 0 0 20px;
	border-right: none;
	font-size: 16px;
	outline: none;
}

.search-button {
	background-color: #28F086;
	border: 1px solid #28F086;
	border-radius: 0 20px 20px 0;
	padding: 10px 15px;
	cursor: pointer;
	outline: none;
	display: flex;
	align-items: center;
	justify-content: center;
}

.search-button svg {
	fill: white;
	width: 16px;
	height: 16px;
}

h3 {
	font-size: 30px;
	font-family: 'Noto Serif JP', sans-serif;
	text-align: center;
}

.search-button2 {
	display: block; 
	width: 100%; 
	padding: 10px 20px;
	border: none;
	background-color: #4CAF50; 
	color: white;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	border-radius: 4px;
	transition-duration: 0.4s;
}

.search-button2:hover {
	background-color: #28F086; /* 暗い緑色 */
}
</style>
</html>