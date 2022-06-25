package kunsan.psback0.lecture04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UnivTempTest 
{
	Scanner sc = new Scanner(System.in);
	ArrayList<Person> psArr = new ArrayList<Person>();
	String filepath = "UTT.dat";
	
	public void inputUniv()
	{
		String citizenNumber = null ,name = null;
		int birthYear = 0;
		String studentNumber = null, dept = null, employeeNumber = null;
		String position = null;
		int kind = -1;
		Person ps = null;
		
		System.out.print("어떤 사람입니까 : "); // 1.사람 2.학생 3.연구원 4.교수
		kind = sc.nextInt();
		sc.nextLine();
		System.out.print("주민등록번호 입력 : ");
		citizenNumber = sc.next();
		sc.nextLine();
		System.out.print("이름 입력 : ");
		name = sc.next();
		sc.nextLine();
		System.out.print("생년월일 입력 : ");
		birthYear = sc.nextInt();
		sc.nextLine();
		
		switch(kind)
		{
		case 1: ps = new Person(citizenNumber,name,birthYear,kind);
			break;
		case 2:
			System.out.print("학번 입력 : ");
			studentNumber = sc.next();
			sc.nextLine();
			System.out.print("학과 입력 : ");
			dept = sc.next();
			sc.nextLine();
			ps = new Student(citizenNumber,name,birthYear,studentNumber,dept,kind);
			break;
		case 3:
			System.out.print("연구원 번호 입력 : ");
			employeeNumber = sc.next();
			sc.nextLine();
			System.out.print("학과 입력 : ");
			dept = sc.next();
			sc.nextLine();
			ps = new Researcher(citizenNumber,name,birthYear,employeeNumber,dept,kind);
			break;
		case 4:
			System.out.print("연구원 번호 입력 : ");
			employeeNumber = sc.next();
			sc.nextLine();
			System.out.print("학과 입력 : ");
			dept = sc.next();
			sc.nextLine();
			System.out.print("직급 입력 : ");
			position = sc.next();
			sc.nextLine();
			ps = new Professor(citizenNumber,name,birthYear,employeeNumber,dept,position,kind);
			break;
		}
		
		psArr.add(ps);
		
		writeData(ps,true);
	}
	
	public void outputUniv()
	{
		System.out.println("어떤식의 출력을 하시겠습니까?");
		System.out.print("1.전체보기 2.birthyear순 보기 3.이름순 보기 4.이름 역순으로 보기 :");
		
		
		switch(sc.nextInt())
		{
		case 1: psArr.forEach(System.out::println);
			break;
		case 2: psArr.stream().sorted((p1,p2) -> p1.getBirthYear() - p2.getBirthYear()).
		forEach(System.out::println);
			break;
		case 3: psArr.stream().sorted((p1,p2) -> p1.getName().compareTo(p2.getName())).
		forEach(System.out::println);
			break;
		case 4: psArr.stream().sorted((p1,p2) -> p2.getName().compareTo(p1.getName())).
		forEach(System.out::println);
			break;
		}
	}
	
	public void conditionSearch()
	{
		System.out.println("어떤식의 출력을 하시겠습니까?");
		System.out.print("1. 이름으로 검색  2. 생년월일로 검색  3.birthYear 범위로 검색");
		
		switch(sc.nextInt())
		{
		case 1: nameSearch();
			break;
		case 2: ageSearch();
			break;
		case 3: birthYearSearch();
			break;
		}
	}
	
	public void nameSearch()
	{
		System.out.print("검색할 사람의 이름은? :");
		String name = sc.next();
		sc.nextLine();
		
		psArr.stream().filter(p -> p.getName().equals(name)).
		forEach(System.out::println);
		
	}
	
	public void ageSearch()
	{
		System.out.print("검색할 사람의 생년월일은? :");
		int birthYear = sc.nextInt();
		sc.nextLine();
		
		psArr.stream().filter(p -> p.getBirthYear() == birthYear).
		forEach(System.out::println);
	}
	
	public void birthYearSearch()
	{
		System.out.print("최소생년월일은? :");
		int minbirthYear = sc.nextInt();
		sc.nextLine();
		System.out.print("최대생년월일은? :");
		int maxbirthYear = sc.nextInt();
		sc.nextLine();
		
		psArr.stream().filter(p -> p.getBirthYear() >= minbirthYear && p.getBirthYear() <= maxbirthYear).
		forEach(System.out::println);
	}
	
	public void updateUniv()
	{
		String citizenNumber = null ,name = null;
		int birthYear = 0;
		String studentNumber = null, dept = null, employeeNumber = null;
		String position = null;
		int kind = -1;
		
		System.out.print("바꿀 사람의 이름을 입력헤주세요 :");
		
		name = sc.next();
		sc.nextLine();
		int upidx = -1;
		
		for(int i = 0; i <psArr.size(); i++)
		{
			if(psArr.get(i).getName().equals(name))
			{
				upidx = i;
				kind = psArr.get(i).getKind();
				System.out.println("바꿀 사람의 정보는 ");
				System.out.println(psArr.get(i).toString());
			}
		}
		
		System.out.print("주민등록번호 입력 : ");
		citizenNumber = sc.next();
		sc.nextLine();
		System.out.print("이름 입력 : ");
		name = sc.next();
		sc.nextLine();
		System.out.print("생년월일 입력 : ");
		birthYear = sc.nextInt();
		sc.nextLine();
		
		psArr.get(upidx).setCitizenNumber(citizenNumber);
		psArr.get(upidx).setName(name);
		psArr.get(upidx).setBirthYear(birthYear);
		
		
		if(psArr.get(upidx) instanceof Professor)
		{
			System.out.print("연구원 번호 입력 : ");
			employeeNumber = sc.next();
			sc.nextLine();
			System.out.print("학과 입력 : ");
			dept = sc.next();
			sc.nextLine();
			System.out.print("직급 입력 : ");
			position = sc.next();
			sc.nextLine();
			
			((Professor)psArr.get(upidx)).setEmployeeNumber(employeeNumber);
			((Professor)psArr.get(upidx)).setDept(dept);
			((Professor)psArr.get(upidx)).setPosition(position);
		}
		else if(psArr.get(upidx) instanceof Researcher)
		{
			System.out.print("연구원 번호 입력 : ");
			employeeNumber = sc.next();
			sc.nextLine();
			System.out.print("학과 입력 : ");
			dept = sc.next();
			sc.nextLine();
			
			((Researcher)psArr.get(upidx)).setEmployeeNumber(employeeNumber);
			((Researcher)psArr.get(upidx)).setDept(dept);
		}
		else if(psArr.get(upidx) instanceof Student)
		{
			System.out.print("학번 입력 : ");
			studentNumber = sc.next();
			sc.nextLine();
			System.out.print("학과 입력 : ");
			dept = sc.next();
			sc.nextLine();
			
			((Student)psArr.get(upidx)).setStudentNumber(studentNumber);
			((Student)psArr.get(upidx)).setDept(dept);
		}
		
		writeData(null,false);
	}
	
	public void deleteUniv()
	{
		System.out.print("삭제할 사람의 이름을 입력헤주세요 :");
		String name = sc.next();
		sc.nextLine();
		
		for(int i = 0; i < psArr.size(); i++)
		{
			if(psArr.get(i).getName().equals(name))
			{
				System.out.println("삭제하는 사람의 정보는 :");
				System.out.println(psArr.get(i).toString());
				psArr.remove(i);
			}
		}
		
		writeData(null,false);
	}
	
	public void writeData(Object n,boolean isAppend) // 적기
	{
		try 
		{
			FileOutputStream fop = new FileOutputStream(filepath,isAppend);
			DataOutputStream dos = new DataOutputStream(fop);
			
			if(isAppend == true)
			{
				dos.writeInt(((Person)n).getKind());
				dos.writeUTF(((Person)n).getCitizenNumber());
				dos.writeUTF(((Person)n).getName());
				dos.writeInt(((Person)n).getBirthYear());
				
				switch(((Person)n).getKind())
				{
				case 1:
					dos.writeUTF("\n");
					dos.close();
					break;
				case 2:
					dos.writeUTF(((Student)n).getStudentNumber());
					dos.writeUTF(((Student)n).getDept());
					dos.writeUTF("\n");	
					dos.close();
					break;
				case 3:
					dos.writeUTF(((Researcher)n).getEmployeeNumber());
					dos.writeUTF(((Researcher)n).getDept());
					dos.writeUTF("\n");	
					dos.close();
					break;
				case 4:
					dos.writeUTF(((Professor)n).getEmployeeNumber());
					dos.writeUTF(((Professor)n).getDept());
					dos.writeUTF(((Professor)n).getPosition());
					dos.writeUTF("\n");	
					dos.close();
					break;
				}
			}
			else if(isAppend == false)
			{
				for(Person p : psArr)
				{
					dos.writeInt(p.getKind());
					dos.writeUTF(p.getCitizenNumber());
					dos.writeUTF(p.getName());
					dos.writeInt(p.getBirthYear());
					
					switch(p.getKind())
					{
					case 1:
						dos.writeUTF("\n");				
						break;
					case 2:
						dos.writeUTF(((Student)p).getStudentNumber());
						dos.writeUTF(((Student)p).getDept());
						dos.writeUTF("\n");	
						break;
					case 3:
						dos.writeUTF(((Researcher)p).getEmployeeNumber());
						dos.writeUTF(((Researcher)p).getDept());
						dos.writeUTF("\n");	
						break;
					case 4:
						dos.writeUTF(((Professor)p).getEmployeeNumber());
						dos.writeUTF(((Professor)p).getDept());
						dos.writeUTF(((Professor)p).getPosition());
						dos.writeUTF("\n");	
						break;
					}
				}
			}	
			
			fop.close();
			dos.close();
		} 
		catch 
		(FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	public void readData() // 읽기
	{
		String citizenNumber = null ,name = null;
		int birthYear = 0;
		String studentNumber = null, dept = null, employeeNumber = null;
		String position = null;
		int kind = -1;
		boolean EOF = false;
		
		Person ps = null;

		File f = new File(filepath);
		
		if(!f.exists()) // 파일이 없다면 아웃풋으로 생성 하고 바로 다시 닫기
		{
			try 
			{
				FileOutputStream fop = new FileOutputStream(filepath);
				fop.close();
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		try 
		{		
			FileInputStream fip = new FileInputStream(filepath);
			DataInputStream dis = new DataInputStream(fip);
			
			while(!EOF)
			{	
				kind = dis.readInt();
				
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
				case 3 :
					employeeNumber = dis.readUTF();
					dept = dis.readUTF();
					dis.readUTF();
					ps = new Researcher(citizenNumber,name,birthYear,employeeNumber,dept,kind);
					break;
				case 4 :
					employeeNumber = dis.readUTF();
					dept = dis.readUTF();
					position = dis.readUTF();
					dis.readUTF();
					ps = new Professor(citizenNumber,name,birthYear,employeeNumber,dept,position,kind);
					break;
				}
				
				psArr.add(ps);
			}
			
			fip.close();
			dis.close();
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			EOF = true;
			//e.printStackTrace();
		}
		
		psArr.stream().forEach(System.out::println);
		
	}
	
	public void menu()
	{
		readData();
		int select = -1;
		
		while(true)
		{		
			System.out.println("1) 대학 구성원 데이터 입력");
			System.out.println("2) 대학 구성원 데이터 전체 출력");
			System.out.println("3) 대학 구성원 데이터 조건 검색");
			System.out.println("4) 대학 구성원 데이터 변경");
			System.out.println("5) 대학 구성원 데이터 삭제");
			System.out.println("0) 대학 관리 프로그램 종료");
			System.out.print("선택 : ");
			select = sc.nextInt();
			
			switch(select)
			{
			case 1: inputUniv();
				break;
			case 2: outputUniv();
				break;
			case 3: conditionSearch();
				break;
			case 4: updateUniv();
				break;
			case 5: deleteUniv();
				break;
			case 0:
				System.out.println("시스템을 종료합니다.");
				return;
			default :
				System.out.println("없는 번호 입니다. 다시 입력해 주세요.");
				break;
			}
		}

	}

	public static void main(String[] args) 
	{
		UnivTempTest utt = new UnivTempTest();
		utt.menu();
	}

}
