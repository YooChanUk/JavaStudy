//count 동시에 접근
//critical section : 임계구역
//mutual exclusion 상호배제
package test41;


class Counter
{
	int count = 0;
	
	public  void plus()
	{	
		synchronized(this)
		{
			count++;
		}
	}
	public void minus()
	{	
		synchronized(this)
		{
		count--;
		}
	}
	public int get_Count()
	{	
		return count;
		
	}
}
public class Test
{
	static Counter cnt = new Counter();
		
	public static void main(String[] args)
	{
		Runnable Task1 = () ->
		{
			for(int i = 0; i<1000; i++)
			{
					cnt.plus();
					
			}
		};
		Runnable Task2 = () ->
		{
			for(int i = 0; i<1000; i++)
			{
				cnt.minus();
					
			}
		};
			
		Thread t1 = new Thread(Task1);
		t1.start();
		Thread t2 = new Thread(Task2);
		t2.start();
			
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("count = " + cnt.get_Count());
		
		}

}
