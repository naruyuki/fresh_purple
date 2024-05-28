<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>★詳細★</title>

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

<p>
<form action="comment" method="post">
	

		<input type="hidden" name="user_id" value="<%=session.getAttribute("user_id") %>">
		
		<input type="hidden" name="creation_id" value="<%=session.getAttribute("creation_id") %>">

		<input type="text" name="comment" placeholder="コメント...">		
		
		<button>コメント</button>
				
	</form>
	</p>
	
	
	<%
}else{
	
	%>
	
	<form action="Login.jsp" method="get">

				
		
		<button>いいね！</button>
				
	</form>
	
	
	
	
	
	
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
		<tr>
			<td>コメントいいね：<%=a.getComment_fav() %></td>
			

		</tr>
		
	
	
	
	
	</table>
	
	
	

	
	<%
	
}




%>

<a href="TopPage.jsp">トップへ戻る</a>




</body>
</html>