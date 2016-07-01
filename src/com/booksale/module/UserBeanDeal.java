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
	
	//从数据库出版社表中读取出版社信息，并添加到ArrayList中
	public ArrayList getResult() {
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			ps = ct.prepareStatement("select * from 出版社");	
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
	//查找出某出版社信息
	
	public ArrayList getAPublisher(String id) {
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			String sql = "select * from 出版社 WHERE \"PublisherNumber\" = '"+ id +"' ";//查询制定PublisherNumber记录
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
	//修改出版社信息
	public boolean updatePublisher(String id1,String id,String name,String phone,String zipcode,String website,String city,String addr) {
		boolean b = false;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			String sql = "update 出版社 set \"PublisherNumber\" = '"+ id +"',\"PublisherName\" = '"+ name +"',\"PublisherPhone\" = '"+ phone +"',\"ZipCode\" = '"+ zipcode +"',\"WebSite\" = '"+ website + "',\"PublisherCity\" = '"+ city +"',\"PublisherAddress\" = '"+ addr +"' where \"PublisherNumber\" = '"+ id1 +"'";//修改出版社信息语句
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
	//增加出版社信息
	public boolean addPublisher(String id,String name,String phone,String zipcode,String website,String city,String addr) {
		boolean b = false;
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			String sql = "Insert into 出版社 values('" + id + "','"+ name +"','"+ phone + "','"+ zipcode +"','"+ website +"','"+ city +"','"+ addr +"')";//增加出版社信息sql语句
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
	
	//删除用户
	public boolean delPublisher(String id) {
		boolean b = false;
		
		try {
			ConnDB cd = new ConnDB();
			ct = cd.getConn();
			
			String sql = "delete from 出版社 where \"PublisherNumber\"='"+ id +"'";//删除指定PublisherNumber的记录
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
	
	
	//数据库通道关闭方法
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
