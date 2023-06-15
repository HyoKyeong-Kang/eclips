import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn = null;
		// JDBC 1단계 : 드라이버 객체로딩 - DriverManager 클래스 이용
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("객체 로딩 성공");

			// JDBC 2단계 : 커넥션 연결
			// 드라이버 매니저에게 커넥션 객체를 요청- 커넥션을 요청하기 위해 url 필요(각 벤더마다 다르다)
			// Mysql의 경우 "jdbc:mysql://localhost/사용할db이름"
			String url = "jdbc:mysql://localhost/";
			String dbName = "example";

			// @param getConnecion(url, userName, password)
			// @return Connection 객체
			conn = DriverManager.getConnection(url + dbName, "root", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(PreparedStatement stmt, Connection conn) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}