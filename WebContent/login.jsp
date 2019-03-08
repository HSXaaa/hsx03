<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>欢迎登录后台管理系统</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">  //<script>标签中的脚本的类型为javascript
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

<script language="javascript"> 
//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='yes'){
   alert("登录失败！您输入的账号或者密码错误，请输入正确的账号密码");
  }
</script>

 <script language="javascript"> 
//取出传回来的参数change并与yes比较
  var changei ='<%=request.getParameter("change")%>';
  if(changei=='yes'){
   alert("修改密码成功，请重新登录");
  }
</script> 

 <script language="javascript"> 
//取出传回来的参数register并与yes比较
  var registeri ='<%=request.getParameter("register")%>';
  if(registeri=='yes'){
   alert("注册成功，进入登录页面");
  }
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
   
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox loginbox1">
    <form action="UserServlet" method="post">
    <input type="hidden" name="oper" value="login" />
    <ul>
    <li><input name="uname" type="text" placeholder="username" class="loginuser" /></li>
    <li><input name="pwd" type="password" placeholder="password" class="loginpwd"  /></li>
<!--     <li class="yzm">
    <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>520</cite> 
    </li> -->
    <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'" />
    <label><a href="reg/reg.html">注册</a></label><label><a href="#">忘记密码</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    <div class="loginbm">Copyright &copy; 2018-2019 hsxdy123.All Rights Reserved. <a href="http://www.hsxdy123.work" target="_blank">Learn more</a></div>

</body>

</html>



<!--pojo层就是对应的数据库表的实体类(如User类)。

    dao层，一般可以再分为***dao接口和***daoImpl实现类，如userDao接口和userDaoImpl实现类,接口负责定义数据库MySQL的操作方法，实现类负责具体的实现，即实现Dao接口定义的方法。

    service层，引用对应的dao层数据库操作，在这里可以编写自己需要的代码（比如简单的判断），也可以再细分为service接口和serviceImpl实现类。

    action层：引用对应的Service层实现业务逻辑，在这里结合Struts的配置文件，跳转到指定的页面，当然也能接受页面传递的请求数据，也可以做些计算处理、前端输入合法性检验(前端可修改网页绕过前端合法性检验，需在后台加一层)。

           对象的调用流程：前端JSP或JS等—Action—Service—DAO—数据库。 -->
           
           
           