package test30;

public class Test
{
	int a;
	int b;
	
	public Test()
	{
		a = 20;
		b = 10;
	}
	
	public void result()
	{
	System.out.println(a+"+"+b+"="+(a+b));
	System.out.println(a+"-"+b+"="+(a-b));
	System.out.println(a+"*"+b+"="+(a*b));
	System.out.println(a+"/"+b+"="+(a/b));
	}
	
	public static void main(String[] args)
	{
		Test t = new Test();
		t.result();
		
	}
	
	
}
