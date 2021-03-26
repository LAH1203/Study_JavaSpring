package kr.or.connect.jdbcexam.dao;
import kr.or.connect.jdbcexam.dto.Role;
import java.sql.*;
import java.util.*;

public class RoleDao {
	//private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpassword = "connect123!@#";
	
	public List<Role> getRoles() {
		List<Role> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT description, role_id FROM role order by role_id desc";
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt(2);
					Role role = new Role(id, description);
					list.add(role);
					
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
		
	}
	
	public int addRole(Role role) {
		int insertCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword); // db에 접속할 url, user, password
			String sql = "INSERT INTO role (role_id, description) VALUES (?, ?)";
			ps = conn.prepareStatement(sql); // ? 사용 가능
			
			ps.setInt(1, role.getRoleId()); // ?순서, ?대신 들어갈 값
			ps.setString(2,  role.getDescription());
			
			insertCount = ps.executeUpdate(); // insert, update, delete
			
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		
		}
		return insertCount;
	}
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Connection conn = null; // 연결
		PreparedStatement ps = null; //명령
		ResultSet rs = null; // 결괏값 
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword); // db에 접속할 url, user, password
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";
			ps = conn.prepareStatement(sql); // ? 사용 가능
			ps.setInt(1, roleId); // ?순서, ?대신 들어갈 값
			rs = ps.executeQuery(); // 실행하기
			
			if(rs.next()) {
				String description = rs.getString(1);
				int id = rs.getInt("role_id");
				role = new Role(id, description);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return role;
	}
}
