package jmybatis;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	SqlSessionFactory sqlSessionFactory;

	// 연결 CONFIG는 연결에 필요한 정보와 정보가 어디 저장되는지에 관한 정보 보유
	public void init() {
		try {
			// import ctrl shift o
			String resource = "jmybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오기 실패 ㅜㅜㅜ");
			e.printStackTrace();
		}
	}

	// select
	public ArrayList<UserDTO> getUser() {
		// sql문 처리
		SqlSession session = sqlSessionFactory.openSession();// 세션에 저장
		UserMapper mapper = session.getMapper(UserMapper.class);// 세션정보 가져오기
		ArrayList<UserDTO> userlist = mapper.getUser();

		return userlist;
	}

	// insert

	public void insertUser(String user_id, String user_pw, String name, String phone, String grade, int age) {
		SqlSession session = sqlSessionFactory.openSession();// 세션에 저장
		UserMapper mapper = session.getMapper(UserMapper.class);// 세션정보 가져오기
		UserDTO userDTO = new UserDTO(user_id, user_pw, name, phone, grade, age);
		mapper.insertUser(userDTO);
		session.commit();

	}

	public void updateUser(String name, String user_id) {
		SqlSession session = sqlSessionFactory.openSession();// 세션에 저장
		UserMapper mapper = session.getMapper(UserMapper.class);// 세션정보 가져오기

		mapper.updateUser(name, user_id);
		session.commit();

	}

	public void deleteUser(String user_id) {
		SqlSession session = sqlSessionFactory.openSession();// 세션에 저장
		UserMapper mapper = session.getMapper(UserMapper.class);// 세션정보 가져오기
		mapper.deleteUser(user_id);
		session.commit();// update insert delete에만 해당(필수)

	}

	public boolean loginUser(String user_id, String user_pw) {
		// UserDTO dto=new UserDTO();
		SqlSession session = sqlSessionFactory.openSession();// 세션에 저장
		UserMapper mapper = session.getMapper(UserMapper.class);// 세션정보 가져오기
		/*
		 * int count=session.selectOne("loginCh",user_id); if(count==0){
		 * System.out.println("아이디가 존재하지 않습니다"); }else {
		 * dto=session.selectOne("login",user_id); if(user_pw.equals(dto.getUser_pw))){
		 * System.out.println("로그인성공"); }else { System.out.println("비밀번호가 다릅니다."); } }
		 */

		Map<String, Object> user;
		user = session.selectOne("loginUser", user_id);

		String id = (String) user.get("user_id");
		String pw = (String) user.get("user_pw");
		System.out.println(id);
		System.out.println(pw);

		if (id.equals(user_id)) {
			if (pw.equals(user_pw)) {
				System.out.println("로그인 성공");
				return true;
			} else {
				System.out.println("비밀번호 오류");
				return false;
			}
		} else {
			System.out.println("아이디오류");
			return false;
		}

	}
}
// 끝
