package model;
import java.sql. *;

public class DepartmentDao{
  public int insertDepartment(Department department) throws Exception {//공공의 정수형 삽입Department메소드(매개변수 객체) 예외 처리
	  System.out.println("insertDepartment param");
	  //출력해보기
	  DBHelper dbhelper = new DBHelper();
	  //DBHelper클래스 객체변수 = 새로운 DBHelper로,객체
	  Connection conn = dbhelper.getConnection("jdbc:mariadb://127.0.0.1:3306","root", "java1234");
	  //1.DB접속, 연결 conn객체변수에 넣는다 dbhelper클래스에 있는 정보들을(주소,id,pw)
	  String sql = "INSERT INTO departments(dept_no,dept_name) VALUES (?,?)";
	  //2.쿼리문 작성,sql에 집어넣다 departments메소드를 값(두개)
	  PreparedStatement stmt=conn.prepareStatement(sql);
	  //3.쿼리문 실행, 객체변수에 참조한다 메소드(매개변수 sql)
	  
	  //Department department = new Department();
	  //Departmemt.java에서 불러온다 *private로하기전*
	  stmt.setString(1,department.getDeptName());
	  //4.특정값지정 첫번째 쿼리에 Name값을 가져온다
	  stmt.setString(2,department.getDeptNo());
	  //4.특정값지정 두번째 쿼리에 No값을 가져온다
	  return 0;
	  //되돌려준다 0으로
  }

public Department selectDepartmentOne(String departNo) throws Exception{ 
	  //공공의 Departmemt.java클래스에 Department클래스의 한가지를 고른다(No를) 예외처리
	  System.out.println("selectDepartment param");
	  DBHelper dbhelper= new DBHelper();
	  //새로운클래스 선언
	  Connection conn = dbhelper.getConnection("jdbc:mariadb://127.0.0.1:3306","root","java1234");
	  //1.연결후 실행
	  String sql="SELECT dept_no,dept_name FROM department WHERE dept_no=";
	  //2.쿼리문 작성=고른다 둘중에 department로부터 dept_no의 수를
	  PreparedStatement stmt=conn.prepareStatement(sql);
	  //3.쿼리문 실행
	  stmt.setString(1,departNo);
	  //4.특정값 지정
	  ResultSet rs=stmt.executeQuery();
	  //쿼리문에 입력한값을rs에 저장
	  Department department=null;
	  //클래스 객체변수를 아무것도 없는 값으로 설정
	  if(rs.next()) {
	  //만약 반환한 값의 참조하는 현재 위치에서 다음 열로이동
		 department = new Department();
		 //객체변수 = 새로운 Department클래스
		 //System.out.println();테스트 코드		 
		 department.setDeptNo(rs.getString("deptNo"));
		 //Department.java안의 무엇인지 알려준다 = 쿼리문안의 값을 가져온다(set넣기전)
		 //클래스변수에서 가져온다 DeptNo를(쿼리문에 입력한 값을 불러온다)
		 department.setDeptName(rs.getString("deptName"));
		 //Department.java안의 무엇인지 알려준다 = 쿼리문안의 값을 가져온다(set넣기전)
		 //클래스변수에서 가져온다 DeptName를(쿼리문에 입력한 값을 불러온다)

	  }
	  return department;
	  //돌려준다 클래스 변수에
  	}
}
