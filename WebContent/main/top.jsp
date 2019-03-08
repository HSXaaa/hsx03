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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})
	//退出功能
 $("#out").click(function(){
		var flag=window.confirm("你真的要退出吗？");
		if(flag){
			window.top.location.href="UserServlet?oper=out";
			/*UserServlet是servlet;?oper=out表示参数oper赋值out,该方法传递参数的方法是GET
			  window.location.href 是本页面跳转
			  window.top.location.href是最外层的页面跳转*/
		}
	})
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
        
            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="javascript:void(0)" id="out">退出</a></li>
    </ul>
     
    <div class="user">
    <span>
    <%=((User)session.getAttribute("user")).getUname()%>
    </span>

    </div>    
    
    </div>

</body>
</html>
