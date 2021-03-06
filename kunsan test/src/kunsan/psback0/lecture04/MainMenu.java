package kunsan.psback0.lecture04;
import java.lang.*;
import java.util.Scanner;
import java.util.*;

public class MainMenu
{
	public void menu()
	{
		Scanner sc = new Scanner(System.in);
		
		CoffeePrice cp = new CoffeePrice();
		WhileSample ws = new WhileSample();
		DoWhileSample ds = new DoWhileSample();
		ForSum fs = new ForSum();
		NestedLoop nl = new NestedLoop();
		Run99Simple ns = new Run99Simple();
		StudentTest st = new StudentTest();
		BookManagement bm = new BookManagement();
		DevideByZeroHanding dz = new DevideByZeroHanding();
		UnivManagement um = new UnivManagement();
		UnivManagementArray uma = new UnivManagementArray();
		MemberManagement mm = new MemberManagement();
		
		Member n = null;
		
		int menuSelect = 0;
		
		 n = mm.login();
		
		while(true)
		{
			
			System.out.println("o 다음의 프로그램들 중에서 수행할 함수를 선택하세요.");
			System.out.println("0) 회원 관리 프로그램");
			System.out.println("1) 커피 메뉴를 넣으면 가격을 출력해 주는 프로그램");
			System.out.println("2) 입력된 수의 평균과 갯수 구하기해서 화면에 프린트하기");
			System.out.println("3) 알파벳 A부터 Z까지 프린트하기");
			System.out.println("4) 정수 x와 y를 입력받아, x부터 y까지 더하는 과정과 결과 보이기");
			System.out.println("5) 99단 단순 찍기");
			System.out.println("6) 99단 출력단수와 수의 범위 설정해서 프린트하기");
			System.out.println("7) 예외처리(0으로 나누거나 정수가 아닌 수를 넣을시 오류 검출)");
			System.out.println("8) 학생성적처리 프로그램");
			System.out.println("9) 책 관리 프로그램");
			System.out.println("10) 대학 구성원 관리 프로그램");
			System.out.println("11) 대학 구성원 관리 프로그램(Array)");
			System.out.println("12) 종료");
			System.out.print("선택 : ");
			try
			{
				menuSelect = sc.nextInt();	
			}
			catch(InputMismatchException e)
			{
				System.out.println("정수 값을 입력해주세요.");
				sc.next();
				continue;
			}
			
			switch(menuSelect)
			{
				case 0 : mm.Menu(n);
					break;
				case 1 : cp.calcPrice();
					break;
				case 2 : ws.getAverage();
					break;
				case 3 : ds.printAtoZ();
					break;
				case 4 : fs.printSum();
					break;
				case 5 : nl.run99();
					break;
				case 6 : ns.doDialog();
					break;
				case 7 : dz.testSafeException();
					break;
				case 8 : st.Menu();
					break;
				case 9 : bm.Menu(null);
					break;
				case 10 : um.Menu();
					break;
				case 11 : uma.Menu();
					break;
				case 12 :
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
					System.out.println("프로그램을 종료합니다.\n");
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
					
					return;
				default : 
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
					System.out.println("메뉴에 해당하지 않는 입력입니다. 다시 입력해주세요.\n");
					System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
				
			}
		}
		
		
	}
	
	public static void main(String args[])
	{
		MainMenu mm = new MainMenu();
		mm.menu();
	}
	
}