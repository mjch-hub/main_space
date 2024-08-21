package bookHouse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MemberList {
	/*
	 * 1. Member 형(제네릭) membeList를 만들것.(캡슐화) 2. Member형(제네릭) idset도 만들 것.(중복허용X
	 * 되도록.) 3. 로그인 메소드 login 구현. - id/pw 입력시 memberset에 등록되어 있는지 확인 후 겹치지 않으면 로그인 안
	 * 되도록! - selectMember 객체를 통해 로그인 id/pw 필터. 4. 회원가입 메소드 regist(Scanner scanner)
	 * 구현하여 id와 pw 입력받을 수 있도록 할 것. (회원가입시 아이디 중복될 경우 생성 안되게 걸러주기!) 6. 로그인 시 메인 서점
	 * 메뉴화면 뜨게 하기. selectMEmber.get()
	 * 
	 */

	// 1. Member 형(제네릭) memberList를 만들것.
	private List<Member> memberList = new ArrayList<Member>();

	// 2. Member형(제네릭) idset도 만들 것.
	Set<Member> idSet = new HashSet<Member>();

	// 3. 로그인 메소드 login 구현.
	public Member login(Scanner scanner) {
		while (true) {
			// id입력받기
			System.out.println("아이디를 입력해주세요 : ");
			String id = scanner.nextLine();

			// 중복id 안되게 걸러주기 : idset.size를 활용.
			List<Member> selectMember = memberList.stream().filter(member -> member.getId().equals(id)).toList();

			if (selectMember.size() == 0) {
				System.out.println("🚨 로그인 정보가 일치하지 않습니다!");
				return null;
			}

			// pw입력받기
			System.out.println("비밀번호를 입력해주세요 : ");
			String pw = scanner.nextLine();

			//pw 일치하는 지 확인 : 일치하지 않으면 일치 하지 않는다고 반환
			if (!selectMember.get(0).getPw().equals(pw)) {
				System.out.println("🚨 로그인 정보가 일치하지 않습니다!");
				return null;
			}

			System.out.println("✔ 로그인 성공!");
			return selectMember.get(0);
		}
	

	}

	// 4. 회원가입 메소드 regist(Scanner scanner) 구현.
	public void regist(Scanner scanner) {
		System.out.println("아이디를 입력해주세요 : ");
		String id = scanner.nextLine();

		System.out.println("비밀번호를 입력해주세요 : ");
		String pw = scanner.nextLine();

		memberList.add(new Member(id, pw));
		System.out.println("✔ 등록 완료!");

	}

	// 5. 로그인 시 메인 서점 메뉴화면 뜨게 하기. selectMEmber.get()

}
