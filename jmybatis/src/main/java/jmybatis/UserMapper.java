package jmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	// 리턴타입,매서드명,매개변수
	// 추상적인곳만 구현하는곳

	// select
	public ArrayList<UserDTO> getUser();

	// insert
	public void insertUser(UserDTO userDTO);
	// update

	public void updateUser(@Param("name") String name, @Param("user_id") String user_id);

	// delete
	public void deleteUser(String user_id);

	public String loginUser(@Param("user_id") String user_id, @Param("user_pw") String user_pw);

	public void loginUser(String userId);
}
