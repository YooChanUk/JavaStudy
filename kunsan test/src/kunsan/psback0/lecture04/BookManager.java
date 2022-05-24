package kunsan.psback0.lecture04;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookManager 
{
	Book[] getBooks()
	{
		Scanner sc = new Scanner(System.in);
		int n = 0;

		while(true)
		{
			System.out.println("책이 몇개 있습니까? : ");
			
			try
			{
				n = sc.nextInt();
				break;
			}
			catch(InputMismatchException e)
			{
				System.out.println("정수 값을 입력해주세요.");
				sc.next();
				continue;
			}
		}
		
		Book[] books = new Book[ n ]; 
		
			for(int i=0; i<books.length; i++) 
			{
				sc.nextLine();
				System.out.println((i+1) + "번 " + "Book의 id입력>>");
				String id = sc.nextLine();
				System.out.println((i+1) + "번 " + "Book의 title입력>>");
				String title = sc.nextLine();
				System.out.println((i+1) + "번 " + "Book의 author입력>>");
				String author = sc.nextLine();
				System.out.println((i+1) + "번 " + "Book의 price입력>>");
				int price = sc.nextInt();
				books[i] = new Book(title, author,id,price);
			}
			
			
		return books;
	}
	
	public void printBooks( Book[] books )
	{	
		for(int i=0; i < books.length; i++)
		{
			/*System.out.println(books[i].getId() + "번 book : " + books[i].getTitle() + " " + 
									books[i].getAuthor() + " " + books[i].getPrice());*/
			books[i].allShow();
		}
	}
	
	
	/*public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		BookManager bm = new BookManager();
		bm.printBooks(bm.getBooks());
	}*/

}
