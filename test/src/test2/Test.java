//thread
//메인프로그램 동작시 같이 덩달아 돌아가는것
package test2;

class Task1 extends Thread
{
	public void run()
	{
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1+n2));
	}
}

class Task2 extends Thread
{
	public void run()
	{
		int n1 = 20;
		int n2 = 30;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1+n2));
	}
}

public class Test
{	
	//common use
	// t1 <> t2 서로 다른 일

	public static void main(String[] args) 
	{
		Task1 t1 = new Task1();
		t1.start();
		Task2 t2 = new Task2();
		t2.start();
		System.out.println("end " + Thread.currentThread().getName());
	}

}
