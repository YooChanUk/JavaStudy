package kunsan.psback0.lecture04;
import java.lang.*;
import java.util.Scanner;

public class ForSum 
{
	public  void  printSum() 
	{
		Scanner sc = new Scanner(System.in);
		int sum=0;
		//int x = 0;
		//int y = 0;
		
		System.out.print("x값을 입력해주세요 : ");
		int x = sc.nextInt();
		
		System.out.print("y값을 입력해주세요 : ");
		int y = sc.nextInt();
		
		
		while(x >= y)
		{
			System.out.println("x보다 y값이 더 크거나 같아서 실행 할 수 없습니다. 다시 입력해주세요");
			System.out.print("x값을 입력해주세요 : ");
			x = sc.nextInt();
			System.out.print("y값을 입력해주세요 : ");
			y = sc.nextInt();
			
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		for(int i=x; i<=y; i++) 
		{ // x~y까지 반복
			sum += i;
			System.out.print(i); // 더하는 수 출력
			
			if(i<y) 
			{// x~y까지는 '+' 출력
			System.out.print("+");
			}
			else 
			{ // i가 y인 경우
				System.out.print("="); // '=' 출력하고
				System.out.print(sum); // 덧셈 결과 출력
			}
		}
		System.out.println("\n\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	/*public static void main(String args[])
	{
		ForSum fs = new ForSum();
		fs.printSum();
		
	}*/
}