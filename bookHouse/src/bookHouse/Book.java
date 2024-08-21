package bookHouse;

public class Book {
	/*Book 클래스 구성 요소
	 * 1. 책 정보를 구성하는 변수(제목,저자,가격,출판사,출간일,전자책여부,도서번호)***캡슐화 할것!***
	 * 2. 책의 모든 변수를 포함하는 생성자
	 * 3. 책의 변수에 접근하기 위한 get&set 메소드
	 * 4. 책의 정보를 예쁘게 나열하는 toString 메소드
	 * 5. 책의 정보를 (isEbook)변수 결과에 따라 다르게 호출하는 메소드
	 * 6. 출력된 책들을 이름순으로 정렬하는 메소드(default)
	 * 7. 출력된 책들을 가격순(오름차순)으로 정렬하는 메소드 - 동일 가격일 시 이름순으로 정렬
	 * 8. 출력된 책들을 가격순(내림차순)으로 정렬하는 메소드 - 동일 가격일 시 이름순으로 정렬
	 * 9. 출력된 책들을 최신순(오름차순)으로 정렬하는 메소드 - 같은 날 출간 시 이름순으로 정렬 
	 */
	
	//1. 책 정보를 구성하는 변수(제목,저자,가격,출판사,출간일,전자책여부,도서번호)
	private String title;
	private String author;
	private int price;
	private String publisher;
	private String pubdate;
	
	private boolean isEbook;
	
	private int index = 0;
	public static int count = 0;
	
	//2. 책의 모든 변수를 포함하는 생성자
	Book(String title, String author, int price, String publisher, String pubdate, int isEbook){
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.isEbook = isEbook == 1? true : false;
		
		index = count++;
	}

	//3. 책의 변수에 접근하기 위한 get&set 메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public boolean isEbook() {
		return isEbook;
	}

	public void setEbook(boolean isEbook) {
		this.isEbook = isEbook;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Book.count = count;
	}

	
	
	
	//4. 책의 정보를 예쁘게 나열하는 toString 메소드
	@Override
	public String toString() {
		return index + "  [ " + title + " " + author + " 지음 " + price + " 원 " + publisher + " 출간일 : "
				+ pubdate ;
	}
	
	
	
	//5. 책의 정보를 (isEbook)변수 결과에 따라 다르게 호출하는 메소드
	public void bookInfo() {//isEbook이 true면 
		if(isEbook) {
			System.out.println( toString()+ " (E-book) ]");
		}else
		{
			System.out.println(toString()+ " ]");
		}
	}
	
	
}
