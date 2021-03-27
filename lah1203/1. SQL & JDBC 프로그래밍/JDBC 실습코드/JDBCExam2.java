package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dto.Role;
import kr.or.connect.jdbcexam.dao.RoleDao;

public class JDBCExam2 {
	public static void main(String[] args) {
		int roleId = 600;
		String description = "Programmer";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);
	}
}
