package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {
    //��ʾ���ݿ���û���
    private static final String USERNAME = "root";
    //��ʾ���ݿ������
    private static final String PASSWORD = "5720";
    //���ݿ��������Ϣ
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //�������ݿ�ĵ�ַ
    private static final String URL = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    //�������ݿ������
    private static Connection connection;
    //����sqk����ִ�ж���
    private java.sql.PreparedStatement pstmt;
    //�����ѯ���صĽ������
    private ResultSet resultSet;
    
    public static Connection getConnection() {
    	 try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 try {
			connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
    }
    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);
            System.out.println("ע�������ɹ�");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("���ӳɹ�");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

