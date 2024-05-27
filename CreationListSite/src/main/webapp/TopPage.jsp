<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★トップページ★</title>
</head>
<body>

<h1>創作図書館</h1>

<header>

	<%if(session.getAttribute("loginInfo") != null){
		%>
		<p><%=session.getAttribute("loginInfo") %>さん、ようこそ！</p>
		<%
	}
		%>


	


	


	<nav>
	
	
		<%if(session.getAttribute("loginInfo") != null){
			
			%><a href="mypage">マイページ</a>
			<a href="Logout.jsp">ログアウト</a><% 
		
	}else{
		%><a href="Registration.jsp">新規登録</a>
		
		<a href="Login.jsp">ログイン</a><% 
	}
		%>
	
		
	
	
	</nav>




	<form action="" method="post">
	
		<input type="text" name="search">
	
		<button>検索</button>
	
	
	</form>




</header>



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
	
	<table border="1">
	
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
</html>