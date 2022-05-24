package test33;

public class Test 
{
	public static void main(String[] args)
	{
		int a = 20;
		int b = 10;
		
		Runnable proc_add = () ->
		{
		
			System.out.println(a+"+"+b+"="+(a+b));
			System.out.println(a+"-"+b+"="+(a-b));
		};
		
		Runnable proc_subt = () ->
		{
			System.out.println(a+"*"+b+"="+(a*b));
			System.out.println(a+"/"+b+"="+(a/b));
		};
		
		Thread t1 = new Thread(proc_add);
		t1.start();
		Thread t2 = new Thread(proc_subt);
		t2.start();
	}
	
}
