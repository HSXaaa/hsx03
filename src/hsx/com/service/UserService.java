package hsx.com.service;

import hsx.com.pojo.User;

public interface UserService {

	/*
	 * �����û���¼
	 * uname �û���
	 * pwd   ����  
	 * ���ز�ѯ�����û���Ϣ
	 * * */

	User CheckUserLoginService(String uname, String pwd);
	/*User����������ΪCheckUserLoginService()�����ķ���ֵ���ͣ����ص���Userʵ�����Ķ���
	 *����������ֵ���ͣ����ص��Ǹ���Ķ���
	 *��������������ֵ���ͣ����ص��Ǹó�������������
	 *�ӿ���������ֵ���ͣ����ص��Ǹýӿڵ�ʵ����Ķ��� 
	 * */

	/*
	 *�޸��û�����
	 *newPwd
	 *uid 
	 * */
	
	int UserChangePwdService(String newPwd, int uid);

	
	//��ȡ�����û�����Ϣ
	java.util.List<User> UserShowService();

	//�û�ע��
	int UserRegService(User u);
}
