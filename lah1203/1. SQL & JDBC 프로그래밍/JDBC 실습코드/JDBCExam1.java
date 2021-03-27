package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dto.Role;
import kr.or.connect.jdbcexam.dao.RoleDao;

public class JDBCExam1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
