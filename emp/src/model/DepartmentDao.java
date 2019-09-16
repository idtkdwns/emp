package model;
import java.sql. *;

public class DepartmentDao{
  public int insertDepartment(Department department) throws Exception {//������ ������ ����Department�޼ҵ�(�Ű����� ��ü) ���� ó��
	  System.out.println("insertDepartment param");
	  //����غ���
	  DBHelper dbhelper = new DBHelper();
	  //DBHelperŬ���� ��ü���� = ���ο� DBHelper��,��ü
	  Connection conn = dbhelper.getConnection("jdbc:mariadb://127.0.0.1:3306","root", "java1234");
	  //1.DB����, ���� conn��ü������ �ִ´� dbhelperŬ������ �ִ� ��������(�ּ�,id,pw)
	  String sql = "INSERT INTO departments(dept_no,dept_name) VALUES (?,?)";
	  //2.������ �ۼ�,sql�� ����ִ� departments�޼ҵ带 ��(�ΰ�)
	  PreparedStatement stmt=conn.prepareStatement(sql);
	  //3.������ ����, ��ü������ �����Ѵ� �޼ҵ�(�Ű����� sql)
	  
	  //Department department = new Department();
	  //Departmemt.java���� �ҷ��´� *private���ϱ���*
	  stmt.setString(1,department.getDeptName());
	  //4.Ư�������� ù��° ������ Name���� �����´�
	  stmt.setString(2,department.getDeptNo());
	  //4.Ư�������� �ι�° ������ No���� �����´�
	  return 0;
	  //�ǵ����ش� 0����
  }

public Department selectDepartmentOne(String departNo) throws Exception{ 
	  //������ Departmemt.javaŬ������ DepartmentŬ������ �Ѱ����� ����(No��) ����ó��
	  System.out.println("selectDepartment param");
	  DBHelper dbhelper= new DBHelper();
	  //���ο�Ŭ���� ����
	  Connection conn = dbhelper.getConnection("jdbc:mariadb://127.0.0.1:3306","root","java1234");
	  //1.������ ����
	  String sql="SELECT dept_no,dept_name FROM department WHERE dept_no=";
	  //2.������ �ۼ�=���� ���߿� department�κ��� dept_no�� ����
	  PreparedStatement stmt=conn.prepareStatement(sql);
	  //3.������ ����
	  stmt.setString(1,departNo);
	  //4.Ư���� ����
	  ResultSet rs=stmt.executeQuery();
	  //�������� �Է��Ѱ���rs�� ����
	  Department department=null;
	  //Ŭ���� ��ü������ �ƹ��͵� ���� ������ ����
	  if(rs.next()) {
	  //���� ��ȯ�� ���� �����ϴ� ���� ��ġ���� ���� �����̵�
		 department = new Department();
		 //��ü���� = ���ο� DepartmentŬ����
		 //System.out.println();�׽�Ʈ �ڵ�		 
		 department.setDeptNo(rs.getString("deptNo"));
		 //Department.java���� �������� �˷��ش� = ���������� ���� �����´�(set�ֱ���)
		 //Ŭ������������ �����´� DeptNo��(�������� �Է��� ���� �ҷ��´�)
		 department.setDeptName(rs.getString("deptName"));
		 //Department.java���� �������� �˷��ش� = ���������� ���� �����´�(set�ֱ���)
		 //Ŭ������������ �����´� DeptName��(�������� �Է��� ���� �ҷ��´�)

	  }
	  return department;
	  //�����ش� Ŭ���� ������
  	}
}
