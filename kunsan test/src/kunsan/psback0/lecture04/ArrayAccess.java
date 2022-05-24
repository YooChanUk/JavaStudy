package kunsan.psback0.lecture04;
import java.util.Scanner;

public class ArrayAccess 
{
	public int maxArray( int num ) 
	{
		Scanner in = new Scanner(System.in);
		
		int intArray[] = new int[ num ];
		int max = 0;
		
		for (int i = 0; i < intArray.length; i++) 
		{
			intArray[i] = in.nextInt();
			if (intArray[i] > max)
			max = intArray[i];
		}
		
		System.out.print("입력된 수에서 가장 큰 수는 " + max + "입니다.");
		
		return max;
	}
	
	public static void main(String args[])
	{
		ArrayAccess AA = new ArrayAccess();
		int max = AA.maxArray(5);
		System.out.print("입력된 수에서 가장 큰 수는 " + max + "입니다.");
		
	}
}
