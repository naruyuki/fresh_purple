<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.dao.CreationDAO,java.util.List,java.util.ArrayList,model.entity.CreationList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>★マイページ★</title>

<style>


.area {
  width: 500px;
  margin: auto;
  flex-wrap: wrap;
  display: flex;
}
 
.tab_class {
  width: calc(100%/5);
  height: 50px;
  background-color: darkgrey;
  line-height: 50px;
  font-size: 15px;
  text-align: center;
  display: block;
  float: left;
  order: -1;
}
 
input[name="tab_name"] {
  display: none;
}
 
input:checked + .tab_class {
  background-color: cadetblue;
  color: aliceblue;
}
 
.content_class {
  display: none;
  width: 100%;
}
 
input:checked + .tab_class + .content_class {
  display: block;
}



</style>



<body>

<h1>創作図書館</h1>

	<%
		String id = (String)session.getAttribute("user_id");
	
		String name = (String)session.getAttribute("loginInfo");
		
		List<CreationList> likelist = (List)session.getAttribute("likelist");
		List<CreationList> mylist = (List)session.getAttribute("mylist");
		
	
		
	
	%>
	
	<header>
	
		<p><%=name %>さん</p>
		<p>ユーザID:<%=id %></p>
		
		<a href="EditUserInfo.jsp">会員情報変更</a>

	
	</header>
	
	
	
	
	
  <div class="area">
  
    <input type="radio" name="tab_name" id="tab1" checked>
    <label class="tab_class" for="tab1">いいね欄</label>
    <div class="content_class">
      <%
      
      for(CreationList a :likelist){
    	  %>
    	  
    	  <table border="1">
    	  
    	  
    	  	<tr>
    	  	
    	  		<th><a href="detail?user_id=<%= id %>&creation_title=<%= a.getCreation_title() %>&creation_id=<%=a.getCreation_id() %>"><%=a.getCreation_title() %></a></th>
    	  	
    	  	</tr>
    	  	
    	  	<tr>
    	  	
    	  		<td><p>著者：<%=a.getName() %></p></td>
    	  	
    	  	</tr>
			<tr>
    	  	
    	  		<td><p>いいね：<%=a.getReview_count() %></p></td>
    	  	
    	  	</tr>
    	  
    	  </table>
    	  
    	  <%
      }
      
      
      %>
    </div>
    <input type="radio" name="tab_name" id="tab2" >
    <label class="tab_class" for="tab2">マイリスト</label>
    <div class="content_class">
       <%
      
      for(CreationList a :mylist){
    	  %>
    	  
    	  <table border="1">
    	  
    	  
    	  	<tr>
    	  	
    	  		<th><a href="detail?user_id=<%= id %>&creation_title=<%= a.getCreation_title() %>&creation_id=<%=a.getCreation_id() %>"><%=a.getCreation_title() %></a></th>
    	  	
    	  	</tr>
    	  	
    	  	
			<tr>
    	  	
    	  		<td><p>いいね：<%=a.getReview_count() %></p></td>
    	  	
    	  	</tr>
    	  
    	  </table>
    	  
    	  <%
      }
      
      
      %>
    </div>
    
    
    
    
  </div>
	
	
	
	
	
	
	
	

</body>
</html>