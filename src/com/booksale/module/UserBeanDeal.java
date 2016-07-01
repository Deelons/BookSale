package com.booksale.module; 

import oracle.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class UserBeanDeal {
	
	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public static final String url = "jdbc:oracle:thin:@localhost:BookSale:1521";
	public static final String user="BOOKSALE";
	public static final String password="localhost";
	
	private ArrayList<UserBean> al = new ArrayList<UserBean>();
	private ArrayList<UserBean> al2 = new ArrayList<UserBean>();
	
	//�����ݿ��������ж�ȡ��������Ϣ������ӵ�ArrayList��
	public ArrayList getResult() {
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("select * from ������");	
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserBean ub = new UserBean();
				ub.setPublisherNumber(rs.getString(1));
				ub.setPublisherName(rs.getString(2));
				ub.setPublisherPhone(rs.getString(3));
				ub.setZipCode(rs.getString(4));
				ub.setWebsite(rs.getString(5));
				ub.setPublisherCity(rs.getString(6));
				ub.setPublisherAddress(rs.getString(7));
				
				al.add(ub);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			this.close();
		}	
		
		return al;
	}
	//���ҳ�ĳ��������Ϣ
	
	public ArrayList getAPublisher(String id) {
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			String sql = "select * from ������ WHERE \"PublisherNumber\" = '"+ id +"' ";//��ѯ�ƶ�PublisherNumber��¼
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserBean ub = new UserBean();
				ub.setPublisherNumber(rs.getString(1));
				ub.setPublisherName(rs.getString(2));
				ub.setPublisherPhone(rs.getString(3));
				ub.setZipCode(rs.getString(4));
				ub.setWebsite(rs.getString(5));
				ub.setPublisherCity(rs.getString(6));
				ub.setPublisherAddress(rs.getString(7));
				
				al2.add(ub);
				System.out.println(((UserBean)al.get(1)).getPublisherNumber());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return al2;
	}
	//�޸ĳ�������Ϣ
	public boolean updatePublisher(String id1,String id,String name,String phone,String zipcode,String website,String city,String addr) {
		boolean b = false;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			String sql = "update ������ set \"PublisherNumber\" = '"+ id +"',\"PublisherName\" = '"+ name +"',\"PublisherPhone\" = '"+ phone +"',\"ZipCode\" = '"+ zipcode +"',\"WebSite\" = '"+ website + "',\"PublisherCity\" = '"+ city +"',\"PublisherAddress\" = '"+ addr +"' where \"PublisherNumber\" = '"+ id1 +"'";//�޸ĳ�������Ϣ���
			ps = ct.prepareStatement(sql);
			ps.executeUpdate();
			
			if(ps.executeUpdate()!=0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
		
	}
	//���ӳ�������Ϣ
	public boolean addPublisher(String id,String name,String phone,String zipcode,String website,String city,String addr) {
		boolean b = false;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			String sql = "Insert into ������ values('" + id + "','"+ name +"','"+ phone + "','"+ zipcode +"','"+ website +"','"+ city +"','"+ addr +"')";//���ӳ�������Ϣsql���
			ps = ct.prepareStatement(sql);
			if(ps.executeUpdate() != 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return b;
	}
	
	//ɾ���û�
	public boolean delPublisher(String id) {
		boolean b = false;
		
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			
			String sql = "delete from ������ where \"PublisherNumber\"='"+ id +"'";//ɾ��ָ��PublisherNumber�ļ�¼
			ps = ct.prepareStatement(sql);	
			if(ps.executeUpdate() != 0) {
				b = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	
	
	//���ݿ�ͨ���رշ���
	public void close() {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			
			if(ps != null) {
				ps.close();
				ps = null;
			}
			
			if(ct != null) {
				ct.close();
				ct = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
