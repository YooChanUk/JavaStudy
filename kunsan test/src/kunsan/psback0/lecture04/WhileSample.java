package kunsan.psback0.lecture04;
import java.util.Scanner;
import java.lang.*;

public class WhileSample 
{
	public void getAverage( ) 
	{
		Scanner rd = new Scanner(System.in);
		
		int n = 0;
		double sum = 0;
		int i=0;
		
		System.out.print("다음 수를 입력해 주십시오(종료는 -1) : ");
		while ((i = rd.nextInt()) != -1 )
		{
			System.out.print("다음 수를 입력해 주십시오(종료는 -1) : ");
			sum += i;
			n++;
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		System.out.println("입력된 수의 개수는 " + n + "개이며 평균은 " + sum / n + "입니다.\n");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	/*public static void main(String args[])
	{
		WhileSample ws = new WhileSample();
		ws.getAverage();
	}*/
}