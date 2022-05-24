package kunsan.psback0.lecture04;
import java.util.Scanner;
import java.math.*;

public class StudentTest 
{
	
	public void Menu()
	{
		StundentNum def = new StundentNum();
		StudentList sl = new StudentList();
		Search s = new Search();
		HighLow hl = new HighLow();
		AvgMid am = new AvgMid();
		UseSort us = new UseSort();
		Scanner sc = new Scanner(System.in);
		
		int select = 0;
		int result[] = null;
		
		while(true)
		{
			System.out.println("<학생 성적 처리 프로그램>");
			System.out.println("1) 학생 성적 입력");
			System.out.println("2) 학생 전체 성적 리스트 보기");
			System.out.println("3) 학생의 번호로 성적 보기");
			System.out.println("4) 성적 최고 점수, 최저 점수 보기");
			System.out.println("5) 성적 평균 점수, 중위값 점수 보기");
			System.out.println("6) 성적 정렬해서 보기");
			System.out.println("0) 메인 메뉴로 돌아감(종료)");
			System.out.print("메뉴를 선택하십시오 : ");
			select = sc.nextInt();
			
			switch(select)
			{
			case 1:
				result = def.input();
				break;
			case 2:
				sl.list(result);
				break;
			case 3:
				s.find(result);
				break;
			case 4:
				hl.check(result);
				break;
			case 5:
				am.Cal(result);
				break;
			case 6:
				us.sort(result);
				break;
			case 0:
				System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				System.out.println("학생 성적 처리를 종료합니다.\n");
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
		StudentTest st = new StudentTest();
		st.Menu();

	}*/

}
