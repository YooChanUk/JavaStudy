//thread
//�������α׷� ���۽� ���� ���޾� ���ư��°�
package test00;

public class Test
{	
	public static void main(String[] args) 
	{
		Runnable Task = () -> {
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + " : " + (n1+n2));
		};
		
		Thread t = new Thread(Task);
		t.start();
		System.out.println("end " + Thread.currentThread().getName());
	}

}
