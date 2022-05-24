package kunsan.psback0.lecture04;
import java.lang.*;

public class NestedLoop 
{
	public void run99() 
		{
		int i, j;
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		for (i = 1; i < 100; i++,System.out.println("")) 
		{
			for ( j = 1; j < 10; j++,System.out.print('\t')) 
			{
				System.out.print(i + "*" + j + "=" + i*j);
			}
		}
		System.out.println("\n\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	/*public static void main(String args[])
	{
		NestedLoop NL = new NestedLoop();
		NL.run99();
		
	}*/
}