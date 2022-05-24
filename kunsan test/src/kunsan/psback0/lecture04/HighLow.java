package kunsan.psback0.lecture04;

public class HighLow 
{
	public void check(int[] result)
	{
		
		int max=0,min=100;
		
		for(int i=1; i<result.length; i++)
		{
			if(result[i] > max)
			{
				max = result[i];
			}
			
			if(min > result[i])
			{
				min = result[i];
			}
		}
		
		System.out.println("최고점수 : " + max);
		System.out.println("최하점수 : " + min);
	}
	
	public void BookCheck(Book[] books)
	{
		
		int max=0, min=999999;
		int maxi = 0, mini = 0;
		
		for(int i=0; i< books.length; i++)
		{
			if(books[i].getPrice() > max)
			{
				max = books[i].getPrice();
				maxi = i;
			}
			
			if(min > books[i].getPrice())
			{
				min = books[i].getPrice();
				mini = i;
			}
		}
		
		System.out.print("최고가격 : ");
		books[maxi].allShow();
		System.out.print("최하가격 : ");
		books[mini].allShow();
	}
}
