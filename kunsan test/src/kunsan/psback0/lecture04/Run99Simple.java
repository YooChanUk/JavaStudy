package kunsan.psback0.lecture04;
import java.lang.*;
import java.util.Scanner;

public class Run99Simple 
{
	public void run99 (int start1, int end1, int start2, int end2) 
	{
		int i, j;
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		for (i = start1 ; i <= end1; i++,System.out.println("")) 
		{
			for (j = start2; j <= end2; j++,System.out.print('\t')) 
			{
				System.out.print(i + "*" + j + "=" + i*j);
			}
		}
		System.out.println("\n\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
	}
	
	public void doDialog ()
	{
		int start1=0, end1=0, start2 = 0, end2 = 0;
		Scanner rd = new Scanner(System.in);
		
		System.out.print("몇 단부 터 몇 단까지 구구단을 출력할까요?(int, int) :");
		
		start1 = rd.nextInt();
		end1 = rd.nextInt();
		
		while(start1 > end1)
		{
			System.out.print("둘째단이 첫단보다 숫자가 높습니다 다시 입력하십시오 : ");
			start1 = rd.nextInt();
			end1 = rd.nextInt();
		}
		
		System.out.print("어느 수 부 터 어느 수 까지 곱할까요?(int, int) :");
		
		start2 = rd.nextInt();
		end2 = rd.nextInt();
		
		while(start2 > end2)
		{
			System.out.print("둘째 수가 첫 수보다 숫자가 높습니다 다시 입력하십시오 : ");
			start2 = rd.nextInt();
			end2 = rd.nextInt();
		}
		
		run99(start1, end1, start2, end2);
	}
	
	/*public static void main(String args[])
	{
		Run99Simple rs = new Run99Simple();
		rs.doDialog();
	}*/
}