package MidFixStudent;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu 
{
	public void menu()
	{
		Scanner sc = new Scanner(System.in);
		StdManage sm = new StdManage();
		ShowSearch ss = new ShowSearch();
		ShowCompare scc = new ShowCompare();
		
		Student[] std = null;
		
		int select = 0;
		
		while(true)
		{
			System.out.println("1. Student 데이터 입력");
			System.out.println("2. Student 리스트 보기");
			System.out.println("3. Student 번호로 보기");
			System.out.println("4. 최고령자, 최저연령자 보기");
			System.out.println("5. 평균입학년도, 중위입학년도 보기");
			System.out.println("6. 나이순 정렬해서 보기");
			System.out.println("7. 이름으로 검색");
			System.out.println("8. CRUD 실행");
			System.out.println("0. 종료");
			System.out.print("선택 : ");
			
			try
			{
				select = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 값을 입력하였습니다.");
				sc.next();
				continue;
			}

			
			switch(select)
			{
			case 1: std = sm.getStudent();
				break;
			case 2: ss.list(std);
				break;
			case 3:	ss.numSearch(std);
				break;
			case 4: scc.birthdayCompare(std);
				break;
			case 5: scc.avgMid(std);
				break;
			case 6: ss.sort(std);
				break;
			case 7: ss.nameSearch(std);
				break;
			case 8: sm.setCRUD(std);
				break;
			case 0:
				System.out.println("종료합니다.");
				sc.close();
				return;
			}
		}
	}

	public static void main(String[] args) 
	{
		MainMenu mm = new MainMenu();
		mm.menu();
	}

}
