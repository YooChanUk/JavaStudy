package kunsan.psback0.lecture04;

public class StudentList 
{
	public void list(int result[])
	{
		System.out.println("학생 성적을 출력합니다.");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for(int i = 1; i < result.length; i++)
		{
			System.out.println(i + " : " + result[i]);
		}
	}
}
