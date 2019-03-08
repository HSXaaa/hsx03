package hsx.com.service;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import hsx.com.pojo.User;

public interface UserService {

	/*
	 * 检验用户登录
	 * uname 用户名
	 * pwd   密码  
	 * 返回查询到的用户信息
	 * * */

	User CheckUserLoginService(String uname, String pwd);
	/*User是类名，作为CheckUserLoginService()方法的返回值类型，返回的是User实例化的对象
	 *类名作返回值类型：返回的是该类的对象
	 *抽象类名作返回值类型：返回的是该抽象类的子类对象
	 *接口名作返回值类型：返回的是该接口的实现类的对象 
	 * */

	/*
	 *修改用户密码
	 *newPwd
	 *uid 
	 * */
	
	int UserChangePwdService(String newPwd, int uid);

	
	//获取所有用户的信息
	java.util.List<User> UserShowService();

	//用户注册
	int UserRegService(User u);
}
