package hsx.com.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import hsx.com.dao.UserDao;
import hsx.com.pojo.User;

public class UserDaoImpl implements UserDao {
    //�����û����������ѯ�û���Ϣ
	@Override
	public User CheckUserLoginDao(String uname, String pwd) {
		
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;//PreparedStatement��java.sql�������һ���ӿڣ�����ִ��SQL����ѯ��
		                          //ͨ������connection.preparedStatement(sql)�������Ի��PreparedStatment����
		ResultSet rs=null;
		//��������
		User u=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			
			//��ȡ����
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
			
			//����sql����
			String sql="select*from t_user where uname=? and pwd=?";
			
			//����sql�������
			ps=(PreparedStatement) conn.prepareStatement(sql);
			
			//��ռλ����ֵ
			ps.setString(1, uname); //setString(x,y)�����ڵĲ�����ӦSql�е�λ�ú�ֵ����һ������Ϊ������ָ�ڼ����ʺţ��ڶ�����������Ҫ�����ʺ�λ�õ�ֵ����Ҫ��ѯ�����ݱ���ֶ�����
			                        //eg��SQL = &amp;quot;select * from login_info where username = ? and password = ?&amp;quot;; pstmt.setString(1, username); pstmt.setString(2, password);
			                       //��usernameд����һ���ʺţ� ��psssword����ڶ����ʺ�
			ps.setString(2, pwd);
			
			//ִ��sql
			rs=ps.executeQuery();
			/* ʹ��JDBC�������ݿ���Ҫ�Ĳ�����һ�������������򣻵ڶ������������ݿ⣻���������������ݿ⣻���Ĳ���ִ�в�ѯ��
			 * �����ڵ��Ĳ�ִ�в�ѯʱ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ⣬
			 * executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ�á�
			 * ����䣺String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);*/
			
			//�������
			while(rs.next()) {
				//��������ֵ
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//�ر���Դ
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//���ؽ��
		return u;
	}

	//�����û�ID�޸��û�����
	@Override
	public int UserChangePwdDao(String newPwd, int uid) {
		// TODO Auto-generated method stub
		//����jdbc����
		Connection conn=null;
		PreparedStatement ps=null;
		//��������
		int index=-1;
		try {
		//��������
			Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
		//����SQL����
			String sql="update t_user set pwd=? where uid=?";
		//����SQL�������
			ps=(PreparedStatement) conn.prepareStatement(sql);
		//��ռλ����ֵ
			ps.setString(1,newPwd);
			ps.setInt(2,uid);
		//ִ��
			index=ps.executeUpdate();//����executeUpdate() ����ִ���ѷ��͵�Ԥ�����sql ������ִ�гɹ��ļ�¼������ int

	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		//�ر���Դ
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//���ؽ��
		return index;
	}

	//��ȡ�����û���Ϣ
	@Override
	public java.util.List<User> UserShowDao() {
		// TODO Auto-generated method stub
		//����jdbc����
				Connection conn=null;
				PreparedStatement ps=null;//PreparedStatement��java.sql�������һ���ӿڣ�����ִ��SQL����ѯ��
				                          //ͨ������connection.preparedStatement(sql)�������Ի��PreparedStatment����
				ResultSet rs=null;
				//��������
			    java.util.List<User> lu=null;
				try {
					//��������
					Class.forName("com.mysql.jdbc.Driver");
					
					//��ȡ����
					conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
					
					//����sql����
					String sql="select*from t_user";
					
					//����sql�������
					ps=(PreparedStatement) conn.prepareStatement(sql);
					
					//ִ��sql
					rs=ps.executeQuery();
					/* ʹ��JDBC�������ݿ���Ҫ�Ĳ�����һ�������������򣻵ڶ������������ݿ⣻���������������ݿ⣻���Ĳ���ִ�в�ѯ��
					 * �����ڵ��Ĳ�ִ�в�ѯʱ��Ҫ��statement���executeQuery()�������´�selectָ���Բ�ѯ���ݿ⣬
					 * executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ�á�
					 * ����䣺String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);*/
					
					//�����ϸ�ֵ
					lu=(java.util.List<User>) new ArrayList<User>();
					//�������
					while(rs.next()) {
						//��������ֵ
						User u=new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
						u.setSex(rs.getString("sex"));
						u.setAge(rs.getInt("age"));
						u.setBirth(rs.getString("birth"));
						
						//������洢��������
						lu.add(u);
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					//�ر���Դ
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				 //���ؽ��
                 return (java.util.List<User>) lu;
	}

	//�û�ע��
	@Override
	public int UserRegDao(User u) {
	    //����jdbc����
		Connection conn=null;
	    PreparedStatement ps=null;
		//��������
	    int index=-1;
	    try {
		//��������
	    Class.forName("com.mysql.jdbc.Driver");
	    
		//��ȡ����
	    conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
	    
		//����SQL����
	    String sql="insert into t_user values(default,?,?,?,?,?)";
	    
		//����SQL�������
	    ps=(PreparedStatement) conn.prepareStatement(sql);
	    
	    //��ռλ����ֵ
	    ps.setString(1, u.getUname());
	    ps.setString(2, u.getPwd());
	    ps.setString(3, u.getSex());
	    ps.setInt(4, u.getAge());
	    ps.setString(5, u.getBirth());
		//ִ��
	    index=ps.executeUpdate();
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}finally {
			//�ر���Դ
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    //���ؽ��
		return index;

     }
  }
