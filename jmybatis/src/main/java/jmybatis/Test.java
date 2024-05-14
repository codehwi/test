package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();
		my.init();

		Scanner s = new Scanner(System.in);
		boolean result=false;
		while (!result) {
			System.out.println("[1]로그인 ");
			int choice = s.nextInt();
			s.nextLine();
			if (choice == 1) {				
				// 사용자로부터 입력을 받기

				System.out.print("아이디 입력 : ");
				String user_id = s.nextLine();
				System.out.print("비밀번호 입력 : ");
				String user_pw = s.nextLine();
				
				result=my.loginUser(user_id, user_pw);
				
				

				// DTO 객체생성후 입력받은 값으로 초기화

			} // insert끝
			/*
			 * if (choice == 2) { System.out.println("삭제");
			 * 
			 * System.out.print("아이디 입력 : "); String user_id = s.nextLine();
			 * 
			 * UserDAO dao = new UserDAO(); dao.deleteUser(user_id); dao.selectUser(); } //
			 * delete 끝
			 * 
			 * if (choice == 3) { System.out.println("수정");
			 * 
			 * System.out.print("바꿀 아이디 : "); String user_id = s.nextLine();
			 * System.out.print("수정 후 아이디 : "); String n_user_id = s.nextLine();
			 * 
			 * UserDAO dao = new UserDAO(); dao = new UserDAO(); dao.updateUser(n_user_id,
			 * user_id); dao.selectUser(); } // update 끝 if (choice == 4) {
			 * System.out.println("조회"); UserDAO dao = new UserDAO(); dao.selectUser(); } //
			 * all select 끝 if (choice == 5) { System.out.println("검색");
			 * System.out.println("검색합니다"); System.out.print("검색할 아이디 : "); String user_id =
			 * s.nextLine(); UserDAO dao = new UserDAO(); dao.searchUser(user_id); }
			 */

		} // while끝
	}

}
