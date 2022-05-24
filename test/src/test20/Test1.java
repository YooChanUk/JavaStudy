//thread
//메인프로그램 동작시 같이 덩달아 돌아가는것
package test20;

public class Test1
{	
	//common use
	// t1 <> t2 서로 다른 일

	public static void main(String[] args) 
	{
		Runnable Task = () -> {
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1+n2));
		};
		
		Runnable Task2 = () -> {
			int n1 = 20;
			int n2 = 30;
			String name = Thread.currentThread().getName();
			System.out.println(name + " : " + (n1+n2));
		};
		
		Thread t1 = new Thread(Task);
		t1.start();
		Thread t2 = new Thread(Task2);
		t2.start();
		System.out.println("end " + Thread.currentThread().getName());
	}

}
