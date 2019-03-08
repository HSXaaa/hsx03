<%@ page language="java" import="java.util.*,hsx.com.pojo.*" 
contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>"> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>查看用户信息</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<!-- <script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script> -->


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">管理信息</a></li>
    <li><a href="#">查看用户信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">

    <table class="tablelist">
    
    	<thead>
    	<tr>
        <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>出生年月</th>
        </tr>
        </thead>
        
        <tbody>
        <%
        java.util.List<User> lu=(ArrayList<User>)request.getAttribute("lu");
        for(User u:(java.util.List<User>)lu){
        %>
        <tr>
        <td><%=u.getUid() %></td>
        <td><%=u.getUname() %></td>
        <td><%=u.getPwd() %></td>
        <td><%=u.getSex() %></td>
        <td><%=u.getAge() %></td>
        <td><%=u.getBirth() %></td>
        </tr> 
        <%} %>
        </tbody>
         
    </table>
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
