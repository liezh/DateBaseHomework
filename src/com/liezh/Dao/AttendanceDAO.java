package com.liezh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.DBHelper;
import com.liezh.entity.AttendanceBean;

public class AttendanceDAO {

	public ArrayList<AttendanceBean> getAllAttendance(String strInfo) {
		// TODO Auto-generated method stub
		System.out.println("-------------");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<AttendanceBean> list = new ArrayList<AttendanceBean>(); // 头条集合
		try {
			System.out.print("-------------");
			conn = DBHelper.getConnection();
			String sql = "select * from attendance where " + strInfo + ";"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				AttendanceBean attendanceBean = new AttendanceBean();
				attendanceBean.setAtt_id(rs.getInt("att_id"));
				attendanceBean.setEmp_id(rs.getInt("emp_id"));
				attendanceBean.setTime(rs.getString("time"));
				attendanceBean.setState(rs.getInt("state"));
				list.add(attendanceBean);// 把一条信息加入集合
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
		}
	}

	public boolean addAttendanceInfo(AttendanceBean attendanceBean) {
		
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into attendance(emp_id,time,state) values (" + attendanceBean.getEmp_id() + ",'" + attendanceBean.getTime() + "'," +
			               attendanceBean.getState() + ");"; // SQL语句
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
			
		}
		
	}

	public boolean deleteAttendanceInfo(String att_idStr) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from attendance where att_id="+ att_idStr + ";" ;// SQL语句
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
			
		}
	}
	
	public boolean updateAttendanceInfo(String str, String condition) {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "update attendance set " + str + " where att_id=" + condition + ";" ;// SQL语句
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
			
		}

	}
	
	
	
	

}
