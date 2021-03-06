package MidFixStudent;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StdManage 
{
	Student[] getStudent()
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String Name, Adress;
		int Stdnum, Schoolyear, birthday;
		
		System.out.print("몇명의 학생이 있습니까? : ");
		n = sc.nextInt();
		
		Student[] std = new Student[n];
		
		for(int i = 0; i < std.length; i++)
		{
			System.out.print(i+"번째 학생 : ");
			
			Stdnum = sc.nextInt();
			Name = sc.next();
			Adress = sc.next();
			Schoolyear = sc.nextInt();
			birthday = sc.nextInt();
			
			std[i] = new Student(Name,Adress,Stdnum,Schoolyear,birthday);
		}
		
		return std;
	}
	
	public void setCRUD(Student[] std)
	{
		int select = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. Create");
			System.out.println("2. Update");
			System.out.println("3. Delect");
			System.out.println("0. CRUD종료");
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
			case 1: Create(std);
				break;
			case 2: Update(std);
				break;
			case 3: Delect(std);
				break;
			case 0:
				System.out.println("종료합니다.");
				sc.close();
				return;
			}
		}
	}
	
	public void Create(Student[] std)
	{
		
	}
	
	public void Update(Student[] std)
	{
		
	}
	
	public void Delect(Student[] std)
	{
		
	}
	
}
