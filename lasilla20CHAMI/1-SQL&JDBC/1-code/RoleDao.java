package kr.or.connect.jdbcexam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam.dto.Role;

public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "root";
	private static String dbpasswd = "201911011";

	public Role getRole(Integer roleId) {//정수 roleID를 입력받음
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			//?에 해당하는 부분만 변경됨. 이걸 prepare 함수에서 설정해줄 수 있음
			ps = conn.prepareStatement(sql);
			//role이 int 이므로 setInt. ?가 1개 이므로 첫번째 물음표 = roleID 이다.
			ps.setInt(1, roleId);
			rs = ps.executeQuery();

			if (rs.next()) {
				String description = rs.getString(1);//첫번째 컬럼을 꺼냄
				int id = rs.getInt("role_id"); //컬럼 이름으로 꺼내도 괜찮음
				role = new Role(id, description); //role 객체에 담아서 보내기
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role;
	}
}
