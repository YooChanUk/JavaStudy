//202003185 유찬욱 과제파일 입니다.
//과제를 하면서 느끼는거지만 뭔가 목표가 있다는게 오히려 공부가 더 잘되는것 같습니다.
//수업 들으러가서 실습을 하는것보다 오히려 이렇게 문제를 내주셔서 풀어주는게 더 좋습니다.
//덕분에 잘된것 같습니다. 감사합니다.
package gwajae;

import java.util.Scanner;
import java.util.Random;


class sachik extends Thread
{
	public void run()
	{
	int x = (int)(Math.random()*50+5);
	int y = (int)(Math.random()*50+5);
	
	if(x < y)
	{
		int pass;
		
		pass = x;
		x = y;
		y = pass;
	}
		
	System.out.println("x+y=" + (x + y));
	System.out.println("x-y=" + (x - y));
	System.out.println("x*y=" + (x * y));
	System.out.println("x/y=" + (x / y));
	}
}

class tennum extends Thread
{
	public void run()
	{
		int[] x = new int[10];
		int sum = 0;
		int min = 100;
		int max = 0;
		
		for(int i=0; i<10; i++)
		{
			x[i] = (int)(Math.random()*50+5);
			sum = sum + x[i];
		}
		for(int i=0; i<10; i++)
		{
			if(x[i] > max)
			{
				max = x[i];
			}
			else if(x[i] < min)
			{
				min = x[i];
			}
		}
		System.out.println("평균값 : " + (sum / 10));
		System.out.println("최소값 : " + (min));
		System.out.println("최대값 : " + (max));
		
	}
}

class disco
{
	Scanner s = new Scanner(System.in);
	String stat = null;
	String loc = "정지";
	
	public void exe()
	{
		left l = new left();
		right r = new right();
		shake sh = new shake();
		System.out.println("디스코 팡팡을 시작하시겠습니까? (시작/종료): ");
		stat = s.next();
		
		while(stat.equals("시작"))
		{
			if(loc.equals("정지"))
			{
			System.out.println("디스코 팡팡이 준비됐습니다");
			System.out.println("현재 상태 : " + loc);
			System.out.println("상태조정(왼쪽돌리기/오른쪽돌리기/좌우흔들기/종료) : ");
			loc = s.next();
			}
			else
			{
				System.out.println("상태조정(정지/왼쪽돌리기/오른쪽돌리기/좌우흔들기/종료) : ");
				loc = s.next();
				
			}
			
			if(loc.equals("왼쪽돌리기"))
			{
				l.leftswing();
			}
			else if(loc.equals("오른쪽돌리기"))
			{
				r.rightswing();
			}
			else if(loc.equals("좌우흔들기"))
			{
				sh.shake();
			}
			else if(loc.equals("종료"))
			{
				stat = "종료";
				System.out.println("디스코 팡팡이 종료되었습니다.");
			}
		}
		
	}
	
}

public class matter
{
	public static void main(String[] args) 
	{
		boolean jd = true;
		
		while(jd)
		{			
		System.out.println("------------");
		System.out.println("1. 사칙연산");
		System.out.println("2. 10개의 정수");
		System.out.println("3. 디스코팡팡");
		System.out.println("4. 종료");
		System.out.println("------------");
		System.out.println("선택 : ");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
			switch(select)
			{
			case 1 :
				sachik s = new sachik();
				s.start();
				break;
				
			case 2 :
				tennum t = new tennum();
				t.start();
				break;
			
			case 3 :
				disco d = new disco();
				d.exe();
				break;
				
			case 4 : jd = false;
			 	break;
			 	
			 default : continue;
				
				
			}
		}

	}

}
