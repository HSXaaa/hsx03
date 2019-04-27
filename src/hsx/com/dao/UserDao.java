package hsx.com.dao;

import hsx.com.pojo.User;

public interface UserDao {

    /* 
     * 根据用户名和密码查询用户信息
     * uname 用户名
     * pwd   密码
     * 
     * */
	User CheckUserLoginDao(String uname, String pwd);

	/*
	 * 根据用户ID修改密码
	 * newPwd
	 * uid
	 * */
	
	int UserChangePwdDao(String newPwd, int uid);

	//获取所有用户信息
	java.util.List<User> UserShowDao();

	//用户注册
	int UserRegDao(User u);
  


}
