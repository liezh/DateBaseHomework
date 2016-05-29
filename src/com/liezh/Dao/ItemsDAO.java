package com.liezh.Dao;

import java.sql.*;
import java.util.ArrayList;
import util.DBHelper;
import com.liezh.entity.*;



public class ItemsDAO {
	public ItemsDAO(){
//		System.out.print("fdsfdsaffsdfdsfd");
	}

	public ArrayList<Items> getAllItems(String strInfo){
		System.out.println("-------------");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>(); // 头条集合
		try {
			System.out.print("-------------");
			conn = DBHelper.getConnection();
			String sql = "select * from employeesinfo where " + strInfo + ";"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setPersonalID(rs.getLong("personalID"));
				item.setName(rs.getString("name"));
				item.setSex(rs.getString("sex"));
				item.setAge(rs.getInt("age"));
				item.setMarriage(rs.getString("marriage"));
				item.setEducation(rs.getString("education"));
				item.setTitle(rs.getString("title"));
				item.setAddress(rs.getString("address"));
				item.setPhoneNum(rs.getLong("phoneNum"));
				list.add(item);// 把一条信息加入集合
				i++;
			}
			System.out.print("-------------"+ i);
			return list; // 返回集合。
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	
	public boolean getLoginSuccess(String username,String password){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		System.out.println(username+"---"+password);
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from user where username='"+ username +"' and " + "password='" + password + "';"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString("username") + "@@@@" + rs.getString("password"));
				return true;
			}
			System.out.println("this false");
			return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("this false");
			return false;
		} finally{
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
		}
	}

	public boolean addEmployeersInfo(Items item) {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into employeesinfo values (" + item.getId() + "," + item.getPersonalID() + ",'" +
			               item.getName() + "'," + item.getAge() + ",'" + item.getSex() + "','" + item.getMarriage() + "','" +
			              item.getEducation() + "','" + item.getSchool() + "','" + item.getTitle() + "','" + item.getAddress()
			              + "'," + item.getPhoneNum() + ");"; // SQL语句
			stmt = conn.createStatement();
			int m = 0;
			try {
				m = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
				return false;
			}
			if(m == 1){
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally{
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
		}
	}
	
	
	
}
