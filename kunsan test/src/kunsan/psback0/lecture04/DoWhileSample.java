package kunsan.psback0.lecture04;
import java.lang.*;

public class DoWhileSample 
{
	public void printAtoZ()
	{
		char a = 'A';
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		do 
		{
		System.out.print(a + " ");
		a = (char) (a + 1);
		} while (a <= 'Z');
		System.out.println("\n");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	/*public static void main(String args[])
	{
		DoWhileSample ds = new DoWhileSample();
		ds.printAtoZ();
	}*/
}