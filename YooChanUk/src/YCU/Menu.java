package YCU;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu 
{
	public void menu()
	{
		Scanner sc = new Scanner(System.in);
		
		CompactDisc[] cd = null;
		CompactDiscManage cdm = new CompactDiscManage();
		ShowSearch ss = new ShowSearch();
		
		int select = 0;
			
		while(true)
		{
			System.out.println("1) CompactDisc 데이터 입력");
			System.out.println("2) CompactDisc 리스트 보기");
			System.out.println("3) CompactDisc 가수명으로 보기");
			System.out.println("4) CompactDisc 정보 삭제");
			System.out.println("5) 가격 범위로 검색");
			System.out.println("6) 음반명순으로 정렬해서 보기");
			System.out.println("7) 음반 재고 변경");
			System.out.println("8) 음반 정보 수정하기");
			System.out.println("0) 종료");
			System.out.print("선택 : ");
			try
			{
				select = sc.nextInt();
			
				switch(select)
				{
				case 1: cd = cdm.getCompactDisc();
					break;
				case 2:	ss.showList(cd);
					break;
				case 3: ss.showArtistName(cd);
					break;
				case 4: cdm.cdDelect(cd);
					break;
				case 5: ss.haveNumSearch(cd);
					break;
				case 6: ss.songNameSort(cd);
					break;
				case 7: cdm.haveNumUpdate(cd);
					break;
				case 8: cdm.compactDiscModify(cd);
					break;
				case 0:
					sc.close();
					System.out.println("시스템을 종료합니다.");
					return;
				default : 
					System.out.println("없는 번호 입니다.");
					
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 입력값 입니다.");
				sc.next();
				continue;
			}
			catch(NullPointerException e)
			{
				System.out.println("학생 데이터를 입력하지 않고 검색하셨습니다.(Null Error)");
			}
		}

	}
		
		
	public static void main(String[] args) 
	{
		Menu m = new Menu();
		m.menu();
	}

}
