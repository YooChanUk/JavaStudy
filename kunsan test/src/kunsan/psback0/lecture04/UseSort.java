package kunsan.psback0.lecture04;

import java.util.Arrays;

public class UseSort 
{
	public void sort(int[] result)
	{
		//int i = 1;
		Arrays.sort(result);
		
		for(int i=1; i < result.length; i++)
		{
			System.out.println(i + " : " + result[i]);
		}
	}
	
	public void Booksort(Book[] books)
	{
		int i = 0;
		
		
        for(i = 0; i < books.length; i++)
        {
        	String tmp1 = books[i].getTitle();
        	
        	for(int j = 0; j < books.length; j++)
        	{
        		String tmp2 = books[j].getTitle();
        		
        		String tmp = null;
        		int imp = 0;
        		
        		if(tmp1.compareTo(tmp2) < 0) // tmp1이 tmp2보다 큰경우(문자가 더 크기에 뒤로 옮겨야함)
        		{
        			//ID 바꾸기
        			tmp = books[i].getId();
        			books[i].setId(books[j].getId());
        			books[j].setId(tmp);
        			
        			//Title 바꾸기
        			tmp = books[i].getTitle();
        			books[i].setTitle(books[j].getTitle());
        			books[j].setTitle(tmp);
        			
        			//author 바꾸기
        			tmp = books[i].getAuthor();
        			books[i].setAuthor(books[j].getAuthor());
        			books[j].setAuthor(tmp);
        			
        			//price 바꾸기
        			imp = books[i].getPrice();
        			books[i].setPrice(books[j].getPrice());
        			books[j].setPrice(imp);
        		}
        		
        	}
        }
		
		for(i = 0; i < books.length; i++)
		{
			books[i].allShow();
		}
		
	}
}
