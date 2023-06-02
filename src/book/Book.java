package book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Book {
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	public static ResultSet selectBook() {
		conn = DBManager.getConnection();
		String sql = "select id,bookNo,bookname,author,publisher from bookinfo";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static int deleteBook(int bookid) throws SQLException {
		int flag;
		conn = DBManager.getConnection();
		String sql = "delete from bookinfo where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bookid);
		flag = pstmt.executeUpdate();
		return flag;
	}
	public static void updateBook(BookInfo book) throws SQLException {
		conn = DBManager.getConnection();
		String sql = "update bookinfo set bookNo='"+book.getBookNo()+"',bookname='"+book.getBookName()+"',author='"+book.getAuthor()+"',publisher='"+book.getPublisher()+"' where id='" + book.getId() + "'";
		System.out.println(sql);
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
	    pstmt.executeUpdate();//Ö´ÐÐSQLÓï¾ä
	}
	public static void addBook(BookInfo book) throws SQLException {
		conn = DBManager.getConnection();
		String sql = "INSERT INTO bookinfo(bookNo,bookname,author,publisher) values(?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1, book.getBookNo());
		pstmt.setString(2, book.getBookName());
		pstmt.setString(3, book.getAuthor());
		pstmt.setString(4, book.getPublisher());
		System.out.println(sql);
	    pstmt.executeUpdate();//Ö´ÐÐSQLÓï¾ä
	}
}
