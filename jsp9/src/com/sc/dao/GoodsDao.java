package com.sc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Goods;

public class GoodsDao {

	    //定义数据库访问的对象
		Connection conn=null;//连接对象
		PreparedStatement ps=null;//预编译陈述对象
		ResultSet rs=null;//结果集对象 
		
		//定义数据库连接信息
		String url="jdbc:mysql://localhost:3306/db1904";//url地址
		String user="root";//用户名
		String password="root";//密码

		//添加方法
		public void add(Goods g){
			try {
			    //1、加载注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("加载注册成功成功！");
				//2、通过 驱动管理器 获取 连接对象
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("连接数据库成功！");
				//3、通过 连接对象 获取 预编译陈述对象
				String sql="insert into goods values(null,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, g.getGname());
				ps.setFloat(2, g.getGprice());
				ps.setInt(3, g.getBuynum());
				ps.setInt(4, g.getGnum());
				ps.setString(5, g.getGpic());
				//4、通过 预编译陈述对象  执行sql语句
				ps.executeUpdate();
				System.out.println("添加商品成功！");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("加载注册驱动失败！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("连接数据库失败！");
			} finally {
				    //5、关闭所有资源
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("关闭资源成功！");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("关闭资源失败！");
					}
			}
		}
		
		//修改方法
		public void update(Goods g){
			try {
			    //1、加载注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("加载注册成功成功！");
				//2、通过 驱动管理器 获取 连接对象
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("连接数据库成功！");
				//3、通过 连接对象 获取 预编译陈述对象
				String sql="update goods set gname=?,gprice=?,"
						+ "buynum=?,gnum=?,gpic=? where gid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, g.getGname());
				ps.setFloat(2, g.getGprice());
				ps.setInt(3, g.getBuynum());
				ps.setInt(4, g.getGnum());
				ps.setString(5, g.getGpic());
				ps.setInt(6, g.getGid());
				//4、通过 预编译陈述对象  执行sql语句
				ps.executeUpdate();
				System.out.println("修改商品成功！");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("加载注册驱动失败！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("连接数据库失败！");
			} finally {
				    //5、关闭所有资源
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("关闭资源成功！");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("关闭资源失败！");
					}
			}
		}
		
		//删除方法
		public void delete(int gid){
			try {
			    //1、加载注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("加载注册成功成功！");
				//2、通过 驱动管理器 获取 连接对象
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("连接数据库成功！");
				//3、通过 连接对象 获取 预编译陈述对象
				String sql="delete from goods where gid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, gid);
				//4、通过 预编译陈述对象  执行sql语句
				ps.executeUpdate();
				System.out.println("删除商品成功！");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("加载注册驱动失败！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("连接数据库失败！");
			} finally {
				    //5、关闭所有资源
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("关闭资源成功！");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("关闭资源失败！");
					}
			}
		}
		
		//查询方法
		public List<Goods> select(){
			List<Goods> list=new ArrayList<Goods>();
			try {
			    //1、加载注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("加载注册成功成功！");
				//2、通过 驱动管理器 获取 连接对象
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("连接数据库成功！");
				//3、通过 连接对象 获取 预编译陈述对象
				String sql="select * from goods";
				ps=conn.prepareStatement(sql);
				//4、通过 预编译陈述对象  执行sql语句 返回结果集
				rs=ps.executeQuery();
				//5、处理结果集
				while(rs!=null&&rs.next()){//是否有下一行
					//表的每一行封装成一个商品对象
					Goods g=new Goods();
					g.setGid(rs.getInt("gid"));
					g.setGname(rs.getString("gname"));
					g.setGprice(rs.getFloat("gprice"));
					g.setBuynum(rs.getInt("buynum"));
					g.setGnum(rs.getInt("gnum"));
					g.setGpic(rs.getString("gpic"));
				    //每个商品对象存入集合
					list.add(g);
				}
				System.out.println("查询商品成功！");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("加载注册驱动失败！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("连接数据库失败！");
			} finally {
				    //6、关闭所有资源
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("关闭资源成功！");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("关闭资源失败！");
					}
			}
			
			return list;
		}
		
		//获取对象方法
		public Goods get(int gid){
			Goods g=new Goods();
			try {
			    //1、加载注册驱动
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("加载注册成功成功！");
				//2、通过 驱动管理器 获取 连接对象
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("连接数据库成功！");
				//3、通过 连接对象 获取 预编译陈述对象
				String sql="select * from goods where gid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, gid);
				//4、通过 预编译陈述对象  执行sql语句 返回结果集
				rs=ps.executeQuery();
				//5、处理结果集
				while(rs!=null&&rs.next()){//是否有下一行
					//封装成一个商品对象
					g.setGid(rs.getInt("gid"));
					g.setGname(rs.getString("gname"));
					g.setGprice(rs.getFloat("gprice"));
					g.setBuynum(rs.getInt("buynum"));
					g.setGnum(rs.getInt("gnum"));
					g.setGpic(rs.getString("gpic"));
				}
				System.out.println("获取商品成功！");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("加载注册驱动失败！");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("连接数据库失败！");
			} finally {
				    //6、关闭所有资源
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("关闭资源成功！");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("关闭资源失败！");
					}
			}
			
			return g;
		}	
	
}
