package custmer_ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustMemberDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DataSource ds;

	public CustMemberDAO() throws SQLException {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/JNDI_MYSQL");

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
	
	//고객정보 생성(C)
	public void createCustMember(CustMemberVO custMember) {
		try {
			conn = ds.getConnection();
			
			//실행할 sql구문 작성
			String sql = "insert into cust (custName, custAdd, custPhone ,custEmail) values(?,?,?,?)";

			System.out.println(custMember);
			//sql문 전송 위한 객체 생성
			pstmt=conn.prepareStatement(sql);
			
			// ?값 생성
			pstmt.setString(1, custMember.getCustName());
			pstmt.setString(2, custMember.getCustAddr());
			pstmt.setString(3, custMember.getCustTel());
			pstmt.setString(4, custMember.getCustEmail());
			
			
			//쿼리실행
			pstmt.executeUpdate();
			
			//리소스 정리
			pstmt.close();
		}
		catch (SQLException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
	}

	// 고객 정보 조회
	public List<CustMemberVO> getCustMembers() {
		List<CustMemberVO> custMembers = new ArrayList<>();

		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM cust";
			pstmt = conn.prepareStatement(sql);

			// sql문 실행 결과 rs에 담아 처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CustMemberVO custMember = new CustMemberVO();

				custMember.setCustNum(rs.getInt("custID"));
				custMember.setCustName(rs.getString("CustName"));
				custMember.setCustAddr(rs.getString("CustAdd"));
				custMember.setCustTel(rs.getString("CustPhone"));
				custMember.setCustEmail(rs.getString("CustEmail"));

				custMembers.add(custMember);

			}
			
			System.out.println(custMembers);
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();
		}
		return custMembers;
	}

	//고객정보 수정(U)
	public void updateCustMember(CustMemberVO custMember) {
		
		try {
			//DB 연결
			conn=ds.getConnection();
			//sql쿼리문 작성
			String sql = "update cust set custName=?, custAdd=?, custPhone=?, custEmail=? where custID=?";
			
			//sql문 저장하기위한 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			//?값 설정
			pstmt.setString(1, custMember.getCustName());
			pstmt.setString(2, custMember.getCustAddr());
			pstmt.setString(3, custMember.getCustTel());
			pstmt.setString(4, custMember.getCustEmail());
			pstmt.setInt(5, custMember.getCustNum());

			//쿼리 실행
			pstmt.executeUpdate();
			
			//리소스 정리
			pstmt.close();
		}catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}
	//고객정보 삭제(D)
	public void delteCustmer(int custID) {
		try {
			conn = ds.getConnection();
			String sql = "delete from cust where custID=?";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, custID);
			
			pstmt.executeUpdate();
			
			pstmt.close();			
		}catch (SQLException e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}
	
	
}
