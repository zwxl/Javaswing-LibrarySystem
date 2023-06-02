package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {
    //表示数据库的用户名
    private static final String USERNAME = "root";
    //表示数据库的密码
    private static final String PASSWORD = "5720";
    //数据库的驱动信息
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //访问数据库的地址
    private static final String URL = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    //定义数据库的链接
    private static Connection connection;
    //定义sqk语句的执行对象
    private java.sql.PreparedStatement pstmt;
    //定义查询返回的结果集合
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
            System.out.println("注册驱动成功");
            connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("链接成功");
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

