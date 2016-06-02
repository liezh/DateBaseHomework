package com.liezh.entity;

public class WagesBean {

	private int wage_id;
	private int emp_id;
	private int attendance_id;
	private double attendSkimp;
	private double basic_wage;
	private double ot_wage;
	private double sum_wage;
	private double insurance;
	private double realWage;
	
	public WagesBean(){
		
	}
	
	public int getWage_id() {
		return wage_id;
	}
	public void setWage_id(int wage_id) {
		this.wage_id = wage_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getAttendance_id() {
		return attendance_id;
	}
	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}
	public double getAttendSkimp() {
		return attendSkimp;
	}
	public void setAttendSkimp(double attendSkimp) {
		this.attendSkimp = attendSkimp;
	}
	public double getBasic_wage() {
		return basic_wage;
	}
	public void setBasic_wage(double basic_wage) {
		this.basic_wage = basic_wage;
	}
	public double getOt_wage() {
		return ot_wage;
	}
	public void setOt_wage(double ot_wage) {
		this.ot_wage = ot_wage;
	}
	public double getSum_wage() {
		return sum_wage;
	}
	public void setSum_wage(double sum_wage) {
		this.sum_wage = sum_wage;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	public double getRealWage() {
		return realWage;
	}
	public void setRealWage(double realWage) {
		this.realWage = realWage;
	}
	
	
	
}
