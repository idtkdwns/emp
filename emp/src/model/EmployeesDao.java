package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeesDao{	
  public int insertEmployees(Employees employees) throws Exception {//삽입임플로이즈메소드(매개변수 객체) 예외 처리
    System.out.println("insertemployees param");
    //출력 임플로이즈삽입 매개변수
    DBHelper dbHelper = new DBHelper();
    //DBHelper클래스 객체변수 = 새로운클래스
    Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
    //연결 conn객체변수에 넣는다 dbHelper클래스에 있는드라이버들을 가져온다(url,id,pw) 1.접속
    String sql = "INSERT INTO employees(emp_no,birth_date,first_name,last_name,gender,hire_date) VALUES (?,?)";
    //문자열sql에 집어넣는다 employees메소드를 값(?,?) 2.쿼리문작성
    PreparedStatement stmt = conn.prepareStatement(sql);
    //객체변수에참조한다 메소드(매개변수)3.실행
    stmt.setInt(1, employees.getEmpNo());
    //첫번째쿼리에no를가져온다 4.특정 값 지정
    stmt.setString(2, employees.getfirstName());
    //두번째쿼리에 성을가져온다4.특정 값 지정
    return 0;
    //되돌려준다0으로
  }

  public Employees selectEmployeesOne(int empNo) throws Exception {//setter/getter 실습
	  //Employees.java클래스에 공공의 Employees클래스의 한개를 고른다(정수형 no를) 예외처리
    System.out.println("selectemployees param");
    //출력 임플로이즈삽입 매개변수
    DBHelper dbHelper = new DBHelper();
    //DBHelper클래스 객체변수 에 DBHelper 클래스선언, new:객체를 생성해주는 쳑할
    Connection conn = dbHelper.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
    //연결 conn객체변수에 넣는다 dbHelper클래스에 있는드라이버들을 가져온다(url,id,pw)//1.실행후 접속
    String sql = "SELECT emp_no,birth_date,first_name,last_name,gender,hire_date FROM employees WHERE emp_no=?";
    //문자열 sql에 employees에서 고른다 no의수를//2.쿼리문 작성
    PreparedStatement stmt = conn.prepareStatement(sql);
    //객체변수에참조한다 메소드(매개변수)//3.실행
    //PreparedStatement=이미있는걸가지고sql문을 나타내는 객체
    stmt.setInt(1, empNo);
    //첫번째 쿼리에 no를가져온다//4.특정 값 지정
    ResultSet rs = stmt.executeQuery();
    // 쿼리문에입력한 값을 rs에저장.쿼리수행,하나의 rs를 만드는데 사용
    Employees employees = null;
    //Employees클래스 객체변수를 아무것도없는(null)값으로설정
    if (rs.next()) {
      //만약 반환한 값의참조하는 현재 위치에서 다음 열로 이동한다.
      employees = new Employees();
      //객체변수 = 새로운 Emp클래스 선언
      //employees객체변수에 Employees클래스선언, new=객체를생성해주는 역할
      //System.out.println();테스트코드
      employees.setEmpNo(rs.getInt("emp_no"));
      //클래스 변수에서가져온다EmpNo를(쿼리문에입력한 값을 불러온다(정수형 no를))
      employees.setBirthDate(rs.getString("birth_date"));
      //클래스 변수에서 가져온다BirthDate를(쿼리문에 입력한값을 불러온다 (문자형birth_date를))
      employees.setfirstName(rs.getString("first_name"));
      //클래스 변수에서 가져온다firstName를(쿼리문에 입력한 값을 불러온다(문자형 first_name(성)를))
      employees.setlastName(rs.getString("last_name"));
      //클래스 변수에서 가져온다 lastName를(쿼리문에 입력한 값을 불러온다(문자형 last_name(이름)을))
      employees.setgender(rs.getString("gender"));
      //클래스 변수에서 가져온다 gender를(쿼리문에 입력한 값을 불러온다(문자형 gender(성별)를))
      employees.sethireDate(rs.getString("hire_date"));
      //클래스 변수에서 가져온다 hireDate를(쿼리문에 입력한 값을 불러온다(문자형 hire_date(고용날짜)를))
    }
    return employees;//되돌려준다 클래스변수에
  }
  public void deleteEmployees(int empNo) throws Exception{
	  //삭제 메소드,예외처리
	  DBHelper dbHelper = new DBHelper();
	  //DBHelper클래스객체변수에 새로운DBHelper클래스생성
	  String driver ="jdbc:mariadb://127.0.0.1:3306/employees";
	  String dbid="root";
	  String dbpw="java1234";
	  Connection conn= dbHelper.getConnection(driver, dbid, dbpw);
	  //1.실행후 접속, db연결동작
	  String sql="DELETE FROM employees WHERE emp_no=?";
	  //2.쿼리문 작성,sql에 employees안의 emp_no의 몇번째를삭제한다
	  PreparedStatement stmt = conn.prepareStatement(sql);
	  //3.실행,객체변수에 참조한다 메소드(매개변수)
	  stmt.setInt(1,empNo);
	  //4.특정값 지정,첫번째 쿼리에 empNo를 가져온다
	  stmt.executeQuery();
	  //반환을 안해도되니 Result가 없다,쿼리수행
  }
  public void updateEmployees(Employees employees)throws Exception{
	  //업데이트,예외처리
	  DBHelper dbHelper= new DBHelper();
	  //DBHelper클래스객체변수에 새로운DBHelper클래스생성
	  String driver="jdbc:mariadb://127.0.0.1:3306/employees";
	  String dbid="root";
	  String dbpw="java1234";
	  Connection conn= dbHelper.getConnection(driver, dbid, dbpw);
	  //1.실행후 접속
	  String sql="UPDATE FROM employees SET birth_date=?,first_name=?,last_name=?,gender=?,hire_date=? WHERE emp_no=?";
	  //2.쿼리문작성=employees업데이트 변경 컬럼으로부터 내가원하는 번호에 컬럼을 넣겠다
	  PreparedStatement stmt= conn.prepareStatement(sql);
	  //3.쿼리문 실행
	  stmt.setString(1,employees.getBirthDate());
	  //4.특정값 지정
	  stmt.setString(2,employees.getfirstName());
	  stmt.setString(3,employees.getlastName());
	  stmt.setString(4,employees.getgender());
	  stmt.setString(5,employees.gethireDate());
	  stmt.setInt(6,employees.getEmpNo());
	  //몇번째쿼리에 emp...을 변경한다
	  System.out.println(stmt);
	  //확인출력
	  stmt.executeUpdate();
	  //실행된 열의 갯수를나타냄
	  conn.close();
	  //연결을 닫는다
  }
  public ArrayList<Employees>selectEmployeesList(int rowPerPage, int currentPage) throws Exception {
	ArrayList<Employees> list = new ArrayList<Employees>();
	System.out.println("currentPage:"+currentPage);
	System.out.println("rowPerpage:"+rowPerPage);
	//출력확인
	//int beginRow =(currentPage-1)*rowPerPage;페이징작업
	DBHelper dbHelper= new DBHelper();
	//DBHelper클래스객체변수에 새로운DBHelper클래스생성
	  String driver="jdbc:mariadb://127.0.0.1:3306/employees";
	  String dbid="root";
	  String dbpw="java1234";
	  Connection conn= dbHelper.getConnection(driver, dbid, dbpw);
	  //1.실행후 접속
	  String sql="SELECT emp_no,birth_date,first_name,late_name,gender,hire_date FROM employees ?,?";
	  //2.쿼리문작성, 고른다 employees컬럼중에서 ?,?
	  PreparedStatement stmt=conn.prepareStatement(sql);
	  //3.쿼리문 실행
	  stmt.setInt(1,rowPerPage);//쿼리를 변경한다
	  stmt.setInt(2,currentPage);
	  //4.특정값 지정
	  ResultSet rs= stmt.executeQuery();
	  //쿼리문에입력한 값을 rs에저장.쿼리수행,하나의 rs를 만드는데 사용
	  while(rs.next()) {
		  //employees에있는 배열의 리스트 만큼 리턴을 해준다.
		  Employees employees= new Employees();
		  //Employees클래스 객체변수에 새로운 Employees클래스 생성
		  employees.setEmpNo(rs.getInt("emp_no"));
		  //클래스변수에서 가져온다emp_no를 (쿼리문에 입력한 값을 불러온다())
		  employees.setBirthDate(rs.getString("birth_date"));
		  //클래스변수에서 가져온다 birth_date를(쿼리문에 입력한 값을 불러온다())
		  employees.setfirstName(rs.getString("first_name"));
		  //클래스변수에서 가져온다 first_name를(쿼리문에 입력한 값을 불러온다())
		  employees.setlastName(rs.getString("last_name"));
		  //클래스변수에서 가져온다 last_name를(쿼리문에 입력한 값을 불러온다())
		  employees.setgender(rs.getString("gender"));
		  //클래스변수에서 가져온다 gender을(쿼리문에 입력한 값을 불러온다())
		  employees.sethireDate(rs.getString("hire_date"));
		  //클래스 변수에서 가져온다 hiredate를(쿼리문에 입력한값을 불러온다())
		  list.add(employees);
		  //ArrayList에서 데이터를 추가하는 방법, 순서를 갖게된다.
	  }
	return list; //리스트에 되돌려준다
	  
  }
}
