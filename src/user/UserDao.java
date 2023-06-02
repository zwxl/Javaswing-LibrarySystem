package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import book.DBManager;

public class UserDao {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	public static void addUser(User user) {
		conn = DBManager.getConnection();
		String sql = "insert into user(name,password) values(?,?)";
		try {
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(0, user.getName());
			pstmt.setString(1, user.getPassword());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
