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
 * Servlet�ض���·���ܽ᣺
 * 	���·�����ӵ�ǰ�����·��������Դ��·��
 * 		       ���·�����servlet�ı����а���Ŀ¼��������ض�����Դ����ʧ�ܡ�
 * 	����·����/������Ŀ��/��Դ·��  (��һ��"/"��ʾ��������Ŀ¼)
 * 
 * Servlet����ת����
 * 		/��ʾ��Ŀ��Ŀ¼��
 * 		req.getRequestDispatcher("/��Դ·��").forward(req, resp);
 * 
 * @author MyPC
 *
 */

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//������־����
    Logger logger=Logger.getLogger(UserServlet.class); 

	//��ȡservice�����
	UserService us=new UserServiceImpl();//UserService�ǽӿڣ�UserServiceImpl��ʵ��UserService�ӿڵ���
	                                     //�����÷��Ǹ�������ָ��������󣬼��������Ǹ��࣬ʵ��ָ����������һ�����󣻼�������ת�͡���
	                                     /*
	                                      * Animal a = new Cat();  // ����ת��  
                                            a.eat();               // ���õ��� Cat �� eat
                                            Cat c = (Cat)a;        // ����ת��  
                                            c.work();        // ���õ��� Cat �� work 
                                         */
    
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//������������ʽ
		request.setCharacterEncoding("UTF-8");
				
		//������Ӧ�����ʽ
		response.setContentType("text/html;charset=UTF-8");
				
		//��ȡ������
		String oper = request.getParameter("oper");
		if("login".equals(oper)) { //x.equals(y) �Ƚ�x��y��ֵ�Ƿ����              "login"-post
		//���õ�¼������       
		CheckUserLogin(request,response);
					
		}else if ("out".equals(oper)) {                          //"out"-get
		//�����˳�����
		UserOut(request,response);
					
		}else if ("pwd".equals(oper)) {                         //"pwd"-post
		//���������޸Ĺ���
		UserChangePwd(request,response);
		
		}else if ("show".equals(oper)) {                        //"show"-get
	    //������ʾ�����û���Ϣ����
		UserShow(request,response);	
			
	    }else if ("reg".equals(oper)) {                         //"reg"-post
		//����ע�Ṧ��
		UserReg(request,response);			
		}else {
		((Category) logger).debug("û���ҵ���Ӧ�Ĳ�������" + oper);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//������������ʽ
		request.setCharacterEncoding("UTF-8");
		
		//������Ӧ�����ʽ
		response.setContentType("text/html;charset=UTF-8");
		
		//��ȡ������
		String oper = request.getParameter("oper");//String oper ����һ��oper����
		                                          //request.getParameter()��ȡname=oper�Ĳ�����request.getParameter()��������String���͵����ݡ�

		if("login".equals(oper)) { //x.equals(y) �Ƚ�x��y��ֵ�Ƿ����              "login"-post
		//���õ�¼������       
		CheckUserLogin(request,response);
						
		}else if ("out".equals(oper)) {                          //"out"-get
		//�����˳�����
		UserOut(request,response);
						
		}else if ("pwd".equals(oper)) {                         //"pwd"-post
		//���������޸Ĺ���
		UserChangePwd(request,response);
			
		}else if ("show".equals(oper)) {                        //"show"-get
		//������ʾ�����û���Ϣ����
		UserShow(request,response);	
				
		}else if ("reg".equals(oper)) {                         //"reg"-post
		//����ע�Ṧ��
		UserReg(request,response);			
		}else {
		((Category) logger).debug("û���ҵ���Ӧ�Ĳ�������" + oper);
		}
	}

	
	//�û�ע��
	private void UserReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//��ȡ������Ϣ
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
		//����������Ϣ
		//����ҵ��㴦��
		int index=us.UserRegService(u);

		//��Ӧ������
		if(index>0) {
			//�ض���
			 response.sendRedirect("/project2/login.jsp?register=yes");
				return;
			}
	}
	
	//��ʾ�����û���Ϣ
	private void UserShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������
		//����service
		 java.util.List<User> lu=(java.util.List<User>) us.UserShowService();
		if(lu!=null) {
			//����ѯ���û����ݴ洢��request����
			request.setAttribute("lu", lu);
			//����ת��
			/*response.sendRedirect("/main/showUser.jsp");*/
			request.getRequestDispatcher("/main/showUser.jsp").forward(request, response);
			return;
		}
	}

	//�û��޸�����
	private void UserChangePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//��ȡ����������
		String newPwd=request.getParameter("newPwd");
		
		//��session��ȡ�û���Ϣ
		User u=(User) request.getSession().getAttribute("user");
		int uid=u.getUid();
		
		//����service����
		int index=us.UserChangePwdService(newPwd,uid);
		
		//��������
		//�ض���
	if(index>0) {
		 response.sendRedirect("/project2/login.jsp?change=yes");
			return;
		}

	}

	//�û��˳�
	private void UserOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//��ȡsession����
		HttpSession hs=request.getSession();
		//ǿ������session
		hs.invalidate();
		//�ض��򵽵�¼ҳ��
		response.sendRedirect("/project2/login.jsp");
	}

	//�û���¼
	private void CheckUserLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//��ȡ������Ϣ
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");

		//����������Ϣ
		

		//У��
		User u=us.CheckUserLoginService(uname, pwd);
        if (u!=null) {
        	//��ȡSession����
        	HttpSession hs=request.getSession();
        	
        	//���û����ݴ洢��Session��
        	hs.setAttribute("user", u);
        	
        	//�ض���
        	response.sendRedirect("main/main.html");
        	return;
		}else {

			//����ת��
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			//�ض���
			 response.sendRedirect("/project2/login.jsp?error=yes");
			 
			return;
		}
		//��Ӧ������Ϣ
		  //ֱ����Ӧ
		  //����ת��
		  
	}

}
