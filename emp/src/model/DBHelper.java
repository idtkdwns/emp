package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {	//이름
	
public Connection getConnection(String driver, String dbid, String dbpw) throws Exception {
	//연결을 돌려받는다 메소드로부터 예외처리
    Class.forName("org.mariadb.jdbc.Driver");
    //클래스를 조사한다(주소.jdbc.드라이버)
	Connection conn = null;
    //연결 변수conn은 아무것도없음
    return DriverManager.getConnection(driver, dbid, dbpw);
    //되돌려받는다 jdbc드라이버관리.연결을(메소드3가지)
	}
}
