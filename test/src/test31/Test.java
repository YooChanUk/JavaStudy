package test31;

public class Test extends Thread
{	
	int a;
	int b;
	
	public Test()
	{
		a = 20;
		b = 10;
	}
	
	public void run()
	{
	System.out.println(a+"+"+b+"="+(a+b));
	System.out.println(a+"-"+b+"="+(a-b));
	System.out.println(a+"*"+b+"="+(a*b));
	System.out.println(a+"/"+b+"="+(a/b));
	}
	
	public static void main(String[] args) 
	{
		Test t = new Test();
		t.start();

	}

}
