package kunsan.psback0.lecture04;
import java.math.*;
import java.util.Scanner;

public class StundentNum 
{
	public int[] input()
	{
 		Scanner sc = new Scanner(System.in);
		int number = 0;
		int ran = 0;
		int[] result = null;
		
		System.out.print("몇명의 학생이 있습니까?(점수 랜덤생성) : ");
		number = sc.nextInt();
		
		result = new int[number+1];
		
		for(int i=1; i < number+1; i++)
		{
			ran = (int)(Math.random()*101);
			result[i] = ran;
		}
		
		return result;
	}
}
