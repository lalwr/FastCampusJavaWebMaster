package examples.spring.ch01.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// 2단계 : 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
			
			// 3단계 : Connection 객체를 생성한다.
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "java00", "java00");
			System.out.println("연결 성공");
			
			// 4단계 : Statement객체를 생성한다.
			st = con.createStatement();
			System.out.println("명령 준비 성공");
			
			// 5단계 : 결과가 있다면 ResultSet 객체를 생성한다.
			rs = st.executeQuery("select * from member");
			System.out.println("결과 얻었음");
			
			while (rs.next()) {
				String userid = rs.getString("userid");
				String userpass = rs.getString("userpass");
				System.out.println("userid=" + userid + ",userpass=" + userpass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6단계 : 모든 객체를 닫는다.
			if (rs != null) try { rs.close(); } catch (SQLException e) {}
			if (st != null) try { st.close(); } catch (SQLException e) {}
			if (con != null) try { con.close(); } catch (SQLException e) {}
		}
	}
}
