//thread
//�������α׷� ���۽� ���� ���޾� ���ư��°�
package test0;

public class Test extends Thread
{	
	public void run()
	{
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1+n2));
	}

	public static void main(String[] args) 
	{
		Test t = new Test();
		t.start();
		System.out.println("end " + Thread.currentThread().getName());
	}

}
