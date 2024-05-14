package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		DBUtil my = new DBUtil();

		my.init();// 연결

		// 사용자로부터 입력을 받기
		Scanner s = new Scanner(System.in);

		System.out.print("[수행 기능 선택]\n ** 1. 입력 2. 수정 3. 삭제 4. 조회 **\n>> ");
		while (true) {
			int num = s.nextInt();
			s.nextLine();
			if (num == 1) {
				System.out.println("[값을 입력합니다.]");
				System.out.print("아이디 입력 : ");
				String user_id = s.nextLine();
				System.out.print("비밀번호 입력 : ");
				String user_pw = s.nextLine();
				System.out.print("이름 입력 : ");
				String name = s.nextLine();
				System.out.print("전화번호 입력 (예시:010-1111-1111) : ");
				String phone = s.nextLine();
				System.out.print("등급 입력 : ");
				String grade = s.nextLine();
				System.out.print("나이 입력 : ");
				int age = s.nextInt();

				my.insertUser(user_id, user_pw, name, phone, grade, age);

				System.out.print("[수행 기능 선택]\n ** 1. 입력 2. 수정 3. 삭제 4. 조회 **\n>> ");
			} else if (num == 2) {
				System.out.println("[값을 수정합니다.]");
				System.out.print("바꿀 이름 입력 : ");
				String name = s.nextLine();
				System.out.print("수정 할 아이디 입력 : ");
				String user_id = s.nextLine();
				my.updateUser(name, user_id);
				System.out.print("[수행 기능 선택]\n ** 1. 입력 2. 수정 3. 삭제 4. 조회 **\n>> ");

			} else if (num == 3) {
				System.out.println("[값을 삭제합니다.]");
				System.out.print("삭제 할 아이디 입력 : ");
				String user_id = s.nextLine();
				my.deleteUser(user_id);
					System.out.print("[수행 기능 선택]\n ** 1. 입력 2. 수정 3. 삭제 4. 조회 **\n>> ");
			} else if (num == 4) {
				System.out.println("[값을 조회합니다.]");
				// DAO 객체 생성
				ArrayList<UserDTO> list = my.getUser();

				System.out.println(list);
				System.out.print("[수행 기능 선택]\n ** 1. 입력 2. 수정 3. 삭제 4. 조회 **\n>> ");
			} else {
				System.out.println("잘못된 번호");
				break;
			}
		}
		System.out.println("hi");
		System.out.println("hi1");
		System.out.println("hi2");
	
	}

	// TODO Auto-generated method stub

}
