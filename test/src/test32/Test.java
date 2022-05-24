package test32;

class proc_adsu extends Thread
{
	int a,b;
	public void get(int x, int y)
	{
		a = x;
		b = y;
	}
	public void run()
	{
	System.out.println(a+"+"+b+"="+(a+b));
	System.out.println(a+"-"+b+"="+(a-b));
	}
}

class proc_xy extends Thread
{	int a,b;
	public void get(int x, int y)
	{
		a = x;
		b = y;
	}
	public void run()
	{
	System.out.println(a+"*"+b+"="+(a*b));
	System.out.println(a+"/"+b+"="+(a/b));
	}
}

public class Test
{
	static int a,b;
	public Test()
	{
		int a = 20;
		int b = 10;
	}
	
	public static void main(String[] args) 
	{
		new Test();
		proc_adsu t1 = new proc_adsu();
		t1.get(a,b);
		t1.start();
		proc_xy t2 = new proc_xy();
		t2.get(a,b);
		t2.start();

	}
	
}
