//202003185 ������ �������� �Դϴ�.
//������ �ϸ鼭 �����°����� ���� ��ǥ�� �ִٴ°� ������ ���ΰ� �� �ߵǴ°� �����ϴ�.
//���� ���������� �ǽ��� �ϴ°ͺ��� ������ �̷��� ������ ���ּż� Ǯ���ִ°� �� �����ϴ�.
//���п� �ߵȰ� �����ϴ�. �����մϴ�.
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
		System.out.println("��հ� : " + (sum / 10));
		System.out.println("�ּҰ� : " + (min));
		System.out.println("�ִ밪 : " + (max));
		
	}
}

class disco
{
	Scanner s = new Scanner(System.in);
	String stat = null;
	String loc = "����";
	
	public void exe()
	{
		left l = new left();
		right r = new right();
		shake sh = new shake();
		System.out.println("���� ������ �����Ͻðڽ��ϱ�? (����/����): ");
		stat = s.next();
		
		while(stat.equals("����"))
		{
			if(loc.equals("����"))
			{
			System.out.println("���� ������ �غ�ƽ��ϴ�");
			System.out.println("���� ���� : " + loc);
			System.out.println("��������(���ʵ�����/�����ʵ�����/�¿�����/����) : ");
			loc = s.next();
			}
			else
			{
				System.out.println("��������(����/���ʵ�����/�����ʵ�����/�¿�����/����) : ");
				loc = s.next();
				
			}
			
			if(loc.equals("���ʵ�����"))
			{
				l.leftswing();
			}
			else if(loc.equals("�����ʵ�����"))
			{
				r.rightswing();
			}
			else if(loc.equals("�¿�����"))
			{
				sh.shake();
			}
			else if(loc.equals("����"))
			{
				stat = "����";
				System.out.println("���� ������ ����Ǿ����ϴ�.");
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
		System.out.println("1. ��Ģ����");
		System.out.println("2. 10���� ����");
		System.out.println("3. ��������");
		System.out.println("4. ����");
		System.out.println("------------");
		System.out.println("���� : ");
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
