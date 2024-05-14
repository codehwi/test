package jmybatis;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	// 데이터가 있는 저장소로 접근하는 유일한 객체
	// 앞에 정보를 쓰는게 관례
	// 할수있는 기능을 수행(CRUD 수행)
	// 데이터를 실제 DB에 저장(MVC패턴에서 MODEL 역할)
	private Connection conn;
	// psmt 쿼리문 해석역할
	private PreparedStatement pt;
	private ResultSet rs;
	// 1.jar임포트 2.Driver 3. connect/ 4.쿼리문준비(?,?) 5.psmt/값설정 6.보내기 7.결과처리 /8.닫기

	private void connect() {
		try {
			// 드라이버로드
			String dbDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbDriver);
			String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
			String dbId = "root";
			String dbPw = "1234";
			// db연결
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);

		} catch (Exception e) {
			e.printStackTrace();
		} // catch

	}// connect

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pt != null) {
				pt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} // try catch끝
	}// close끝

	public void insertUser(UserDTO userDTO) {
		connect();
		try {
			// sql ?가 써진 순서로 변수를 구분함
			String insertSQL = "insert into user values(?,?,?,?,?,?)";
			// sql 입력값 설정
			pt = conn.prepareStatement(insertSQL);
			pt.setString(1, userDTO.getUser_id());
			pt.setString(2, userDTO.getUser_pw());
			pt.setString(3, userDTO.getName());
			pt.setString(4, userDTO.getPhone());
			pt.setString(5, userDTO.getGrade());
			pt.setInt(6, userDTO.getAge());

			pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		} // catch끝
	}// insert 끝

	public void selectUser() {
		connect();
		List<UserDTO> users = new ArrayList<UserDTO>();

		try {
			String selectSQL = "select * from user";
			pt = conn.prepareStatement(selectSQL);
			rs = pt.executeQuery();
			while (rs.next() == true) {
				UserDTO dto = new UserDTO(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("name"),
						rs.getString("phone"), rs.getString("grade"), rs.getInt("age"));
				users.add(dto);

			} // while끝
				// 향상된 for문 /for each
				// 한행씩 출력
			for (UserDTO oneuser : users) {
				System.out.println(oneuser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		} // catch 끝

	}// select끝

	public void updateUser(String n_user_id, String user_id) {
		connect();
		try {
			// sql ?가 써진 순서로 변수를 구분함
			String updateSQL = "update user set user_id=? where user_id=?";
			// sql 입력값 설정
			pt = conn.prepareStatement(updateSQL);
			pt.setString(1, n_user_id);
			pt.setString(2, user_id);

			pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		} // catch끝
	}// update끝

	public void deleteUser(String user_id) {
		connect();
		try {
			// sql ?가 써진 순서로 변수를 구분함
			String insertSQL = "delete from user where user_id=?";
			// sql 입력값 설정
			pt = conn.prepareStatement(insertSQL);
			pt.setString(1, user_id);

			pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		} // catch끝
	}// delete 끝

	public void searchUser(String id) {
		connect();
		List<UserDTO> users = new ArrayList<UserDTO>();

		try {
			String searchSQL = "select * from user where user_id=?";
			pt = conn.prepareStatement(searchSQL);
			pt.setString(1, id);
			rs = pt.executeQuery();
			while (rs.next() == true) {
				UserDTO dto = new UserDTO(rs.getString("user_id"), rs.getString("user_pw"), rs.getString("name"),
						rs.getString("phone"), rs.getString("grade"), rs.getInt("age"));
				users.add(dto);

			} // while끝
				// 향상된 for문 /for each
				// 한행씩 출력
			for (UserDTO oneuser : users) {
				System.out.println(oneuser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		} // catch 끝
	}// search끝

}// DAO 클래스 끝
