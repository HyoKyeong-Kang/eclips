
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class InsertUser {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			// JDBC 1단계 : 드라이버 객체로딩 - DriverManager 클래스 이용
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("객체 로딩 성공");

			// JDBC 2단계 : 커넥션 연결
			// 드라이버 매니저에게 커넥션 객체를 요청- 커넥션을 요청하기 위해 url 필요(각 벤더마다 다르다)
			// Mysql의 경우 "jdbc:mysql://localhost/사용할db이름"
			String url = "jdbc:mysql://localhost/";
			String dbName = "example";

			// @param getConnecion(url, userName, password)
			// @return Connection 객체
			conn = DriverManager.getConnection(url+dbName, "root", "1234");

			if (conn != null)
				System.out.println("mysql연결성공: " + conn.toString());
			
			//JDBC 3단계 : Statement 생성
			//쿼리 수행을 위해 PreparedStatement 객체를 생성
			//SQL 쿼리 작성 시 주의사항
			  // 1. JDBC 쿼리를 작성할 때는 세미콜론(;)을 제외하고 작성
			  // 2. select 시에는 모든 컬럼을 가져오는 것보다는 (*) 필요한 데이터에 대한 컬럼명을 직접 명시해 주는게 좋다.
			  // 3. 쿼리를 한 줄로 쓰기 어려운 경우 들여쓰기가 가능하나 항상 띄어쓰기에 유의해야한다.
			  // 4. PreparedStatement 실행구문의 경우 SQL문에 '?' 로 파라미터를 지정할 수 있고, 사용자가 해당하는 파라미터의 값을 입력해 줄 수 있다.
			
			String sql = "insert into t_member value(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			//현재 시간 가져오기;
			Date currentDate = new Date();
			Timestamp timestamp =new Timestamp(currentDate.getTime());
			
			//JDBC 4단계 : SQL 전송
			// ? 값 설정
			stmt.setString(1, "user1");
			stmt.setString(2, "1234");
			stmt.setString(3, "홍길동");
			stmt.setString(4, "user1@user.com");
			stmt.setTimestamp(5, timestamp);
			
			//SQl 전송확인
			int count = stmt.executeUpdate();
			System.out.println(count + "건 데이터 처리 성공!");
//			stmt.executeUpdate();
			
			
			
			if(stmt != null)System.out.println("statement 연결성공: " + stmt.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// JDBC 5단계: 연결 해제
			//일반적으로 연결해제 작업은 예외발생과 무관하게 실행되는 finally 블록에 작성
			
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
