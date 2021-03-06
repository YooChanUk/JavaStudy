package MidFixStudent;
import java.util.Scanner;

public class ShowSearch //보기 또는 검색
{
	public void list(Student[] std)//전부 출력해서 보기
	{
		System.out.println("     학번 이름 주소 입학년도 생년월일");
		
		for(int i = 0; i < std.length; i++)
		{
			std[i].AllShow();
		}
	}
	
	public void numSearch(Student[] std)// 학번으로 검색
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		System.out.print("검색할 학번을 입력해주세요 : ");
		n = sc.nextInt();
		
		for(int i = 0; i < std.length; i++)
		{
			if(n == std[i].getStdnum())
			{
				std[i].AllShow();
			}
		}
	}
	
	public void nameSearch(Student[] std) // 이름으로 검색
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름 입력 : ");
		String name = new String(sc.next());
		
		for(int i = 0; i < std.length; i++)
		{
			if(name.equals(std[i].getName()))
			{
				std[i].AllShow();
			}
		}
	}
	
	public void sort(Student[] std) // 나이 순 정렬해서 보기
	{
		int tmp = 0;
		String tmpS = null;
		
		for(int i = 0; i < std.length; i++)
		{
			for(int j = 0; j < std.length; j++)
			{
				if(std[i].getBirthday() < std[j].getBirthday())
				{
					//이름 정렬
					tmpS = new String(std[i].getName());
					std[i].setName(std[j].getName());
					std[j].setName(tmpS);
					
					//주소 정렬
					tmpS = new String(std[i].getAdress());
					std[i].setAdress(std[j].getAdress());
					std[j].setAdress(tmpS);
					
					//학번 정렬
					tmp = std[i].getStdnum();
					std[i].setStdnum(std[j].getStdnum());
					std[j].setStdnum(tmp);
					
					//입학년도 정렬
					tmp = std[i].getSchoolyear();
					std[i].setSchoolyear(std[j].getSchoolyear());
					std[j].setSchoolyear(tmp);
					
					//생년월일 정렬
					tmp = std[i].getBirthday();
					std[i].setBirthday(std[j].getBirthday());
					std[j].setBirthday(tmp);
				}
			}
		}
		
		for(int i = 0; i < std.length; i++)
		{
			std[i].AllShow();
		}
	}
}
