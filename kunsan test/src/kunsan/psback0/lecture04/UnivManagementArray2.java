package kunsan.psback0.lecture04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class UnivManagementArray2
{
	Scanner sc = new Scanner(System.in);
	ArrayList<Person> psArr = new ArrayList<Person>();
	String filepath = "Univ.txt";	
	
	public void inputInformation() // 1번 메뉴 사람 추가(추가니까 이어쓰기)
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
		case 1 : ps = new Person(citizenNumber,name,birthYear,kind);
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
		
		psArr.add(ps);
		writeData(ps,true);
	}

	
	public void printAll() // 2번 메뉴 전체출력
	{
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
			psArr.stream().forEach(System.out::println);
			break;
		case 2:
			psArr.stream().sorted((p1,p2) -> p1.getBirthYear()- p2.getBirthYear()).
			forEach(System.out::println);
			break;
		case 3:			
			psArr.stream().sorted((p1,p2) -> p1.getName().compareTo(p2.getName())).
			forEach(System.out::println);
			break;
		case 4:
			psArr.stream().sorted((p1,p2) -> p2.getName().compareTo(p1.getName())).
			forEach(System.out::println);
			break;
		}
		

	}
	
	public void conditionSearch() // 3번 메뉴 조건검색
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
		case 1 : nameSearch();
			break;
		case 2 : birthYearSearch();
			break;
		case 3 : birthYearRangeSearch();
			break;
		}
	}
	
	public void nameSearch() // 3 - 1 이름검색
	{
		System.out.print("검색할 이름을 입력해주세요 : ");
		String name = sc.next();	
		
		psArr.stream().filter(p -> p.getName().equals(name)).
		forEach(System.out::println);
	}
	
	public void birthYearSearch() // 3 - 2 생년월일 검색
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
			}
		}
		
		int copybirth = birthyear;
		
		psArr.stream().filter(p -> p.getBirthYear() == copybirth).
		forEach(System.out::println);
	}
	
	public void birthYearRangeSearch() // 3 - 3 생년월일범위 검색
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
			}
		}
		
		if(minbirthyear >= maxbirthyear) // 최소가 최대보다 높거나 같은경우 또는 최대가 최소보다 낮거나 같은 경우 
		{
			System.out.println("범위 입력이 잘못되었습니다 다시 입력하십시오.");
			birthYearRangeSearch(); //재귀
		}
		
		
		int streammin = minbirthyear;
		int streammax = maxbirthyear;
		
		psArr.stream().filter(p -> p.getBirthYear() >= streammin && 
				p.getBirthYear() <= streammax).forEach(System.out::println);
	}
	
	
	
	
	public void dataModify() // 4번 메뉴 데이터변경
	{
		String citizenNumber = null ,name = null;
		int birthYear = -1;
		String studentNumber = null, dept = null;
		String employeeNumber = null, position = null;
		int upi = -1;
		
		System.out.print("변경할 사람의 이름을 입력해주세요 : ");
		String upname = sc.next();
		
		for(int i = 0; i < psArr.size(); i++)//입력된 이름의 객체 번호 저장
		{
			if(psArr.get(i).getName().equals(upname))
			{
				upi = i;
				System.out.print("수정할 사람은 : ");
				System.out.println(psArr.get(i).toString());
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
					}
				}

			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 입력 입니다.");
				sc.next();
			}

			
			
			psArr.get(upi).setBirthYear(birthYear);
			psArr.get(upi).setCitizenNumber(citizenNumber);
			psArr.get(upi).setName(name);
			
	    	if(psArr.get(upi) instanceof Professor)
	    	{
				System.out.print("연구원번호 입력 : ");
				employeeNumber = sc.next();
				System.out.print("과(부) 입력 : ");
				dept = sc.next();
				System.out.print("직책 입력 : ");
				position = sc.next();
	    		
	    		((Professor)psArr.get(upi)).setEmployeeNumber(employeeNumber);
	    		((Professor)psArr.get(upi)).setDept(dept);
	    		((Professor)psArr.get(upi)).setPosition(position);
	    	}
	    	else if(psArr.get(upi) instanceof Researcher)
	    	{
				System.out.print("연구원번호 입력 : ");
				employeeNumber = sc.next();
				System.out.print("과(부) 입력 : ");
				dept = sc.next();
	    		
	    		((Researcher)psArr.get(upi)).setEmployeeNumber(employeeNumber);
	    		((Researcher)psArr.get(upi)).setDept(dept);
	    	}
	    	else if(psArr.get(upi) instanceof Student)
	    	{
				System.out.print("수정할 학번 입력 : ");
				studentNumber = sc.next();
				System.out.print("수정할 과(부) 입력 : ");
				dept = sc.next();
	    		
	    		((Student)psArr.get(upi)).setStudentNumber(studentNumber);
	    		((Student)psArr.get(upi)).setDept(dept);
	    	}
		}
		writeData(psArr);
	}
	
	public void dataDelete() // 5번 메뉴 데이터삭제
	{
		System.out.print("삭제할 사람 이름 : ");
		String name = sc.next();
		
		for(int i = 0; i < psArr.size(); i++)
		{
			if(psArr.get(i).getName().equals(name))
			{	
				psArr.remove(i);
			}
			
		}
	
		writeData(psArr);
		
		psArr.stream().forEach(System.out::println);
	}
	
	public void Menu()
	{
		readData();
		int select = 0;
		
		while(true)
		{
			System.out.println("1) 대학 구성원 데이터 입력");
			System.out.println("2) 대학 구성원 데이터 전체 출력");
			System.out.println("3) 대학 구성원 데이터 조건 검색");
			System.out.println("4) 대학 구성원 데이터 변경");
			System.out.println("5) 대학 구성원 데이터 삭제");
			System.out.println("0) 대학 관리 프로그램 종료");
			
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
			case 1 : inputInformation();
				break;
			case 2 : printAll();
				break;
			case 3 : conditionSearch();
				break;
			case 4 : dataModify();
				break;
			case 5 : dataDelete();
				break;
			case 0 : System.out.println("관리 프로그램을 종료합니다.");
				return;
			default : System.out.println("해당 되는 입력값이 없습니다.");
				break;
			}
		}
	}
	
	public void writeData(Object n) 
	{
		writeData(n,false);
	}

	public void writeData(Object ns,boolean isAppend) //수정용(덮어쓰기)
	{
		try 
		{
			FileOutputStream fop = new FileOutputStream(filepath, isAppend);
			DataOutputStream dos = new DataOutputStream(fop);
			
			int kind = -1;
			
			if(isAppend == true)
			{
				kind = ((Person)ns).getKind();
				dos.writeInt(((Person) ns).getKind());
				dos.writeUTF(((Person) ns).getCitizenNumber());
				dos.writeUTF(((Person) ns).getName());
				dos.writeInt(((Person) ns).getBirthYear());
				
				switch(kind)
				{
					case 1 :
						dos.writeUTF("\r \n");
						dos.close();
						break;

					case 2:
						dos.writeUTF(((Student) ns).getStudentNumber());
						dos.writeUTF(((Student) ns).getDept());
						dos.writeUTF("\r \n");
						dos.close();
						break;
					case 3:
						dos.writeUTF(((Researcher) ns).getEmployeeNumber());
						dos.writeUTF(((Researcher) ns).getDept());
						dos.writeUTF("\r \n");
						dos.close();
						break;
					case 4:
						dos.writeUTF(((Professor) ns).getEmployeeNumber());
						dos.writeUTF(((Professor) ns).getDept());
						dos.writeUTF(((Professor) ns).getPosition());
						dos.writeUTF("\r \n");
						dos.close();
						break;
					}
			}
			else if(isAppend == false)
			{
				for(Person ps : psArr)
				{
					kind = ((Person)ps).getKind();
					
					dos.writeInt((ps).getKind());
					dos.writeUTF((ps).getCitizenNumber());
					dos.writeUTF((ps).getName());
					dos.writeInt((ps).getBirthYear());
					
					switch(kind)
					{
						case 1 :
							dos.writeUTF("\n");
							break;
						case 2:
							dos.writeUTF(((Student) ps).getStudentNumber());
							dos.writeUTF(((Student) ps).getDept());
							dos.writeUTF("\n");
							break;
						case 3:
							dos.writeUTF(((Researcher) ps).getEmployeeNumber());
							dos.writeUTF(((Researcher) ps).getDept());
							dos.writeUTF("\n");
							break;
						case 4:
							dos.writeUTF(((Professor) ps).getEmployeeNumber());
							dos.writeUTF(((Professor) ps).getDept());
							dos.writeUTF(((Professor) ps).getPosition());
							dos.writeUTF("\n");
							break;
						}
				}
			}
			fop.close();
			dos.close();
		}
			
		catch (IOException e) 
		{
			System.out.println("DataIOTest : " + e);
		}
	}
	
	public void readData()
	{
		String citizenNumber = null ,name = null;
		int birthYear = -1;
		String studentNumber = null, dept = null;
		String employeeNumber = null, position = null;
		int kind = -1; // 1.사람 2.학생 3.연구원 4.교수
		boolean EOF = false;
		
		File f = new File(filepath);
		
		if(!f.exists()) // 파일이 존재하지 않을경우 파일 생성
		{
			FileOutputStream fop;
			
			try 
			{
				fop = new FileOutputStream(filepath);
				fop.close();
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
			
    // reading part
		try {
			FileInputStream fis = new FileInputStream(filepath);
			DataInputStream dis = new DataInputStream(fis);

			while (!EOF) 
			{
				try 
				{
					Person ps = null;
					kind = dis.readInt(); // 1.사람 2.학생 3.연구원 4.교수
					
					citizenNumber = dis.readUTF();
					name = dis.readUTF();
					birthYear = dis.readInt();
					
					switch(kind)
					{
					case 1 : 
						dis.readUTF();
						ps = new Person(citizenNumber,name,birthYear,kind);
						break;
					case 2 : 
						studentNumber = dis.readUTF();
						dept = dis.readUTF();
						dis.readUTF();
						ps = new Student(citizenNumber,name,birthYear,studentNumber,dept,kind);
						break;
					case 3:
						employeeNumber = dis.readUTF();
						dept = dis.readUTF();
						dis.readUTF();
						ps = new Researcher(citizenNumber,name,birthYear,employeeNumber,dept,kind);
						break;
					case 4:						
						employeeNumber = dis.readUTF();
						dept = dis.readUTF();
						position = dis.readUTF();
						dis.readUTF();
						ps = new Professor(citizenNumber,name,birthYear,employeeNumber,dept,position,kind);
						break;
					}
					
					psArr.add(ps);
					
				} 
				catch (EOFException e) 
				{
					EOF = true;
				}
			}
			fis.close();
			dis.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("DataIOTest : " + e);
		} 
		catch (IOException e) 
		{
			System.out.println("DataIOTest : " + e);
		}
		
		psArr.stream().forEach(System.out::println);
	}

	public static void main(String[] args)
	{
		UnivManagementArray2 u = new UnivManagementArray2();
		u.Menu();
	}
}
