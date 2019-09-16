package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeesDao{	
  public int insertEmployees(Employees employees) throws Exception {//�������÷�����޼ҵ�(�Ű����� ��ü) ���� ó��
    System.out.println("insertemployees param");
    //��� ���÷�������� �Ű�����
    DBHelper dbHelper = new DBHelper();
    //DBHelperŬ���� ��ü���� = ���ο�Ŭ����
    Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
    //���� conn��ü������ �ִ´� dbHelperŬ������ �ִµ���̹����� �����´�(url,id,pw) 1.����
    String sql = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES (?,?)";
    //���ڿ�sql�� ����ִ´� employees�޼ҵ带 ��(?,?) 2.�������ۼ�
    PreparedStatement stmt = conn.prepareStatement(sql);
    //��ü�����������Ѵ� �޼ҵ�(�Ű�����)3.����
    stmt.setInt(1, employees.getEmpNo());
    //ù��°������no�������´� 4.Ư�� �� ����
    stmt.setString(2, employees.getfirstName());
    //�ι�°������ ���������´�4.Ư�� �� ����
    return 0;
    //�ǵ����ش�0����
  }

  public Employees selectEmployeesOne(int empNo) throws Exception {//setter/getter �ǽ�
	  //Employees.javaŬ������ ������ EmployeesŬ������ �Ѱ��� ����(������ no��) ����ó��
    System.out.println("selectemployees param");
    //��� ���÷�������� �Ű�����
    DBHelper dbHelper = new DBHelper();
    //DBHelperŬ���� ��ü���� �� DBHelper Ŭ��������, new:��ü�� �������ִ� �r��
    Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
    //���� conn��ü������ �ִ´� dbHelperŬ������ �ִµ���̹����� �����´�(url,id,pw)//1.������ ����
    String sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees WHERE emp_no=?";
    //���ڿ� sql�� employees���� ���� no�Ǽ���//2.������ �ۼ�
    PreparedStatement stmt = conn.prepareStatement(sql);
    //��ü�����������Ѵ� �޼ҵ�(�Ű�����)//3.����
    //PreparedStatement=�̹��ִ°ɰ�����sql���� ��Ÿ���� ��ü
    stmt.setInt(1, empNo);
    //ù��° ������ no�������´�//4.Ư�� �� ����
    ResultSet rs = stmt.executeQuery();
    // ���������Է��� ���� rs������.��������,�ϳ��� rs�� ����µ� ���
    Employees employees = null;
    //EmployeesŬ���� ��ü������ �ƹ��͵�����(null)�����μ���
    if (rs.next()) {
      //���� ��ȯ�� ���������ϴ� ���� ��ġ���� ���� ���� �̵��Ѵ�.
      employees = new Employees();
      //��ü���� = ���ο� EmpŬ���� ����
      //employees��ü������ EmployeesŬ��������, new=��ü���������ִ� ����
      //System.out.println();�׽�Ʈ�ڵ�
      employees.setEmpNo(rs.getInt("emp_no"));
      //Ŭ���� �������������´�EmpNo��(���������Է��� ���� �ҷ��´�(������ no��))
      employees.setBirthDate(rs.getString("birth_date"));
      //Ŭ���� �������� �����´�BirthDate��(�������� �Է��Ѱ��� �ҷ��´� (������birth_date��))
      employees.setfirstName(rs.getString("first_name"));
      //Ŭ���� �������� �����´�firstName��(�������� �Է��� ���� �ҷ��´�(������ first_name(��)��))
      employees.setlastName(rs.getString("last_name"));
      //Ŭ���� �������� �����´� lastName��(�������� �Է��� ���� �ҷ��´�(������ last_name(�̸�)��))
      employees.setgender(rs.getString("gender"));
      //Ŭ���� �������� �����´� gender��(�������� �Է��� ���� �ҷ��´�(������ gender(����)��))
      employees.sethireDate(rs.getString("hire_date"));
      //Ŭ���� �������� �����´� hireDate��(�������� �Է��� ���� �ҷ��´�(������ hire_date(��볯¥)��))
    }
    return employees;//�ǵ����ش� Ŭ����������
  }
  public void deleteEmployees(int empNo) throws Exception{
	  //���� �޼ҵ�,����ó��
	  DBHelper dbHelper = new DBHelper();
	  //DBHelperŬ������ü������ ���ο�DBHelperŬ��������
	  String driver ="jdbc:mariadb://127.0.0.1:3306/employees";
	  String dbid="root";
	  String dbpw="java1234";
	  Connection conn= dbHelper.getConnection(driver, dbid, dbpw);
	  //1.������ ����, db���ᵿ��
	  String sql="DELETE FROM employees WHERE emp_no=?";
	  //2.������ �ۼ�,sql�� employees���� emp_no�� ���°�������Ѵ�
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  //3.����,��ü������ �����Ѵ� �޼ҵ�(�Ű�����)
	  stmt.setInt(1,empNo);
	  //4.Ư���� ����,ù��° ������ empNo�� �����´�
	  stmt.executeQuery();
	  //��ȯ�� ���ص��Ǵ� Result�� ����,��������
  }
  public void updateEmployees(Employees employees)throws Exception{
	  //������Ʈ,����ó��
	  DBHelper dbHelper= new DBHelper();
	  //DBHelperŬ������ü������ ���ο�DBHelperŬ��������
	  String driver="jdbc:mariadb://127.0.0.1:3306/employees";
	  String dbid="root";
	  String dbpw="java1234";
	  Connection conn= dbHelper.getConnection(driver, dbid, dbpw);
	  //1.������ ����
	  String sql="UPDATE FROM employees SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?";
	  //2.�������ۼ�=employees������Ʈ ���� �÷����κ��� �������ϴ� ��ȣ�� �÷��� �ְڴ�
	  PreparedStatement stmt= conn.prepareStatement(sql);
	  //3.������ ����
	  stmt.setString(1,employees.getBirthDate());
	  //4.Ư���� ����
	  stmt.setString(2,employees.getfirstName());
	  stmt.setString(3,employees.getlastName());
	  stmt.setString(4,employees.getgender());
	  stmt.setString(5,employees.gethireDate());
	  stmt.setInt(6,employees.getEmpNo());
	  //���°������ emp...�� �����Ѵ�
	  System.out.println(stmt);
	  //Ȯ�����
	  stmt.executeUpdate();
	  //����� ���� ��������Ÿ��
	  conn.close();
	  //������ �ݴ´�
  }
  public ArrayList<Employees>selectEmployeesList(int rowPerPage, int currentPage) throws Exception {
	ArrayList<Employees> list = new ArrayList<Employees>();
	System.out.println("currentPage:"+currentPage);
	System.out.println("rowPerpage:"+rowPerPage);
	//���Ȯ��
	//int beginRow =(currentPage-1)*rowPerPage;����¡�۾�
	DBHelper dbHelper= new DBHelper();
	//DBHelperŬ������ü������ ���ο�DBHelperŬ��������
	  String driver="jdbc:mariadb://127.0.0.1:3306/employees";
	  String dbid="root";
	  String dbpw="java1234";
	  Connection conn= dbHelper.getConnection(driver, dbid, dbpw);
	  //1.������ ����
	  String sql="SELECT emp_no,birth_date,first_name,late_name,gender,hire_date FROM employees ?,?";
	  //2.�������ۼ�, ���� employees�÷��߿��� ?,?
	  PreparedStatement stmt=conn.prepareStatement(sql);
	  //3.������ ����
	  stmt.setInt(1,rowPerPage);//������ �����Ѵ�
	  stmt.setInt(2,currentPage);
	  //4.Ư���� ����
	  ResultSet rs= stmt.executeQuery();
	  //���������Է��� ���� rs������.��������,�ϳ��� rs�� ����µ� ���
	  while(rs.next()) {
		  //employees���ִ� �迭�� ����Ʈ ��ŭ ������ ���ش�.
		  Employees employees= new Employees();
		  //EmployeesŬ���� ��ü������ ���ο� EmployeesŬ���� ����
		  employees.setEmpNo(rs.getInt("emp_no"));
		  //Ŭ������������ �����´�emp_no�� (�������� �Է��� ���� �ҷ��´�())
		  employees.setBirthDate(rs.getString("birth_date"));
		  //Ŭ������������ �����´� birth_date��(�������� �Է��� ���� �ҷ��´�())
		  employees.setfirstName(rs.getString("first_name"));
		  //Ŭ������������ �����´� first_name��(�������� �Է��� ���� �ҷ��´�())
		  employees.setlastName(rs.getString("last_name"));
		  //Ŭ������������ �����´� last_name��(�������� �Է��� ���� �ҷ��´�())
		  employees.setgender(rs.getString("gender"));
		  //Ŭ������������ �����´� gender��(�������� �Է��� ���� �ҷ��´�())
		  employees.sethireDate(rs.getString("hire_date"));
		  //Ŭ���� �������� �����´� hiredate��(�������� �Է��Ѱ��� �ҷ��´�())
		  list.add(employees);
		  //ArrayList���� �����͸� �߰��ϴ� ���, ������ ���Եȴ�.
	  }
	return list; //����Ʈ�� �ǵ����ش�
	  
  }
}
