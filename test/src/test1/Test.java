//thread
//�������α׷� ���۽� ���� ���޾� ���ư��°�
package test1;

public class Test extends Thread
{	
	//common use
	// t1 <> t2 ���� �ٸ� ��
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
