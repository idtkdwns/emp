package model;

public class Employees {//vo
	public Employees() {
		
	}
  private int empNo;//�ڱ� �ڽ��� Ŭ���� �ȿ����� ���ٰ���
  private String birthDate;
  private String firstName;
  private String lastName;
  private String gender;
  private String hireDate;
  //get=�ҷ��´�,set=�����Ѵ�
  //this:Ŭ�������ڱ��ڽ�
  public void setEmpNo(int empNo) { //ù��°����,������ ����ִ� �����Ѵ�EmpNo�޼ҵ带(�Ű�����int empNo)
	  this.empNo = empNo;//�ڱ��ڽ���. empNo�� empNo�� ���� �����ߴ� 
	  }
  public void setBirthDate(String birthDate) {//������ ����ִ� �����Ѵ�BirthDate�޼ҵ带(�Ű����� ������ birthDate)
	  this.birthDate = birthDate;//�ڱ��ڽ���.birthDate�� birthDate�� ���� �����ߴ�
	  }  
  public void setfirstName(String firstName) {//������ ����ִ� �����Ѵ�firstName�޼ҵ带(�Ű����� ������ firstName)
	  this.firstName = firstName;//�ڱ��ڽ���.firstName�� firstName�� ���� �����ߴ�
	  }
  public void setlastName(String lastName) {//������ ����ִ� �����Ѵ� lastName�޼ҵ带(�Ű����� ������ lastName)
	  this.lastName = lastName;//�ڱ��ڽ���.lastName�� ���� �����ߴ�
	  }
  public void setgender(String gender) {//������ ����ִ� �����Ѵ�gender�޼ҵ带(�Ű����� ������ gender)
	  this.gender = gender;//�ڱ��ڽ���.gender�� ���� �����ߴ�
	  }
  public void sethireDate(String hireDate) {//������ ����ִ� �����Ѵ�hireDate�޼ҵ带(�Ű����� ������ hireDate)
	  this.hireDate = hireDate;//�ڱ��ڽ���.hireDate�� ���� �����ߴ�
	  }
  public int getEmpNo() {//�ι�°����,������ ���� �ҷ��´�EmpNo�޼ҵ带
	  return this.empNo; //�ڱ��ڽ���. empNo�� ��ȯ
	  }  
  public String getBirthDate() {//������ ������ �ҷ�����BirthDate�޼ҵ带
	  return this.birthDate;//�ڱ��ڽ��� .birthDate�� ��ȯ
	  }  
  public String getfirstName() {//������ ������ �ҷ��´�firsName�޼ҵ带
	  return this.firstName;//�ڱ��ڽ���.firstName�� ��ȯ
	  }
 public String getlastName() {//������ ������ �ҷ��´�lastName�޼ҵ带
	  return this.lastName;//�ڱ��ڽ���.lastName�� ��ȯ
	  }
 public String getgender() {//������ ������ �ҷ��´�gender�޼ҵ带
	  return this.gender;//�ڱ��ڽ���.gender�� ��ȯ
	  }
 public String gethireDate() {//�����Ǥ� ������ �ҷ��´�hireDate�޼ҵ带
	  return this.hireDate;//�ڱ��ڽ���.hireDate����ȯ
 	}
}
