//thread
//메인프로그램 동작시 같이 덩달아 돌아가는것
package test1;

public class Test extends Thread
{	
	//common use
	// t1 <> t2 서로 다른 일
	public void run()
	{
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1+n2));
	}

	public static void main(String[] args) 
	{
		Test t1 = new Test();
		t1.start();
		Test t2 = new Test();
		t2.start();
		System.out.println("end " + Thread.currentThread().getName());
	}

}
