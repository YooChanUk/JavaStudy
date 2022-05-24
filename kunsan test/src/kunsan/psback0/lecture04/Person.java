package kunsan.psback0.lecture04;

import java.util.Comparator;

public class Person implements Comparable<Person>
{

	public String citizenNumber = null ,name = null;
	public int birthYear = 0;
	//String studentNumber = null, dept = null;
	
	public Person(String citizenNumber, String name, int birthYear)
	{
		this.citizenNumber = citizenNumber;
		this.name = name;
		this.birthYear = birthYear;
	}

	@Override
	public String toString()
	{
		return "Person : [citizenNumber=" + citizenNumber + ", name=" + name + ", birthYear=" + birthYear + "]";
	}

	@Override
	public int compareTo(Person p) {
		return this.getCitizenNumber().compareTo(p.getCitizenNumber());
		
	}
	
	public String getCitizenNumber() {
		return citizenNumber;
	}

	public void setCitizenNumber(String citizenNumber) {
		this.citizenNumber = citizenNumber;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getBirthYear() 
	{
		return birthYear;
	}

	public void setBirthYear(int birthYear) 
	{
		this.birthYear = birthYear;
	}

}

class Student extends Person
{
	String studentNumber = null, dept = null;
	
	public Student(String citizenNumber, String name, int birthYear, String studentNumber, String dept) 
	{
		super(citizenNumber, name, birthYear);
		// TODO Auto-generated constructor stub
		
		this.studentNumber = studentNumber;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return "Student : [citizenNumber=" + citizenNumber + ", name=" + name + ", birthYear=" + birthYear
				+ ", studentNumber=" + studentNumber + ", dept=" + dept + "]";
	}

	public String getStudentNumber() 
	{
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) 
	{
		this.studentNumber = studentNumber;
	}

	public String getDept() 
	{
		return dept;
	}

	public void setDept(String dept) 
	{
		this.dept = dept;
	}
	
}

class Researcher extends Person
{
	public String employeeNumber = null, dept = null;
	
	public Researcher(String citizenNumber, String name, int birthYear,
					String employeeNumber, String dept) {
		super(citizenNumber, name, birthYear);
		// TODO Auto-generated constructor stub
		
		this.employeeNumber = employeeNumber;
		this.dept = dept;
	}

	

	public String getEmployeeNumber() 
	{
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) 
	{
		this.employeeNumber = employeeNumber;
	}

	public String getDept() 
	{
		return dept;
	}

	public void setDept(String dept) 
	{
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Researcher : [citizenNumber=" + citizenNumber + ", name=" + name + ", birthYear=" + birthYear
				+ ", employeeNumber=" + employeeNumber + ", dept=" + dept + "]";
	}

}

class Professor extends Researcher
{
	String position = null;
	
	public Professor(String citizenNumber, String name, int birthYear, String employeeNumber, String dept,String position) 
	{
		super(citizenNumber, name, birthYear, employeeNumber, dept);
		// TODO Auto-generated constructor stub
		
		this.position = position;
	}

	public String getPosition() 
	{
		return position;
	}

	public void setPosition(String position) 
	{
		this.position = position;
	}

	@Override
	public String toString() {
		return "Professor : [citizenNumber=" + citizenNumber + ", name=" + name + ", birthYear=" + birthYear
				+ ", employeeNumber=" + employeeNumber + ", dept=" + dept + ", position=" + position + "]";
	}

}

