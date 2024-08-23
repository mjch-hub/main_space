package bookHouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookHouse {

	/*
	 * 0. 스캐너 객체, 멤버리스트 객체, 로그인멤버 변수 1. 로그인 전 화면 : premain메소드(로그인,회원가입,종료하기 메소드를 포함)
	 * 2. 메인 화면 : mainMenu( 1.책 저장하기 : createMode 2.책 정보 보기 : readMode (전체목록
	 * 출력:fullRead , 종이책만 출력:pBookRead, 이북만출력 : eBookRead, 검색) 3.책 정보 수정하기 :
	 * updateMode 4.로그아웃 하기 3.creatMode(1.새 책 만들기 2. 뒤로 가기) 4.readMode(1. 전체 목록 보기
	 * 2.종이책만 보기 3.전자책만 보기 4.검색하기 5.뒤로가기) 5.Fullread() 6.pBookRead() 7.eBookRead()
	 * 8.updateMode(검색 후 나온 리스트에서 선택하여 정보 수정할 수 있도록 메소드 짤 것.)
	 * 
	 * 
	 */
	// 0. 스캐너, 멤버리스트, 로그인멤버
	private Scanner scan = new Scanner(System.in);
	private MemberList memberList = new MemberList();
	private Member loginMember;

	// 1-1. 시작 화면
	BookHouse() {
		System.out.println(
				"""
				+ ════════════════════════════════════════════════════════════════════════════════════════════════ +
				     _______   _______   _______   __   __    ________   _________   _______   _______   _______
				    |   _   | |   _   | |   _   | |  |_|  |  |   _____| |         | |   _   | |   __  | |   ____|
				    |  |_|  | |  | |  | |  | |  | |     __|  |  |_____  |__     __| |  | |  | |  |__| | |  |____
				    |   _  <  |  |_|  | |  |_|  | |    <__   |_____   |    |   |    |  |_|  | |   _  <  |   ____|
				    |  |_|  | |       | |       | |   _   |  ______|  |    |   |    |       | |  | |  | |  |____
				    |_______| |_______| |_______| |__| |__|  |________|    |___|    |_______| |__| |__| |_______|
				
				+ ════════════════════════════════════════════════════════════════════════════════════════════════ +
				""");
	}

	// 1-2. preMain메소드(로그인, 회원가입, 종료하기 메소드 호출)
	public void preMain() {
		while (true) {
		System.out.println(
				"""
				 ╓================================================❣️================================================╖
				
				                                1. 로그인       2. 회원가입      3. 종료하기
				                                
				 ╙================================================❣️================================================╜
				""");
			try {
				int num = Integer.parseInt(scan.nextLine());
				if (num == 1) {
					this.loginMember = memberList.login(scan);
					if (this.loginMember == null)
						continue;
					else
						this.mainMenu();
				} else if (num == 2) {
					memberList.regist(scan);
				} else if (num == 3) {
					scan.close();
				} else
					throw new Exception();

			} catch (Exception e) {
				System.out.println("🚨 잘못된 입력입니다.");

			}
		}

	}

	// 2. mainMenu메소드 (책저장하기,책정보보기,책정보수정하기,로그아웃하기)
	public void mainMenu() {
		while (true) {
		System.out.println(
				"""
				 ╓=======================================❣️ 메인 메뉴 ❣️============================================╖
				
				                 1. 책 저장하기      2. 책 목록보기      3. 책 정보 수정하기      4. 로그아웃
				                
				 ╙=============================================❣️================================================╜
				""");
			try {
				int num = Integer.parseInt(scan.nextLine());
				if (num == 1) {
					this.createMode();
					break;
				} else if (num == 2) {
					this.readMode();
					break;
				} else if (num == 3) {
					this.updateMode();
					break;
				} else if (num == 4) {
					System.out.println("안녕히 가세요 👋");
					preMain();
					break;
				} else
					throw new Exception();
			} catch (Exception e) {
				System.out.println("🚨 잘못된 입력입니다.");
			}

		}

	}

	// 3. createMode(1.새책만들기 2.뒤로가기)
	public void createMode() {
		boolean loop = true;
		while(loop) {
		System.out.println(
				"""
				╓===========================================❣️ 메뉴 보기 ❣️===========================================╖
				
				                                1. 새 책 만들기         	2. 뒤로 가기

				╙================================================❣️================================================╜

				""");
		
		try {
			int menuNum = Integer.parseInt(scan.nextLine());
			switch (menuNum) {
			case 1 : {//1. 새 책 만들기 : 에 대하여 bookList를 받아온 다음 create메소드 실행
				loginMember.getBookList().create(scan);
				break;
			}
			case 2 : {// 2. 뒤로 가기 : while문을 끝내고 이전 화면으로 돌아간다.
				this.mainMenu();
				break;
			}
			default :
				throw new Exception();
			}
		
			}catch(Exception e) {
			System.out.println("🚨 잘못된 입력입니다!");
			}
		
		}//WHILE
	}//	createMode

	

	// 4. readMode(1.전체목록보기 2.종이책만보기 3.전자책만보기 4.검색하기 5.뒤로가기)
	public void readMode() {
		boolean loop = true;
		while (loop) {
		System.out.println(
				"""
				╓=========================================❣️ 도서 목록 열람 ❣️=========================================╖
				
				         1. 전체 목록 보기      2. 전자책만 보기      3. 종이책만 보기      4. 도서 검색하기      5. 뒤로가기
				         
				╙================================================❣️================================================╜
				""");
			int readMenu = Integer.parseInt(scan.nextLine());
			switch (readMenu) {
			case 1: {// 전체목록 보기
				loginMember.getBookList().aBread(scan);
				break;
			}
			case 2: {// 전자책만 보기
				loginMember.getBookList().eBread();
				break;
			}
			case 3: {// 종이책만 보기
				loginMember.getBookList().pBread();
				break;
			}
			case 4: {// 도서 검색하기
				loginMember.getBookList().bFinder(scan);
				break;
			}
			case 5: {
				loop = false;
				this.mainMenu();
				break;
			}
			}

		}

	}

	// 5. updateMode(검색 후 객체 선택하여 수정하거나 삭제할 수 있게 메소드 짜둘 것.)
	public void updateMode() {
		boolean loop = true;
		System.out.println(
				"""
				╓=========================================❣️ 도서 목록 열람 ❣️=========================================╖

				                   1. 도서 정보 수정하기        2. 도서 정보 삭제하기        3. 뒤로가기

				╙================================================❣️================================================╜
				""");
		try {
			int upMenu = Integer.parseInt(scan.nextLine());
			switch (upMenu) {
			case 1: {
				
				
				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			default:
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("🚨 잘못된 입력입니다!");
		}

	}

}
