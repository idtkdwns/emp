package model;

public class Employees {//vo
	public Employees() {
		
	}
  private int empNo;//자기 자신의 클래스 안에서만 접근가능
  private String birthDate;
  private String firstName;
  private String lastName;
  private String gender;
  private String hireDate;
  //get=불러온다,set=변경한다
  //this:클래스의자기자신
  public void setEmpNo(int empNo) { //첫번째순서,공공의 비어있는 변경한다EmpNo메소드를(매개변수int empNo)
	  this.empNo = empNo;//자기자신의. empNo에 empNo의 값을 복사했다 
	  }
  public void setBirthDate(String birthDate) {//공공의 비어있는 변경한다BirthDate메소드를(매개변수 문자형 birthDate)
	  this.birthDate = birthDate;//자기자신의.birthDate에 birthDate의 값을 복사했다
	  }  
  public void setfirstName(String firstName) {//공공의 비어있는 변경한다firstName메소드를(매개변수 문자형 firstName)
	  this.firstName = firstName;//자기자신의.firstName에 firstName의 값을 복사했다
	  }
  public void setlastName(String lastName) {//공공의 비어있는 변경한다 lastName메소드를(매개변수 문자형 lastName)
	  this.lastName = lastName;//자기자신의.lastName의 값을 복사했다
	  }
  public void setgender(String gender) {//공공의 비어있는 변경한다gender메소드를(매개변수 문자형 gender)
	  this.gender = gender;//자기자신의.gender의 값을 복사했다
	  }
  public void sethireDate(String hireDate) {//공공의 비어있는 변경한다hireDate메소드를(매개변수 문자형 hireDate)
	  this.hireDate = hireDate;//자기자신의.hireDate의 값을 복사했다
	  }
  public int getEmpNo() {//두번째순서,공공의 정수 불러온다EmpNo메소드를
	  return this.empNo; //자기자신의. empNo를 반환
	  }  
  public String getBirthDate() {//공공의 문자형 불러오다BirthDate메소드를
	  return this.birthDate;//자기자신의 .birthDate를 반환
	  }  
  public String getfirstName() {//공공의 문자형 불러온다firsName메소드를
	  return this.firstName;//자기자신의.firstName를 반환
	  }
 public String getlastName() {//공공의 문자형 불러온다lastName메소드를
	  return this.lastName;//자기자신의.lastName를 반환
	  }
 public String getgender() {//공공의 문자형 불러온다gender메소드를
	  return this.gender;//자기자신의.gender를 반환
	  }
 public String gethireDate() {//공공의ㅣ 문자형 불러온다hireDate메소드를
	  return this.hireDate;//자기자신의.hireDate를반환
 	}
}
