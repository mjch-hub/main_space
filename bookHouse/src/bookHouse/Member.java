package bookHouse;

import java.util.Scanner;

public class Member {
	/*Member 클래스 구성 요소
	 * 1. 회원 정보 변수(id,pw,BookList bookList-회원이 가질 책리스트 정보)***캡슐화 할 것***
	 * 2. 회원 정보 변수를 포함하는 생성자
	 * 3. 회원 정보 변수에 접근하기 위한 get&set 메소드
	  */
	
	//1. 회원 정보 변수(id,pw,BookList bookList-회원이 가질 책리스트 정보)
	private String id;
	private String pw;
	private BookList bookList;
	
	
	//2. 회원 정보 변수를 포함하는 생성자
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
		this.bookList = bookList;
		
	}


	
	
	//3. 회원 정보 변수에 접근하기 위한 get&set 메소드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public BookList getBookList() {
		return bookList;
	}

	public void setBookList(BookList bookList) {
		this.bookList = bookList;
	}




	
	
	
}
