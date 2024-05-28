<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>★詳細★</title>

</head>

<body>
<h2><a href="#">創作図書館</a></h2>

<header>

	<%if(session.getAttribute("loginInfo") != null){
		%>
		<p><%=session.getAttribute("loginInfo") %>さん、ようこそ！</p>
		<%
	}
		%>


	


	


	<nav id="menubar" class="nav-fix-pos">
		<ul>
		<%if(session.getAttribute("loginInfo") != null){
			
			%>
			<li><a href="Detail.jsp">Mypage<span>マイページ</span></a></li>
			<li><a href="Register.jsp">Logout<span>ログアウト</span></a></li>
			<% 
		
	}else{
		%>
			<li><a href="Login.jsp">New_registration<span>新規登録</span></a></li>
			<li><a href="Mypage.jsp">Login<span>ログイン</span></a></li>
			<% 
	}
		%>
		</ul>
	</nav>









</header>

<%


CreationList res = (CreationList)session.getAttribute("result");


CreationDAO dao = new CreationDAO();

String user_id = "";

if(session.getAttribute("user_id") != null){
	user_id = (String) session.getAttribute("user_id");
}






%>

<h1><%=res.getCreation_title() %></h1>
<p><%=res.getCreation_text() %></p>
<p>著者：<%=res.getName() %></p>
<p>いいね数：<%=res.getReview_count() %></p>


<%

if(!user_id.equals("")){
	
	%>
	
	<p>

	<%if(dao.CheckLikeCreation(user_id, (String)session.getAttribute("creation_id"))) {
		
		%>
		
		<form action="creationdislike" method="post">
	
					
			<input type="hidden" name="creation_id" value="<%=session.getAttribute("creation_id") %>">
			<button>いいねを解除</button>
					
		</form>
		
		
		
		<%
	}else{
		
		%>
		
		<form action="creationlike" method="post">
	
					
			<input type="hidden" name="creation_id" value="<%=session.getAttribute("creation_id") %>">
			<button>いいね！</button>
					
		</form>
		
		
		
		<%
		
		
	}
	%>





</p>
	
	
	<%
}else{
	
	%>
	
	<form action="Login.jsp" method="get">

				
		
		
				
	
	
	
	<%
	
	
}



%>










<%

List<CreationList> res2 = (List)session.getAttribute("comment");

for(CreationList a : res2){
	
%>
	
	<table border="1">
	
		<tr>
			<th><%=a.getComment_text() %></th>

		</tr>
		<tr>
			<td>コメント者：<%= a.getName() %></td>

		</tr>
		<form action="Login.jsp" method="get">
		<tr>
			<td>コメント：<div class="like-container">
        <button class="like-button" onclick="toggleLike(this)">いいね！
            <svg viewBox="0 0 24 24">
                <path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z"/>
            </svg>
        </button>
        <span class="like-count" id="likeCount"><%=a.getComment_fav() %></span>
    </div></td>
    
    <script>
    let likeCount = 0;
        let isLiked = false;

        function toggleLike(button) {
            isLiked = !isLiked;
            likeCount += isLiked ? 1 : -1;
            button.classList.toggle('liked', isLiked);
            document.getElementById('likeCount').innerText = likeCount;
        }
    </script>
			

		</tr>
		</form>
		
	
	
	
	
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
table {
        border-collapse: collapse;
        width: 100%; /* Adjust width as needed */
    }
    th, td {
        border: 1px solid #000; /* Add border for clarity */
        padding: 10px;
        text-align: left;
    }
    .like-container {
            display: flex;
            align-items: center;
            font-family: Arial, sans-serif;
        }
        .like-button {
            background: none;
            border: none;
            cursor: pointer;
            outline: none;
            padding: 0;
        }
        .like-button svg {
            fill: grey;
            width: 24px;
            height: 24px;
            transition: fill 0.3s;
        }
        .like-button.liked svg {
            fill: red;
        }
        .like-count {
            font-size: 16px;
            margin-left: 10px;
        }
</style>
</html>