package hsx.com.service.impl;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import hsx.com.dao.UserDao;
import hsx.com.dao.impl.UserDaoImpl;
import hsx.com.pojo.User;
import hsx.com.service.UserService;

public class UserServiceImpl implements UserService {
    //声明日志对象
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//声明Dao层对象
	UserDao ud=new UserDaoImpl();
	//用户登录
	public User CheckUserLoginService(String uname, String pwd) {
		//打印日志
		((Category) logger).debug(uname+"发起登录请求");
		User u=ud.CheckUserLoginDao(uname, pwd);
		//判断
		if (u!=null) { 
			((Category) logger).debug(uname+"登录成功");
		}else {
			((Category) logger).debug(uname+"登录失败");
		}
		return u;
	}
	
	//修改用户密码
	@Override
	public int UserChangePwdService(String newPwd, int uid) {
		// TODO Auto-generated method stub
		logger.debug(uid+":发起密码请求");
		int index=ud.UserChangePwdDao(newPwd, uid);
		if (index>0) {
			logger.debug(uid+":密码修改成功");
		}else {
			logger.debug(uid+":密码修改失败");
		}
		return index;
	}
	
	//获取所有用户的信息
	@Override
	public java.util.List<User> UserShowService() {
		// TODO Auto-generated method stub
        java.util.List<User> lu=ud.UserShowDao();
        logger.debug("显示所有用户信息："+lu);
		return ud.UserShowDao();
	}

	//用户注册
	@Override
	public int UserRegService(User u) {
		// TODO Auto-generated method stub
		return ud.UserRegDao(u);
	}
}
