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
    //根据用户名和密码查询用户信息
	@Override
	public User CheckUserLoginDao(String uname, String pwd) {
		
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;//PreparedStatement是java.sql包下面的一个接口，用来执行SQL语句查询，
		                          //通过调用connection.preparedStatement(sql)方法可以获得PreparedStatment对象。
		ResultSet rs=null;
		//声明变量
		User u=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//获取连接
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
			
			//创建sql命令
			String sql="select*from t_user where uname=? and pwd=?";
			
			//创建sql命令对象
			ps=(PreparedStatement) conn.prepareStatement(sql);
			
			//给占位符赋值
			ps.setString(1, uname); //setString(x,y)括号内的参数对应Sql中的位置和值，第一个参数为几就是指第几个问号，第二个参数就是要填入问号位置的值，即要查询的数据表的字段名。
			                        //eg：SQL = &amp;quot;select * from login_info where username = ? and password = ?&amp;quot;; pstmt.setString(1, username); pstmt.setString(2, password);
			                       //把username写到第一个问号， 把psssword填入第二个问号
			ps.setString(2, pwd);
			
			//执行sql
			rs=ps.executeQuery();
			/* 使用JDBC连接数据库需要四步，第一步加载驱动程序；第二步，连接数据库；第三步，访问数据库；第四步，执行查询；
			 * 其中在第四步执行查询时，要用statement类的executeQuery()方法来下达select指令以查询数据库，
			 * executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。
			 * 即语句：String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);*/
			
			//遍历结果
			while(rs.next()) {
				//给变量赋值
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
			//关闭资源
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
		
		//返回结果
		return u;
	}

	//根据用户ID修改用户密码
	@Override
	public int UserChangePwdDao(String newPwd, int uid) {
		// TODO Auto-generated method stub
		//声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		//创建变量
		int index=-1;
		try {
		//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		//获取连接
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
		//创建SQL命令
			String sql="update t_user set pwd=? where uid=?";
		//创建SQL命令对象
			ps=(PreparedStatement) conn.prepareStatement(sql);
		//给占位符赋值
			ps.setString(1,newPwd);
			ps.setInt(2,uid);
		//执行
			index=ps.executeUpdate();//方法executeUpdate() 用于执行已发送的预编译的sql 并返回执行成功的记录的条数 int

	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		//关闭资源
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
		//返回结果
		return index;
	}

	//获取所有用户信息
	@Override
	public java.util.List<User> UserShowDao() {
		// TODO Auto-generated method stub
		//声明jdbc对象
				Connection conn=null;
				PreparedStatement ps=null;//PreparedStatement是java.sql包下面的一个接口，用来执行SQL语句查询，
				                          //通过调用connection.preparedStatement(sql)方法可以获得PreparedStatment对象。
				ResultSet rs=null;
				//声明变量
			    java.util.List<User> lu=null;
				try {
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					
					//获取连接
					conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
					
					//创建sql命令
					String sql="select*from t_user";
					
					//创建sql命令对象
					ps=(PreparedStatement) conn.prepareStatement(sql);
					
					//执行sql
					rs=ps.executeQuery();
					/* 使用JDBC连接数据库需要四步，第一步加载驱动程序；第二步，连接数据库；第三步，访问数据库；第四步，执行查询；
					 * 其中在第四步执行查询时，要用statement类的executeQuery()方法来下达select指令以查询数据库，
					 * executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。
					 * 即语句：String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);*/
					
					//给集合赋值
					lu=(java.util.List<User>) new ArrayList<User>();
					//遍历结果
					while(rs.next()) {
						//给变量赋值
						User u=new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
						u.setSex(rs.getString("sex"));
						u.setAge(rs.getInt("age"));
						u.setBirth(rs.getString("birth"));
						
						//将对象存储到集合中
						lu.add(u);
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					//关闭资源
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
				
				 //返回结果
                 return (java.util.List<User>) lu;
	}

	//用户注册
	@Override
	public int UserRegDao(User u) {
	    //声明jdbc对象
		Connection conn=null;
	    PreparedStatement ps=null;
		//声明变量
	    int index=-1;
	    try {
		//加载驱动
	    Class.forName("com.mysql.jdbc.Driver");
	    
		//获取连接
	    conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hsx02","root","MYSQL123");
	    
		//创建SQL命令
	    String sql="insert into t_user values(default,?,?,?,?,?)";
	    
		//创建SQL命令对象
	    ps=(PreparedStatement) conn.prepareStatement(sql);
	    
	    //给占位符赋值
	    ps.setString(1, u.getUname());
	    ps.setString(2, u.getPwd());
	    ps.setString(3, u.getSex());
	    ps.setInt(4, u.getAge());
	    ps.setString(5, u.getBirth());
		//执行
	    index=ps.executeUpdate();
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}finally {
			//关闭资源
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
	    //返回结果
		return index;

     }
  }
