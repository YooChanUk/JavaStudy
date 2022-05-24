package kunsan.psback0.lecture04;
import java.util.Scanner;

public class TitleSearch 
{
	public void searchTitle(Book[] books)
	{
		Scanner sc = new Scanner(System.in);
		String Title = null;
		
		System.out.println("찾으려는 책제목을 입력해주세요 : ");
		Title = sc.nextLine();
		
		
	      for(int j = 0; j< books.length; j++)
	      {
	    	  if(Title.equals(books[j].getTitle()))
	    	  {
			      /*System.out.println("책ID : " + books[j].getId() + "\n" + 
			    		  				"책저자 : " + books[j].getAuthor() + "\n" + 
			    		  				"책가격 : " + books[j].getPrice());*/
	    		  
	    		  books[j].allShow();
	    	  }
	      }
	}
	
}
