import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = JDBCUtil.getConnection();

			// JDBC 3단계 : statement생성
			String sql = "update t_member set name=?, email=? where id=?";
			stmt = conn.prepareStatement(sql);

			// JDBC 4단계 : SQL 전송
			// ? 값 설정
			stmt.setString(1, "나영석");
			stmt.setString(2, "Na1@user.com");
			stmt.setString(3, "user1");

			// SQL 전송
			int count = stmt.executeUpdate();
			System.out.println(count + "건 데이터 전송 처리 성공");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
