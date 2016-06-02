package com.liezh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBHelper;

import com.liezh.entity.Items;
import com.liezh.entity.WagesBean;

public class WagesDAO {

	public ArrayList<WagesBean> getAllWages(String strInfo){
		System.out.println("-------------");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<WagesBean> list = new ArrayList<WagesBean>(); // 头条集合
		try {
			System.out.print("-------------");
			conn = DBHelper.getConnection();
			String sql = "select * from wages where " + strInfo + ";"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				WagesBean wageBean = new WagesBean();
				wageBean.setWage_id(rs.getInt("wage_id"));
				wageBean.setEmp_id(rs.getInt("emp_id"));
				wageBean.setAttendance_id(rs.getInt("attendance_id"));
				wageBean.setAttendSkimp(rs.getDouble("attendSkimp"));
				wageBean.setBasic_wage(rs.getDouble("basic_wage"));
				wageBean.setOt_wage(rs.getDouble("ot_wage"));
				wageBean.setSum_wage(rs.getDouble("sum_wage"));
				wageBean.setInsurance(rs.getDouble("insurance"));
				wageBean.setRealWage(rs.getDouble("realWage"));
				list.add(wageBean);// 把一条信息加入集合
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
	
	
	public boolean updateWagesInfo(String str, String condition) {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "update wages set " + str + " where wage_id=" + condition + ";" ;// SQL语句
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
	
	public boolean deleteWagesInfo(String idStr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "delete from wages where wage_id="+ idStr + ";" ;// SQL语句
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
	
	
	
	
	public boolean addWagesInfo(WagesBean wagesBean) {
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "insert into wages values (" + wagesBean.getWage_id() + "," + wagesBean.getEmp_id() + "," +
			               wagesBean.getAttendance_id() + "," + wagesBean.getAttendSkimp() + "," + wagesBean.getBasic_wage() + ","
			               + wagesBean.getOt_wage() + "," + wagesBean.getSum_wage() + "," + wagesBean.getInsurance() + "," + wagesBean.getRealWage() + ");"; // SQL语句
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


	public Double getAttendanceVlue(String strInfo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		double attendSkimpDouble = 0.0; // 头条集合
		try {
			System.out.print("-------------");
			conn = DBHelper.getConnection();
			String sql = "select * from wages where " + strInfo + ";"; // SQL语句
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			attendSkimpDouble = rs.getDouble("attendSkimp");
		}catch (Exception e) {
			return 0.0;
		}
		
		return attendSkimpDouble;
	}
}
