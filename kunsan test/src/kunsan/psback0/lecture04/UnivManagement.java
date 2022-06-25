package kunsan.psback0.lecture04;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UnivManagement 
{
	Scanner sc = new Scanner(System.in);
	
	public Person inputInformation() // ref 생성 함수
	{
		Person ps = null;
		
		String citizenNumber = null ,name = null;
		int birthYear = -1;
		String studentNumber = null, dept = null;
		String employeeNumber = null, position = null;
		int kind = -1; // 1.사람 2.학생 3.연구원 4.교수
		
		try
		{
			for(;kind <= 0;)
			{
				System.out.print("어떤 사람인가요.(1.사람 2.학생 3.연구원 4.교수) : ");
				kind = sc.nextInt();
				sc.nextLine();
				
				if(kind <= 0)
				{
					System.out.println("0보다 낮은 숫자의 종류는 없습니다.");
					//continue;
				}
				if(kind > 4)
				{
					System.out.println("4보다 큰 숫자의 종류는 없습니다.");
					kind = -1;
				}
			}

			
			System.out.print("주민등록 입력 : ");
			citizenNumber = sc.next();
			System.out.print("이름 입력 : ");
			name = sc.next();
			
			for(;birthYear <= 0;)
			{
				System.out.print("생년월일 입력 : ");
				birthYear = sc.nextInt();
				sc.nextLine();
				
				if(birthYear <= 0)
				{
					System.out.println("생년월일은 0보다 낮을 수 없습니다.");
					//continue;
				}
			}

		}
		catch(InputMismatchException e)
		{
			System.out.println("잘못된 입력 입니다.");
			sc.next();
		}

		
		
		switch(kind)
		{
		case 1 : ps = new Person(citizenNumber,name,birthYear, kind);
			break;
		case 2 : 
			System.out.print("학번 입력 : ");
			studentNumber = sc.next();
			System.out.print("과(부) 입력 : ");
			dept = sc.next();
			ps = new Student(citizenNumber,name,birthYear,studentNumber,dept,kind);
			break;
		case 3 : 
			System.out.print("연구원번호 입력 : ");
			employeeNumber = sc.next();
			System.out.print("과(부) 입력 : ");
			dept = sc.next();
			ps = new Researcher(citizenNumber,name,birthYear,employeeNumber,dept,kind);
			break;
		case 4 : 
			System.out.print("연구원번호 입력 : ");
			employeeNumber = sc.next();
			System.out.print("과(부) 입력 : ");
			dept = sc.next();
			System.out.print("직책 입력 : ");
			position = sc.next();
			ps = new Professor(citizenNumber,name,birthYear,employeeNumber,dept,position,kind);
			break;
		default : 
			System.out.println("없는 번호 입니다.");
			break;
		}
		return ps;
	}
	
	public Person[] createPersonArr() // 1번 메뉴 만들어진 객체에 ref 밀어넣기
	{
		Person[] psArr = null;
		int n = -1;
		
		for(; n<= 0;)
		{
			System.out.print("몇명의 사람이 있나요?");
			try
			{
				n = sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 정보를 입력하셨습니다.");
				continue;
			}

			
			if(n <= 0)
			{
				System.out.println("사람의 숫자는 0이거나 음수 일 수 없습니다.");
			}
		}

		
		psArr = new Person[n];
		
		for(int i = 0; i < psArr.length; i++)
		{
			psArr[i] = inputInformation();
		}
		
		return psArr;
	}
	
	public void printAll(Person[] psArr) // 2번 메뉴 전체출력
	{
		Person[] clonepsArr = psArr;
		
		System.out.println("정렬 순서를 골라주세요");
		System.out.print("1.전체보기 2.birthyear순 보기 3.이름순 보기 4.이름 역순으로 보기 :");
		int n = -1;
		
		for(; n<= 0;)
		{
			try
			{
				n = sc.nextInt();
				sc.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 입력값입니다.");
			}
		}


		
		switch(n)
		{
		case 1:
			Arrays.sort(clonepsArr);//interface Comparable 
			
	        for(Person p : clonepsArr )
	        {
	        	toStr(p);
	        }
			break;
		case 2:
			class ComparePerson implements Comparator<Person>
			{
				@Override
				public int compare(Person p1, Person p2) 
				{
					if(p1.getBirthYear() < p2.getBirthYear())
						return -1;
					if(p1.getBirthYear() > p2.getBirthYear())
						return 1;
					return 0;
				}
			}
			
			Arrays.sort(clonepsArr,new ComparePerson());

	        for(Person p : clonepsArr )
	        {
	        	toStr(p);
	        }
			break;
		case 3:
			class ComparePerson implements Comparator<Person>
			{
				@Override
				public int compare(Person p1, Person p2) 
				{
					return p1.getName().compareTo(p2.getName());
				}
			}
			
			Arrays.sort(clonepsArr,new ComparePerson());
			
	        for(Person p : clonepsArr )
	        {
	        	toStr(p);
	        }
			break;
		case 4:
			class ComparePerson implements Comparator<Person>
			{
				@Override
				public int compare(Person p1, Person p2) 
				{
					return p1.getName().compareTo(p2.getName());
				}
			}
			
			Arrays.sort(clonepsArr,new ComparePerson().reversed());
			
	        for(Person p : clonepsArr )
	        {
	        	toStr(p);
	        }
			break;
		}
		

	}
	
	public void toStr(Person psArr)
	{	
    	if(psArr instanceof Professor)
		    System.out.print(((Professor)psArr).toString());
    	else if(psArr instanceof Researcher)
		    System.out.print(((Researcher)psArr).toString());
    	else if(psArr instanceof Student)
		    System.out.print(((Student)psArr).toString());
    	else if(psArr instanceof Person)
		    System.out.print(psArr.toString());
	     
	    System.out.println();
	}
	
	public void conditionSearch(Person[] psArr) // 3번 메뉴 조건검색
	{
		int n = -1;
		
		for(; n<= 0;)
		{
			System.out.println("1. 이름으로 검색  2. 나이로 검색  3.birthYear 범위로 검색");
			System.out.print("숫자를 입력해주세요 : ");
			n = sc.nextInt();
			
			if(n <= 0)
			{
				System.out.println("조건검색시 0보다 이하인 숫자는 입력 불가합니다.");
			}
			if(n > 3)
			{
				System.out.println("조건검색시 3을 초과한 숫자는 입력 불가합니다.");
				n = -1;
			}
		}
		
		
		switch(n)
		{
		case 1 : nameSearch(psArr);
			break;
		case 2 : birthYearSearch(psArr);
			break;
		case 3 : birthYearRangeSearch(psArr);
			break;
		}
	}
	
	public void nameSearch(Person[] psArr) // 3 - 1 이름검색
	{
		String name = null;
		
		System.out.print("검색할 이름을 입력해주세요 : ");
		name = sc.next();
		
		for(int i = 0; i < psArr.length; i++)
		{
			if(psArr[i].getName().equals(name))
			{
				toStr(psArr[i]);
			}
		}
	}
	
	public void birthYearSearch(Person[] psArr) // 3 - 2 생년월일 검색
	{
		int birthyear = -1;
		
		for(; birthyear <= 0;)
		{
			System.out.print("생년월일 입력 : ");
			birthyear = sc.nextInt();
			sc.nextLine();
			
			if(birthyear <= 0)
			{
				System.out.println("생년월일은 0보다 낮을 수 없습니다.");
				//continue;
			}
		}
		
		
		for(int i = 0; i < psArr.length; i++)
		{
			if(psArr[i].getBirthYear() == birthyear)
			{
				toStr(psArr[i]);
			}
		}
	}
	
	public void birthYearRangeSearch(Person[] psArr) // 3 - 3 생년월일범위 검색
	{
		int minbirthyear = -1;
		int maxbirthyear = -1;
		
		for(; minbirthyear <= 0;)
		{
			System.out.print("최소생년월일 입력 : ");
			minbirthyear = sc.nextInt();
			sc.nextLine();
			
			if(minbirthyear <= 0)
			{
				System.out.println("최소생년월일은 0보다 낮을 수 없습니다.");
				//continue;
			}
		}
		
		for(; maxbirthyear <= 0;)
		{
			System.out.print("최대생년월일 입력 : ");
			maxbirthyear = sc.nextInt();
			sc.nextLine();
			
			if(maxbirthyear <= 0)
			{
				System.out.println("최대생년월일은 0보다 낮을 수 없습니다.");
				//continue;
			}
		}
		
		if(minbirthyear >= maxbirthyear) // 최소가 최대보다 높거나 같은경우 또는 최대가 최소보다 낮거나 같은 경우 
		{
			System.out.println("범위 입력이 잘못되었습니다 다시 입력하십시오.");
			birthYearRangeSearch(psArr); //재귀
		}
		
		
		for(int i = 0; i < psArr.length; i++)
		{
			if(psArr[i].getBirthYear() >= minbirthyear && psArr[i].getBirthYear() <= maxbirthyear)
			{
				toStr(psArr[i]);
			}
		}
	}
	
	public void dataModify(Person[] psArr) // 4번 메뉴 데이터변경
	{
		String citizenNumber = null ,name = null;
		int birthYear = -1;
		String studentNumber = null, dept = null;
		String employeeNumber = null, position = null;
		int select = -1;
		
		String upname = null;
		int upi = -1;
		
		System.out.print("변경할 사람의 이름을 입력해주세요 : ");
		upname = sc.next();
		
		for(int i = 0; i < psArr.length; i++)//입력된 이름의 객체 번호 저장
		{
			if(psArr[i].getName().equals(upname))
			{
				upi = i;
				System.out.print("수정할 사람은 : ");
				System.out.println(psArr[i].toString());
			}
		}
		
		if(upi != -1)
		{
			try 
			{
				System.out.print("수정할 주민등록 입력 : ");
				citizenNumber = sc.next();
				System.out.print("수정할 이름 입력 : ");
				name = sc.next();
				
				for(;birthYear <= 0;)
				{
					System.out.print("수정할 생년월일 입력 : ");
					birthYear = sc.nextInt();
					sc.nextLine();
					
					if(birthYear <= 0)
					{
						System.out.println("생년월일은 0보다 낮을 수 없습니다.");
						//continue;
					}
				}

			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 입력 입니다.");
				sc.next();
			}

			
			
			psArr[upi].setBirthYear(birthYear);
			psArr[upi].setCitizenNumber(citizenNumber);
			psArr[upi].setName(name);
			
	    	if(psArr[upi] instanceof Professor)
	    	{
				System.out.print("연구원번호 입력 : ");
				employeeNumber = sc.next();
				System.out.print("과(부) 입력 : ");
				dept = sc.next();
				System.out.print("직책 입력 : ");
				position = sc.next();
	    		
	    		((Professor)psArr[upi]).setEmployeeNumber(employeeNumber);
	    		((Professor)psArr[upi]).setDept(dept);
	    		((Professor)psArr[upi]).setPosition(position);
	    	}
	    	else if(psArr[upi] instanceof Researcher)
	    	{
				System.out.print("연구원번호 입력 : ");
				employeeNumber = sc.next();
				System.out.print("과(부) 입력 : ");
				dept = sc.next();
	    		
	    		((Researcher)psArr[upi]).setEmployeeNumber(employeeNumber);
	    		((Researcher)psArr[upi]).setDept(dept);
	    	}
	    	else if(psArr[upi] instanceof Student)
	    	{
				System.out.print("수정할 학번 입력 : ");
				studentNumber = sc.next();
				System.out.print("수정할 과(부) 입력 : ");
				dept = sc.next();
	    		
	    		((Student)psArr[upi]).setStudentNumber(studentNumber);
	    		((Student)psArr[upi]).setDept(dept);
	    	}
	    	
		}
		
		
	}
	
	public Person[] dataDelete(Person[] psArr) // 5번 메뉴 데이터삭제
	{
		System.out.print("삭제할 사람 이름 : ");
		String name = sc.next();
		
		Person[] dpsArr = null;
		
		int delnum = 0; // 삭제할 사람의 배열 번호
		int tmp = 0;
		
		for(int i = 0; i < psArr.length; i++)
		{
			if(psArr[i].getName().equals(name))
			{	
				delnum = i;
			}
					
		}
		
		dpsArr = new Person[psArr.length - 1];
		
		for(int i = 0; i < dpsArr.length; i++)
		{
			if(delnum == i)
			{
				tmp++;
			}
			
			dpsArr[i] = psArr[tmp];
			tmp++;
			

		}
		
		for(int i = 0; i < dpsArr.length; i++)
		{
			System.out.println(dpsArr[i].toString());
		}
		
		return dpsArr;
	}
	
	public void Menu()
	{
		int select = 0;
		Person[] psArr = null;
		
		while(true)
		{
			System.out.println("1) 대학 구성원 데이터 입력");
			System.out.println("2) 대학 구성원 데이터 전체 출력");
			System.out.println("3) 대학 구성원 데이터 조건 검색");
			System.out.println("4) 대학 구성원 데이터 변경");
			System.out.println("5) 대학 구성원 데이터 삭제");
			System.out.print("선택 : ");
			try
			{
				select = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("정확한 값을 입력해주세요.");
				sc.next();
			}

			
			switch(select)
			{
			case 1 : psArr = createPersonArr();
				break;
			case 2 : printAll(psArr);
				break;
			case 3 : conditionSearch(psArr);
				break;
			case 4 : dataModify(psArr);
				break;
			case 5 : psArr = dataDelete(psArr);
				break;
			case 0 : System.out.println("관리 프로그램을 종료합니다.");
				return;
			default : System.out.println("해당 되는 입력값이 없습니다.");
				break;
			}
		}
	}
}
