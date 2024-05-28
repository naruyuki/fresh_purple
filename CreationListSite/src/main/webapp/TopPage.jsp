


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

<<<<<<< HEAD
<header>

	<%if(session.getAttribute("loginInfo") != null){
		%>
		<p><%=session.getAttribute("loginInfo") %>さん、ようこそ！</p>
		<%
	}
		%>


</header>








</body>
</html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>トップページ</title>
</head>
<body>
	<h2>
		<a href="#">創作図書館</a>
	</h2>
	<nav id="menubar" class="nav-fix-pos">
		<ul>
		<%if(session.getAttribute("loginInfo") != null){
			
			%>
			<li><a href="mypage">Mypage<span>マイページ</span></a></li>
			<li><a href="Logout.jsp">Logout<span>ログアウト</span></a></li>
			<% 
		
	}else{
		%>
			<li><a href="Register.jsp">New_registration<span>新規登録</span></a></li>
			<li><a href="Login.jsp">Login<span>ログイン</span></a></li>
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
<form action="search" method="post">
	<div class="search-container">
		<input type="text" class="search-box" placeholder="キーワード検索...">
		<button class="search-button">
			<svg viewBox="0 0 24 24">
                <path
					d="M21.71 20.29l-3.4-3.39A9.456 9.456 0 0020 11.5C20 6.81 16.19 3 11.5 3S3 6.81 3 11.5 6.81 20 11.5 20c2.26 0 4.31-.78 5.91-2.09l3.4 3.39c.19.18.44.29.7.29.26 0 .52-.1.71-.29.39-.39.39-1.03 0-1.42zM11.5 18c-3.59 0-6.5-2.91-6.5-6.5S7.91 5 11.5 5s6.5 2.91 6.5 6.5S15.09 18 11.5 18z" />
            </svg>
		</button>
	</div>
	</form>

	<h3>ランキング</h3>


 <ul>
        <li><button class="search-button2" onclick="filterItems('週間')"><span>weekly</span>週間</button></li>
        <li><button class="search-button2" onclick="filterItems('恋愛')"><span>love</span>恋愛</button></li>
        <li><button class="search-button2" onclick="filterItems('文芸')"><span>literature</span>文芸</button></li>
        <li><button class="search-button2" onclick="filterItems('SF')"><span>science fiction</span>SF</button></li>
        <li><button class="search-button2" onclick="filterItems('ファンタジー')"><span></span>ファンタジー</button></li>
        <li><button class="search-button2" onclick="filterItems('異世界')">異世界</button></li>
    </ul>
    
    <script>
    function filterItems(category) {
        console.log(category + ' button clicked!');
        // フィルタリングのロジックをここに追加
    }
</script>

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
		
	
	
	週間
	<button class="icon-button">
		<i class="fas fa-trash icon"></i>
		🌙
	</button>
	恋愛
	<button class="icon-button">
		<i class="fas fa-trash icon"></i>
		💞
	</button>
	文芸
	<button class="icon-button">
		<i class="fas fa-trash icon"></i>
		📚
	</button>
	SF
	<button class="icon-button">
		<i class="fas fa-trash icon"></i>
		🛸
	</button>
	異世界
	<button class="icon-button">
		<i class="fas fa-trash icon"></i>
		🌎
	</button>
		
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
.nav {
        background-color: #2c3e50;
    }

    .nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: space-between;
    }

    .nav li {
        flex: 1;
    }

    .search-button2 {
        width: 100%;
        padding: 14px 20px;
        text-align: center;
        color: white;
        background-color: #34495e;
        border: none;
        cursor: pointer;
        font-size: 1em;
        transition: background-color 0.3s;
    }

    .search-button2:hover {
        background-color: #2980b9;
    }

</style>
</html>