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

	    //�������ݿ���ʵĶ���
		Connection conn=null;//���Ӷ���
		PreparedStatement ps=null;//Ԥ�����������
		ResultSet rs=null;//��������� 
		
		//�������ݿ�������Ϣ
		String url="jdbc:mysql://localhost:3306/db1904";//url��ַ
		String user="root";//�û���
		String password="root";//����

		//��ӷ���
		public void add(Goods g){
			try {
			    //1������ע������
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("����ע��ɹ��ɹ���");
				//2��ͨ�� ���������� ��ȡ ���Ӷ���
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ���");
				//3��ͨ�� ���Ӷ��� ��ȡ Ԥ�����������
				String sql="insert into goods values(null,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, g.getGname());
				ps.setFloat(2, g.getGprice());
				ps.setInt(3, g.getBuynum());
				ps.setInt(4, g.getGnum());
				ps.setString(5, g.getGpic());
				//4��ͨ�� Ԥ�����������  ִ��sql���
				ps.executeUpdate();
				System.out.println("�����Ʒ�ɹ���");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("����ע������ʧ�ܣ�");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�������ݿ�ʧ�ܣ�");
			} finally {
				    //5���ر�������Դ
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("�ر���Դ�ɹ���");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("�ر���Դʧ�ܣ�");
					}
			}
		}
		
		//�޸ķ���
		public void update(Goods g){
			try {
			    //1������ע������
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("����ע��ɹ��ɹ���");
				//2��ͨ�� ���������� ��ȡ ���Ӷ���
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ���");
				//3��ͨ�� ���Ӷ��� ��ȡ Ԥ�����������
				String sql="update goods set gname=?,gprice=?,"
						+ "buynum=?,gnum=?,gpic=? where gid=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, g.getGname());
				ps.setFloat(2, g.getGprice());
				ps.setInt(3, g.getBuynum());
				ps.setInt(4, g.getGnum());
				ps.setString(5, g.getGpic());
				ps.setInt(6, g.getGid());
				//4��ͨ�� Ԥ�����������  ִ��sql���
				ps.executeUpdate();
				System.out.println("�޸���Ʒ�ɹ���");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("����ע������ʧ�ܣ�");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�������ݿ�ʧ�ܣ�");
			} finally {
				    //5���ر�������Դ
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("�ر���Դ�ɹ���");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("�ر���Դʧ�ܣ�");
					}
			}
		}
		
		//ɾ������
		public void delete(int gid){
			try {
			    //1������ע������
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("����ע��ɹ��ɹ���");
				//2��ͨ�� ���������� ��ȡ ���Ӷ���
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ���");
				//3��ͨ�� ���Ӷ��� ��ȡ Ԥ�����������
				String sql="delete from goods where gid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, gid);
				//4��ͨ�� Ԥ�����������  ִ��sql���
				ps.executeUpdate();
				System.out.println("ɾ����Ʒ�ɹ���");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("����ע������ʧ�ܣ�");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�������ݿ�ʧ�ܣ�");
			} finally {
				    //5���ر�������Դ
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("�ر���Դ�ɹ���");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("�ر���Դʧ�ܣ�");
					}
			}
		}
		
		//��ѯ����
		public List<Goods> select(){
			List<Goods> list=new ArrayList<Goods>();
			try {
			    //1������ע������
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("����ע��ɹ��ɹ���");
				//2��ͨ�� ���������� ��ȡ ���Ӷ���
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ���");
				//3��ͨ�� ���Ӷ��� ��ȡ Ԥ�����������
				String sql="select * from goods";
				ps=conn.prepareStatement(sql);
				//4��ͨ�� Ԥ�����������  ִ��sql��� ���ؽ����
				rs=ps.executeQuery();
				//5����������
				while(rs!=null&&rs.next()){//�Ƿ�����һ��
					//���ÿһ�з�װ��һ����Ʒ����
					Goods g=new Goods();
					g.setGid(rs.getInt("gid"));
					g.setGname(rs.getString("gname"));
					g.setGprice(rs.getFloat("gprice"));
					g.setBuynum(rs.getInt("buynum"));
					g.setGnum(rs.getInt("gnum"));
					g.setGpic(rs.getString("gpic"));
				    //ÿ����Ʒ������뼯��
					list.add(g);
				}
				System.out.println("��ѯ��Ʒ�ɹ���");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("����ע������ʧ�ܣ�");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�������ݿ�ʧ�ܣ�");
			} finally {
				    //6���ر�������Դ
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("�ر���Դ�ɹ���");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("�ر���Դʧ�ܣ�");
					}
			}
			
			return list;
		}
		
		//��ȡ���󷽷�
		public Goods get(int gid){
			Goods g=new Goods();
			try {
			    //1������ע������
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("����ע��ɹ��ɹ���");
				//2��ͨ�� ���������� ��ȡ ���Ӷ���
				conn=DriverManager.getConnection(url, user, password);
				System.out.println("�������ݿ�ɹ���");
				//3��ͨ�� ���Ӷ��� ��ȡ Ԥ�����������
				String sql="select * from goods where gid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, gid);
				//4��ͨ�� Ԥ�����������  ִ��sql��� ���ؽ����
				rs=ps.executeQuery();
				//5����������
				while(rs!=null&&rs.next()){//�Ƿ�����һ��
					//��װ��һ����Ʒ����
					g.setGid(rs.getInt("gid"));
					g.setGname(rs.getString("gname"));
					g.setGprice(rs.getFloat("gprice"));
					g.setBuynum(rs.getInt("buynum"));
					g.setGnum(rs.getInt("gnum"));
					g.setGpic(rs.getString("gpic"));
				}
				System.out.println("��ȡ��Ʒ�ɹ���");
			} catch (ClassNotFoundException e) {
				//e.printStackTrace();
				System.out.println("����ע������ʧ�ܣ�");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�������ݿ�ʧ�ܣ�");
			} finally {
				    //6���ر�������Դ
					try {
						if(rs!=null)rs.close();
						if(ps!=null)ps.close();
						if(conn!=null)conn.close();
						System.out.println("�ر���Դ�ɹ���");
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("�ر���Դʧ�ܣ�");
					}
			}
			
			return g;
		}	
	
}
