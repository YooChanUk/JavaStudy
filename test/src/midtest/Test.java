package midtest;

import java.util.Scanner;

public class Test 
{
	int now_temperature;
	int aircon_menu;
	
	int speed;
	
	int[] answer;
	int[] stu_answer = new int[20];
	
	int[] score;
	
	int n = 0;
	
	String[] ox;

	int o;
	
	public Test()
	{
		now_temperature = 20;
		aircon_menu = 0;
		speed = 0;
		
		ox = new String[20];
		
		answer = new int[20];
	}
	
	public void aircon()
	{
		Scanner s = new Scanner(System.in);
	
		String on;
		
		if(aircon_menu < 1)
		{
			System.out.print("에어컨을 키시겠습니까?(on / off) : ");
			on = s.next();
			
			if(on.equals("on"))
			{
				aircon_menu++;
				System.out.println("에어컨을 on 합니다.");
				temperature();
			}
			
			else if(on.equals("off"))
				System.out.println("현재 에어컨은 off상태 입니다.");
			
		}
		
		else if(aircon_menu == 1)
			temperature();
	}
	
	public void temperature()
	{
		Scanner s = new Scanner(System.in);
		
		boolean aircon = true;
		
		String up = null;
			
		System.out.println("현재 온도 : " + now_temperature);
		System.out.print("온도를 설정해 주세요.(+ - 메뉴이동은 next 전원중지는 off) : ");
			
		up = s.next();
			
		if(up.equals("+"))
			now_temperature = now_temperature + 1;
			
		else if(up.equals("-"))
			now_temperature = now_temperature - 1;
			
		else if(up.equals("next"))
		{
			
		}
			
		else if(up.equals("off"))
			aircon_menu--;
	}
	
	public void answer()
	{
		for(int i = 0; i < 20; i++)
			answer[i] = (int)(Math.random()*4)+1;
	}
	
	public void stu_answer()
	{
		for(int t = 0; t < 20; t++)
			stu_answer[t] = (int)(Math.random()*4)+1;
	}
	
	public void score()
	{
		answer();
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("학생 수를 입력 하세요. : ");
		n = s.nextInt();
		
		score = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			stu_answer();
			
			o = 0;	
			
			for(int j = 0; j < 20; j++)
			{
				if(answer[j] == stu_answer[j])
				{	
					ox[j] = "O";
					o++;
				}
				
				else
					ox[j] = "X";
			}
			
			score[i] = o * 5;
		}
		
	}
	
	public void display()
	{
		score();
		
		for(int i = 0; i < n; i++)
		{
			System.out.println((i + 1) + "번째 학생");
			
			for(int j = 0; j < 20; j++)
				System.out.print(answer[j] + " ");
			
			System.out.println("");
			
			for(int j = 0; j < 20; j++)
				System.out.print(stu_answer[j] + " ");
			
			System.out.println("");
			
			for(int j = 0; j < 20; j++)
				System.out.print(ox[j] + " ");
			
			System.out.println("");
			System.out.println(score[i]);
		}
	}
	
	public void car()
	{
		Scanner s = new Scanner(System.in);
			
		System.out.print("속도를 올리시겠습니까? (yes / no / exit) : ");		
		String up = s.next();
		
		if(up.equals("yes"))
		{
			fw();
		}
		
		else if(up.equals("no"))
		{
			bw();
		}
		
		else if (up.equals("exit"))
		{
			
		}
	}
	
	public void fw()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("속도를 몇 올리시겠습니까? : ");
		int up = s.nextInt();
		
		up = up / 10;
		for(int i = 0; i < up+1; i++)
		{
			System.out.println("현재 속도 : " + speed);
			speed = speed + 10;
		}		
		car();
	}
	
	public void bw()
	{
		Scanner s = new Scanner(System.in);
		
		System.out.print("속도를 몇 낮추시겠습니까? : ");
		int up = s.nextInt();

		up = up / 10;
		
		if(up == 0)
		{
			speed = 0;
			System.out.println("급 브레이크!");
			System.out.println("현재 속도 : " + speed);
		}
		
		else if(up > 1)
		{
			for(int i = 0; i < up+1; i++)
			{
				speed = speed - 10;
				System.out.println("현재 속도 : " + speed);
			}
		}	
		car();
	}
	
	public static void main(String[] args) 
	{
		Test t = new Test();

		Scanner s = new Scanner(System.in);
		
		boolean run = true;
		
		while(run)
		{
			System.out.println("+----------------------------+");
			System.out.println(" 1. 에어컨 온도 제어");
			System.out.println(" 2. 학생 답안지 채점");
			System.out.println(" 3. 자동차 속도 제어");
			System.out.println(" 4. 종료");
			System.out.println("+----------------------------+");
			
			System.out.print("메뉴를 선택하세요. : ");
			int menu = s.nextInt();
			
			switch(menu)
			{
				case 1 : t.aircon();
						 break;
					
				case 2 : t.display();
						 break;
					
				case 3 : t.car();
						 break;
					
				case 4 : run = false;
						 break;
					
				default : System.out.println("잘못된 입력입니다.");
						  continue;
			}
		}
	}
}