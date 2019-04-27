package hsx.com.service.impl;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import hsx.com.dao.UserDao;
import hsx.com.dao.impl.UserDaoImpl;
import hsx.com.pojo.User;
import hsx.com.service.UserService;

public class UserServiceImpl implements UserService {
    //������־����
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//����Dao�����
	UserDao ud=new UserDaoImpl();
	//�û���¼
	public User CheckUserLoginService(String uname, String pwd) {
		//��ӡ��־
		((Category) logger).debug(uname+"�����¼����");
		User u=ud.CheckUserLoginDao(uname, pwd);
		//�ж�
		if (u!=null) { 
			((Category) logger).debug(uname+"��¼�ɹ�");
		}else {
			((Category) logger).debug(uname+"��¼ʧ��");
		}
		return u;
	}
	
	//�޸��û�����
	@Override
	public int UserChangePwdService(String newPwd, int uid) {
		// TODO Auto-generated method stub
		logger.debug(uid+":������������");
		int index=ud.UserChangePwdDao(newPwd, uid);
		if (index>0) {
			logger.debug(uid+":�����޸ĳɹ�");
		}else {
			logger.debug(uid+":�����޸�ʧ��");
		}
		return index;
	}
	
	//��ȡ�����û�����Ϣ
	@Override
	public java.util.List<User> UserShowService() {
		// TODO Auto-generated method stub
        java.util.List<User> lu=ud.UserShowDao();
        logger.debug("��ʾ�����û���Ϣ��"+lu);
		return ud.UserShowDao();
	}

	//�û�ע��
	@Override
	public int UserRegService(User u) {
		// TODO Auto-generated method stub
		return ud.UserRegDao(u);
	}
}
