package bookHouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookList {
	/*BookList 클래스 구성 요소
	 * 1. Book클래스의 정보를 이용하여 만든 리스트 bookList
	 * 2. 새로운 책 객체 newBook을 생성하여 bookList에 넣는 create 메소드.
	 * 3. bookList를 전부 출력하는 aBRead 메소드
	 * 4. bookList 중 e-book만 출력하는 eBRead 메소드
	 * 5. bookList 중 e-book이 아닌 책만 출력하는 pBRead 메소드
	 * 6. 책 검색 모드(7,8번 메소드 포함)
	 * 7. 책의 제목으로 검색할 수 있는 기능을 지닌 titleFinder 메소드
	 * 8. 책을 도서번호(index)로 검색할 수 있는 기능을 지닌 indexFinder 메소드
	 * 9. 책의 정보를 수정할 수 있는 기능을 가진 updateB 메소드
	 * 10. 책을 삭제할 수 있는 deleteB 메소드
	 * 11. 오늘의 책을 추천해주는 randomBook 메소드
	 */
	
	
	// 1. Book클래스의 정보를 이용하여 만든 리스트 bookList
		List<Book> bookList = new ArrayList<Book>();
		
		//2. 새로운 책 객체 newBook을 생성하여 bookList에 넣는 create 메소드.
		public void create(Scanner scan) {
			System.out.println("제목을 입력 해주세요 : ");
			String title = scan.nextLine();
			
			System.out.println("저자를 입력 해주세요 : ");
			String author = scan.nextLine();
			
			System.out.println("가격을 입력 해주세요 : ");
			int price = Integer.parseInt(scan.nextLine());
			
			System.out.println("출판사를 입력 해주세요 : ");
			String publisher = scan.nextLine();
			
			System.out.println("출간일 8글자를 숫자로만 입력해주세요 : ");
			System.out.println("예 : xxxx.xx.xx -> x에 해당하는 부분만 입력!");
			String pubdate = scan.nextLine();
			boolean isNumeric = pubdate.matches("^[\\d]*$");
			if(isNumeric && pubdate.length() == 8) {	
			}
			
			System.out.println("전자책 입니까? : 1.예   2.아니오 ");
			int isEbook = Integer.parseInt(scan.nextLine());
			
			Book newBook = new Book(title,author,price,publisher,pubdate,isEbook);
					
			
		}
		
		//3. 북 리스트를 출력하는 read 메소드
		public void aBread() {
			for(Book book : bookList) {
				System.out.println(book);
			}
		}
		
		//4. bookList 중 e-book만 출력하는 eBRead 메소드
		public void eBread() {
			
		}
		
		//5. bookList 중 e-book이 아닌 책만 출력하는 pBRead 메소드
		public void pBread() {
			
		}
		
		//6. 책 검색 메소드 bFinder 메소드
		public void bFinder() {}
		
		
		//7. 책의 제목으로 검색할 수 있는 기능을 지닌 titleFinder 메소드
		public void titleFinder() {
			
		}
		
		//8. 책을 도서번호(index)로 검색할 수 있는 기능을 지닌 indexFinder 메소드
		public void indexFinder() {
			
		}
		
		//9. 책의 정보를 수정할 수 있는 기능을 가진 updateB 메소드
		public void updateB() {
			
		}
		
		//10. 책을 삭제할 수 있는 deleteB 메소드
		public void deleteB() {
			
		}
		
		//11. 오늘의 책을 추천해주는 randomBook 메소드
		public void randomBook() {
			
		}
}
