package model;

public class Department {//vo
	public Department() {
		
	}
		private String deptNo;
  //public String deptNo;
	private String deptName;
  //public String deptName;
  
	 //get=불러온다,set=변경한다
	  //this:클래스의자기자신
	public void setDeptNo(String deptNo) {
		//첫번째 순서, 공공의 비어있는 변경한다 DeptNo메소드를(매개변수 문자형 deptNo)
		this.deptNo = deptNo;//자기자신의 deptNo에 deptNo를 복사한다
	}
	public void setDeptName(String deptName) {
		//공공의 비어있는 변경한다 DeptName메소드를(매개변수 문자형 deptName)
		this.deptName = deptName;//자기자신의 deptName에 deptName을 복사한다
	}
	public String getDeptNo() {
		//공공의 문자형 불러온다DeptNo메소드를
		return this.deptNo;//자기자신의 deptNo를 반환
	}
	public String getDeptName() {
		//공공의 문자형 불러온다DeptName메소드를
		return this.deptName;//자기자신의deptNo를 반환
	}
}

