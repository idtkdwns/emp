package model;

public class Department {//vo
	public Department() {
		
	}
		private String deptNo;
  //public String deptNo;
	private String deptName;
  //public String deptName;
  
	 //get=�ҷ��´�,set=�����Ѵ�
	  //this:Ŭ�������ڱ��ڽ�
	public void setDeptNo(String deptNo) {
		//ù��° ����, ������ ����ִ� �����Ѵ� DeptNo�޼ҵ带(�Ű����� ������ deptNo)
		this.deptNo = deptNo;//�ڱ��ڽ��� deptNo�� deptNo�� �����Ѵ�
	}
	public void setDeptName(String deptName) {
		//������ ����ִ� �����Ѵ� DeptName�޼ҵ带(�Ű����� ������ deptName)
		this.deptName = deptName;//�ڱ��ڽ��� deptName�� deptName�� �����Ѵ�
	}
	public String getDeptNo() {
		//������ ������ �ҷ��´�DeptNo�޼ҵ带
		return this.deptNo;//�ڱ��ڽ��� deptNo�� ��ȯ
	}
	public String getDeptName() {
		//������ ������ �ҷ��´�DeptName�޼ҵ带
		return this.deptName;//�ڱ��ڽ���deptNo�� ��ȯ
	}
}

