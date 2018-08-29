package com.encore.domain;

public class EmpVO {
	private String empno;
	private String ename;
	private String sal;
	private String deptno;
	
	public EmpVO() {
		// TODO Auto-generated constructor stub
	}

	public EmpVO(String empno, String ename, String sal, String deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", deptno=" + deptno + "]";
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	
}
