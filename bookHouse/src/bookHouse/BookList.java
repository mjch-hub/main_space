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
		private List<Book> bookList = new ArrayList<Book>();
		public void bookList(List<Book> bookList) {
			this.bookList = bookList;
		}
		
	//더미데이터
	BookList(){
			bookList.add(new Book("전자책1","저자1",100,"출판사1","20101010",1));
			bookList.add(new Book("전자책2","저자2",100,"출판사1","20111111",1));
			bookList.add(new Book("종이책1","저자3",0,"출판사2","20120202",2));
			bookList.add(new Book("종이책2","저자4",0,"출판사2","20130303",2));
	}
		
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
			
			bookList.add(newBook);
			System.out.println("✔ 신규 도서 추가 완료!");
			
		}
		
		//3. 전체 북 리스트를 출력하는 aBread 메소드
		public void aBread(Scanner scan) {
			boolean loop = true;
			
			while(loop) {
				for(Book book : bookList) {
					book.bookInfo();	
				}//for
				sortAndmodify(scan);
				break;
			}	
		}
		
		//4. bookList 중 e-book만 출력하는 eBRead 메소드 (filter 활용할 것!)
		public void eBread() {
			bookList.stream().filter(book -> book.isEbook()).forEach(book -> book.bookInfo());
			
			/*list명.steam하면 stream형으로 리턴하겠다는 의미.
			 * stream형으로 리턴한다는 건 반복처리할 준비가 되었다는 소리.
			 */
			
			/*
			books.stream()
			.filter(book -> book.isEbook())//책2권
			 book을 줄테니 true or false를 리턴하라.
		     * 그리고 isEbook이 true일 때만 걸러내어 리턴하라는 의미. 
			.forEach(book-> System.out.println(book)); 
			sysout(book)을 메소드 호출로 변형하면 될 듯...
			*/
			
		}
		
		//5. bookList 중 e-book이 아닌 책만 출력하는 pBRead 메소드 (filter 활용할 것!)
		public void pBread() {//filter문을 활용하되 book.isEbook()에 false가 들어가도록 할 것.
			bookList.stream().filter(book -> book.isEbook()==false).forEach(book -> book.bookInfo());
			
			
			
		}
		
		//6. 책 검색 메소드 bFinder 메소드
		public void bFinder(Scanner scan) {
			boolean loop = true;
			while(loop) {
				System.out.println("도서 검색을 시작합니다.");
				System.out.println("검색 방법을 선택해주세요.");
				System.out.println(
						"""
						╓==========================================❣️ 도서 검색하기 ❣️=========================================╖
						
						         1. 제목으로 검색      2. 저자로 검색      3. 출판사로 검색      4. 도서 번호로 검색      5. 뒤로가기
						         
						╙================================================❣️================================================╜
						""");
				
				int fMenu = Integer.parseInt(scan.nextLine());
				switch(fMenu) {
				case 1 : {
					this.titleFinder(bookList, scan);
					break;
				}
				case 2 : {
					this.authorFinder(bookList, scan);
					break;
				}
				case 3 : {
					this.publisherFinder(bookList, scan);
					break;
				}
				case 4 : {
					this.indexFinder(bookList, scan);
					break;
				}
				case 5 : {
					loop = false;
					
					break;
				}
				
				}
				
				
			}
			
		}
		
		//7. 책의 제목으로 검색할 수 있는 기능을 지닌 titleFinder 메소드
		public void titleFinder(List<Book> bookList,Scanner scan) {
			boolean loop = true;
			while(loop) {
				System.out.println("제목을 입력해주세요 : ");
				String searchTitle = scan.nextLine();
				//정렬 메소드 자리
				for(Book book : bookList) {
					if(book.getTitle().contains(searchTitle)) {
						book.bookInfo();
					}
					}
				}	
				
			}
			
		//8. 책을 저자명으로 검색할 수 있는 기능을 가진 authorFinder 메소드
		public void authorFinder(List<Book> bookList,Scanner scan) {
			boolean loop = true;
			while(loop) {
				System.out.println("저자를 입력해주세요 : ");
				String searchAuthor = scan.nextLine();
				//정렬메소드 자리
				for(Book book : bookList) {
					if(book.getAuthor().contains(searchAuthor)) {
						book.bookInfo();
					}
				}
				
			}
		
		}
			
		//9. 책을 출판사명으로 검색할 수 있는 기능을 가진 publisherFinder 메소드
		public void publisherFinder(List<Book> bookList,Scanner scan) {
			boolean loop = true;
			while(loop) {
				System.out.println("출판사명을 입력해주세요 : ");
				String searchPublisher = scan.nextLine();
				//정렬메소드 자리
				for(Book book : bookList) {
					if(book.getPublisher().contains(searchPublisher)) {
						book.bookInfo();
					}
				}
			}
			
		}
		
		//10. 책을 도서번호(index)로 검색할 수 있는 기능을 지닌 indexFinder 메소드
		public void indexFinder(List<Book> bookList,Scanner scan) {
			boolean loop = true;
			
				System.out.println("도서번호를 입력해주세요 : ");
				String searchIndex = scan.nextLine();
				//정렬메소드 자리
				for(Book book : bookList) {
					if(book.getIndex()==Integer.parseInt(searchIndex)) {
						book.bookInfo();
						}	
				}
			}
			
		//11. 정렬,수정,삭제 선택 메소드
		public void sortAndmodify (Scanner scan) {
			//수정 모드에 필요한 것.
			//1. 정렬,수정, 삭제를 선택하는 switch문
			//2. 가격 수정 메소드 호출 : 메소드 호출을 위한 접근경로(책리스트)
			//3. 북 객체 삭제 메소드 호출.
			System.out.println(
			"""
			╓=======================================❣️ 도서 관리 ❣️============================================╖
			
			       1.제목순으로 정렬      2.가격순으로 정렬      3.최신순으로 정렬      4.책 수정하기      5.책 삭제하기
			       
			╙=============================================❣️================================================╜		
			"""		
					
			);
			
			int select = Integer.parseInt(scan.nextLine());
			//int index = Integer.parseInt(scan.nextLine());
			//int price = Integer.parseInt(scan.nextLine());
			
			switch(select) {
			case 1 : {//1.제목순으로 정렬  
				
				break;
			}
			case 2 : {//2.가격순으로 정렬  
				
				break;
			}
			case 3 : {//3.최신순으로 정렬
				
				break;
			}
			case 4 : {//4.책 수정하기
				updatePrice(scan);
				
				break;
			}
			case 5 : {//5.책 삭제하기
				deleteB(scan);
				break;
			}
			}//switch
		}
		
		//12. 가격수정 메소드
		public void updatePrice(Scanner scan) {
			
			/*0.리스트 출력.(선결조건)
			 *1.수정하고 싶은 도서번호를 입력받음.
			 *2.입력 받은 값을 getIndex(입력받은도서번호)을 이용해 해당 도서번호를 가진 책을 불러옴.
			 *3.수정하고 싶은 가격을 입력받음.
			 *4.선택된 책에 대해 setPrice(입력받은가격)로 접근하여 가격을 수정.(단 0원 이하는 되지 않도록 설정!)
			 *5.수정된 책 정보를 출력!
			 */
			
			
				//1. 수정하고 싶은 도서번호를 입력받음.
				System.out.println("수정하고 싶은 도서의 도서번호를 입력해주세요 : ");
				int pickIndex = Integer.parseInt(scan.nextLine());
				
				//2.입력 받은 값을 getIndex(입력받은도서번호)을 이용해 해당 도서번호를 가진 책을 불러옴.
				Book selectBook = bookList.get(pickIndex);
				
				//3.수정하고 싶은 가격을 입력받음.
				System.out.println("가격을 수정해 주세요 : ");
				int newPrice = Integer.parseInt(scan.nextLine());
				
				//4.선택된 책에 대해 setPrice(입력받은가격)로 접근하여 가격을 수정.(단 0원 이하는 되지 않도록 설정!)
				if(newPrice > 0) {
					selectBook.setPrice(newPrice);
					System.out.println("✔ 수정 완료!");
					selectBook.bookInfo();
				}else {
					System.out.println("잘못된 값입니다.");
				
				
				
			}
			
			
			
			
			
			
		}
		
		//13. 책을 삭제할 수 있는 deleteB 메소드
		public void deleteB(Scanner scan) {
			//1. 수정하고 싶은 도서번호를 입력받음.
			System.out.println("삭제하고 싶은 도서의 도서번호를 입력해주세요 : ");
			int pickIndex = Integer.parseInt(scan.nextLine());
			
			//2.입력 받은 값을 getIndex(입력받은도서번호)을 이용해 해당 도서번호를 가진 책을 불러옴.
			Book selectBook = bookList.get(pickIndex);
			
			//bonus.
			System.out.println("해당 도서를 정말 삭제하시겠습니까? : 1.예  2.아니오");
			int pickDel = Integer.parseInt(scan.nextLine());
			switch(pickDel) {
			case 1 : {
				
				//3. 선택된 책에 대해 remove()로 접근하여 객체를 삭제.
				bookList.remove(pickIndex);
				System.out.println("✔ 삭제 완료!");
				for(Book book : bookList) {
					book.bookInfo();	
				}
				break;
			}
			case 2 : {
				
				break;
			}
			}	
		}
		
		//14-1. 책을 제목순으로 정렬
		
		
		//14-2. 책을 가격순(오름차순)으로 정렬
		
		
		//14-3. 책을 최신순으로 정렬
		
		
		//15. 오늘의 책을 추천해주는 randomBook 메소드
		public void randomBook() {
			
		}
}
