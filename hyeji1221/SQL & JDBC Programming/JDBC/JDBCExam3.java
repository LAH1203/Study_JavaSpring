package kr.or.connect.jdbcexam;

import java.util.List;

import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;

public class JDBCExam3 {
	public static void main(String[] args) {
		
		RoleDao dao = new RoleDao();
		
		List<Role> list = dao.getRoles();
		
		for(Role role: list) {
			System.out.println(role);
		}
	}
}
