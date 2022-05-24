package kunsan.psback0.lecture04;
import java.util.Arrays;

public class AvgMid 
{
	public void Cal(int[] result)
	{
		int[] rc = (int[])result.clone();
		
		int avg = 0;
		int sum = 0;
		int mid = 0;
		int midsum = 0;

		
		for(int i = 1; i < result.length; i++)
		{
			sum += result[i];
		}
		
		Arrays.sort(rc);
		
		for(int i = 1; i < rc.length; i++)
		{
			midsum += i; 
		}

		mid = midsum/(rc.length-1);
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 점수 : " + sum/(result.length-1));
		if((rc.length-1) % 2 == 0)
		{
			System.out.println("요기" + (rc.length-1));
			int twomid = (rc[mid] + rc[mid+1]) / 2;
			System.out.println("중위값 : " + twomid);
		}
		else
		{
			System.out.println("중위값 : " + rc[mid]);
		}
		
	}
	
	
	
	public void BookCal(Book[] books)
	{
		
		int avg = 0;
		int sum = 0;
		int mid = 0;
		int[] bc = new int[books.length];
		//int[] bc = null;
		
		for(int i = 0; i < books.length; i++)
		{
			sum += books[i].getPrice();
		}
		
		for(int j = 0; j < books.length; j++)//가격을 밀어넣기
		{
			bc[j] = books[j].getPrice();
		}
		
		Arrays.sort(bc);//bc의 가격들을 정렬
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 가격 : " + sum/books.length);
		
		
		if((bc.length) % 2 == 0)
		{
			int twomid = ((bc[(bc.length/2)] + bc[(bc.length/2) - 1] )/ 2);
			System.out.println("중위값 : " + twomid);
		}
		else
		{
			System.out.println("중위값 : " + bc[(bc.length/2)]);
		}
		
		
		
	}
	
}
