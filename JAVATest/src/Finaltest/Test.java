package Finaltest;

import java.util.Scanner;

class twoint extends Thread
{
	public void run()
	{
	int x = (int)(Math.random()*50+5);
	int y = (int)(Math.random()*50+5);
	int hhap = 0;
	int zhap = 0;
	System.out.println("x는" + x + " y는" + y);
	
	if(x<y)
	{
		System.out.println("x<y");
	}
	else if(x>y)
	{
		System.out.println("x>y");
	}
	
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
	
		while(y<x)
		{
			y++;
			if(y%2==0)
			{
					hhap = hhap + y;
			}
			if(y%2==1)
			{
					zhap = zhap + y;
			}
		}
		System.out.println("y부터 x까지 홀수의합=" + hhap);
		System.out.println("y부터 x까지 짝수의합=" + zhap);
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
		sum = sum - max - min;
		for(int i=0; i<10; i++)
		{
		System.out.print(x[i] + "/");
		}
		System.out.println("\n평균값 : " + (sum / 8));
		System.out.println("최소값 : " + (min));
		System.out.println("최대값 : " + (max));
		
	}
}

class gimbab extends Thread
{
	public void run()
	{
		Scanner s = new Scanner(System.in);
		String shop = "open";
		int gimb = 2000;
		int money = 0;
		int gimbstash = 0;
		System.out.println("죄송합니다 조인구문 공부를 못해서, 판매하는쪽 만들지를 못하겠습니다 ㅠㅠ");
		
		while(shop.equals("open"))
		{
			try 
			{
				Thread.sleep(1000);
				gimbstash++;
				System.out.println("김밥 하나 완성!");
				System.out.println("남은수량 : " + gimbstash);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}

public class Test {

	public static void main(String[] args) 
	{
		boolean jd = true;
		
		while(jd)
		{			
		System.out.println("------------");
		System.out.println("1. 2개의 정수");
		System.out.println("2. n개의 정수");
		System.out.println("3. 복수김밥");
		System.out.println("4. 종료");
		System.out.println("------------");
		System.out.println("선택 : ");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
			switch(select)
			{
			case 1 :
				twoint t = new twoint();
				t.start();
				break;
				
			case 2 :
				tennum n = new tennum();
				n.start();
				break;
			
			case 3 :
				gimbab g = new gimbab();
				g.start();
				break;
				
			case 4 : jd = false;
			 	break;
			 	
			 default : continue;

			}
		}
	}
}
