package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {	//�̸�
	
public Connection getConnection(String driver, String dbid, String dbpw) throws Exception {
	//������ �����޴´� �޼ҵ�κ��� ����ó��
    Class.forName("org.mariadb.jdbc.Driver");
    //Ŭ������ �����Ѵ�(�ּ�.jdbc.����̹�)
	Connection conn = null;
    //���� ����conn�� �ƹ��͵�����
    return DriverManager.getConnection(driver, dbid, dbpw);
    //�ǵ����޴´� jdbc����̹�����.������(�޼ҵ�3����)
	}
}
