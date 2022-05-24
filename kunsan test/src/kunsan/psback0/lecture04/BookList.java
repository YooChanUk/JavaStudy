package kunsan.psback0.lecture04;

import java.util.Scanner;

public class BookList 
{
	   public void BookFull(Book[] books)
	   {
		      Scanner scan = new Scanner(System.in);
		      String i= null;
		      
		      System.out.print("검색할 책의 번호를 입력하세요 : ");
		      i = scan.next();
		      
		      for(int j = 0; j< books.length; j++)
		      {
		    	  
		    	  //System.out.println(books[j]);
		    	  
		    	  if(i.equals(books[j].getId()))
		    	  {
				      /*System.out.println("책제목 : " + books[j].getTitle() + "\n" + 
				    		  				"책저자 : "+ books[j].getAuthor() + "\n" + 
				    		  				"책가격 : " + books[j].getPrice());*/
		    		  
		    		  books[j].allShow();
		    	  }
		    	  
		      }
		      
		      
		   }

	}