package hsx.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import hsx.com.pojo.User;
import hsx.com.service.UserService;
import hsx.com.service.impl.UserServiceImpl;

/**
 * Servlet重定向路径总结：
 * 	相对路径：从当前请求的路径查找资源的路径
 * 		       相对路径如果servlet的别名中包含目录，会造成重定向资源查找失败。
 * 	绝对路径：/虚拟项目名/资源路径  (第一个"/"表示服务器根目录)
 * 
 * Servlet请求转发：
 * 		/表示项目根目录。
 * 		req.getRequestDispatcher("/资源路径").forward(req, resp);
 * 
 * @author MyPC
 *
 */

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//声明日志对象
    Logger logger=Logger.getLogger(UserServlet.class); 

	//获取service层对象
	UserService us=new UserServiceImpl();//UserService是接口，UserServiceImpl是实现UserService接口的类
	                                     //这种用法是父类引用指向子类对象，即声明的是父类，实际指向的是子类的一个对象；即“向上转型”。
	                                     /*
	                                      * Animal a = new Cat();  // 向上转型  
                                            a.eat();               // 调用的是 Cat 的 eat
                                            Cat c = (Cat)a;        // 向下转型  
                                            c.work();        // 调用的是 Cat 的 work 
                                         */
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置请求编码格式
		request.setCharacterEncoding("UTF-8");
				
		//设置响应编码格式
		response.setContentType("text/html;charset=UTF-8");
				
		//获取操作符
		String oper = request.getParameter("oper");
		if("login".equals(oper)) { //x.equals(y) 比较x和y的值是否相等              "login"-post
		//调用登录处理方法       
		CheckUserLogin(request,response);
					
		}else if ("out".equals(oper)) {                          //"out"-get
		//调用退出功能
		UserOut(request,response);
					
		}else if ("pwd".equals(oper)) {                         //"pwd"-post
		//调用密码修改功能
		UserChangePwd(request,response);
		
		}else if ("show".equals(oper)) {                        //"show"-get
	    //调用显示所有用户信息功能
		UserShow(request,response);	
			
	    }else if ("reg".equals(oper)) {                         //"reg"-post
		//调用注册功能
		UserReg(request,response);			
		}else {
		((Category) logger).debug("没有找到对应的操作符：" + oper);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//设置请求编码格式
		request.setCharacterEncoding("UTF-8");
		
		//设置响应编码格式
		response.setContentType("text/html;charset=UTF-8");
		
		//获取操作符
		String oper = request.getParameter("oper");//String oper 创建一个oper对象；
		                                          //request.getParameter()获取name=oper的参数，request.getParameter()方法返回String类型的数据。

		if("login".equals(oper)) { //x.equals(y) 比较x和y的值是否相等              "login"-post
		//调用登录处理方法       
		CheckUserLogin(request,response);
						
		}else if ("out".equals(oper)) {                          //"out"-get
		//调用退出功能
		UserOut(request,response);
						
		}else if ("pwd".equals(oper)) {                         //"pwd"-post
		//调用密码修改功能
		UserChangePwd(request,response);
			
		}else if ("show".equals(oper)) {                        //"show"-get
		//调用显示所有用户信息功能
		UserShow(request,response);	
				
		}else if ("reg".equals(oper)) {                         //"reg"-post
		//调用注册功能
		UserReg(request,response);			
		}else {
		((Category) logger).debug("没有找到对应的操作符：" + oper);
		}
	}

	
	//用户注册
	private void UserReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//获取请求信息
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String sex=request.getParameter("sex");
		int age=request.getParameter("age")!=""?Integer.parseInt(request.getParameter("age")):0;
		String birth=request.getParameter("birth");
		String[] bs=null;
		if(birth!="") {
			bs=birth.split("/");
		}
	    birth=bs[2]+"-"+bs[0]+"-"+bs[1];
		System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
		User u=new User(0,uname,pwd,sex,age,birth);
		//处理请求信息
		//调用业务层处理
		int index=us.UserRegService(u);

		//响应处理结果
		if(index>0) {
			//重定向
			 response.sendRedirect("/project2/login.jsp?register=yes");
				return;
			}
	}
	
	//显示所有用户信息
	private void UserShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理请求
		//调用service
		 java.util.List<User> lu=(java.util.List<User>) us.UserShowService();
		if(lu!=null) {
			//将查询的用户数据存储到request对象
			request.setAttribute("lu", lu);
			//请求转发
			/*response.sendRedirect("/main/showUser.jsp");*/
			request.getRequestDispatcher("/main/showUser.jsp").forward(request, response);
			return;
		}
	}

	//用户修改密码
	private void UserChangePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//获取新密码数据
		String newPwd=request.getParameter("newPwd");
		
		//从session获取用户信息
		User u=(User) request.getSession().getAttribute("user");
		int uid=u.getUid();
		
		//调用service处理
		int index=us.UserChangePwdService(newPwd,uid);
		
		//处理请求
		//重定向
	if(index>0) {
		 response.sendRedirect("/project2/login.jsp?change=yes");
			return;
		}

	}

	//用户退出
	private void UserOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//获取session对象
		HttpSession hs=request.getSession();
		//强制销毁session
		hs.invalidate();
		//重定向到登录页面
		response.sendRedirect("/project2/login.jsp");
	}

	//用户登录
	private void CheckUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//获取请求信息
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");

		//处理请求信息
		

		//校验
		User u=us.CheckUserLoginService(uname, pwd);
        if (u!=null) {
        	//获取Session对象
        	HttpSession hs=request.getSession();
        	
        	//将用户数据存储到Session中
        	hs.setAttribute("user", u);
        	
        	//重定向
        	response.sendRedirect("main/main.html");
        	return;
		}else {

			//请求转发
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			//重定向
			 response.sendRedirect("/project2/login.jsp?error=yes");
			 
			return;
		}
		//响应处理信息
		  //直接响应
		  //请求转发
		  
	}

}
