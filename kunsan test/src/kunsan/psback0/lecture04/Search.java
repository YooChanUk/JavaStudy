package kunsan.psback0.lecture04;
import java.util.Scanner;

public class Search 
{
	public void find(int[] result)
	{	
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 학생의 번호를 입력하세요 : ");
		num = sc.nextInt();
		
		System.out.println(num + " : " + result[num]);
		
	}
}
