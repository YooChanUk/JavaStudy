package kunsan.psback0.lecture04;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManagement 
{
	public void Menu(Book[] books)
	{
		BookManager bm = new BookManager();
		BookList bl = new BookList();
		HighLow hl = new HighLow();
		AvgMid av = new AvgMid();
		TitleSearch ts = new TitleSearch();
		UseSort us = new UseSort();
		Scanner sc = new Scanner(System.in);
		int select = 0;
		
		while(true)
		{
			System.out.println("<클래스 기반 Book관리 프로그램>");
			System.out.println("1) Book 입력");
			System.out.println("2) Book 전체 리스트 보기");
			System.out.println("3) Book 번호로 보기");
			System.out.println("4) 최고 가격, 최저 가격 보기");
			System.out.println("5) 평균 가격, 중위 가격 보기");
			System.out.println("6) 제목순 정렬해서 보기");
			System.out.println("7) 제목으로 검색");
			System.out.println("0) 메인 메뉴로 돌아감(종료)");
			System.out.print("메뉴를 선택하십시오 : ");
			try
			{
				select = sc.nextInt();	
			}
			catch(InputMismatchException e)
			{
				System.out.println("정수 값을 입력해주세요.");
				sc.next();
				continue;
			}
			
			
			switch(select)
			{
			case 1:
				books = bm.getBooks();
				break;
			case 2:
				bm.printBooks(books);
				break;
			case 3:
				bl.BookFull(books);
				break;
			case 4:
				hl.BookCheck(books);
				break;
			case 5:
				av.BookCal(books);
				break;
			case 6:
				us.Booksort(books);
				break;
			case 7:
				ts.searchTitle(books);
				break;
			case 0:
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				System.out.println("책 관리를 종료합니다.\n");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				
				return;
			default :
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				System.out.println("메뉴에 해당하지 않는 입력입니다. 다시 입력해주세요.\n");
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			}
		}
	}
			
	
	/*public static void main(String[] args) 
	{
		BookManagement bmm = new BookManagement();
		bmm.Menu(null);
	}*/

}
