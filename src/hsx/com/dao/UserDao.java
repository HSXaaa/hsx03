package hsx.com.dao;

import hsx.com.pojo.User;

public interface UserDao {

    /* 
     * �����û����������ѯ�û���Ϣ
     * uname �û���
     * pwd   ����
     * 
     * */
	User CheckUserLoginDao(String uname, String pwd);

	/*
	 * �����û�ID�޸�����
	 * newPwd
	 * uid
	 * */
	
	int UserChangePwdDao(String newPwd, int uid);

	//��ȡ�����û���Ϣ
	java.util.List<User> UserShowDao();

	//�û�ע��
	int UserRegDao(User u);
  


}
