package kunsan.psback0.lecture04;

public class Book //implements Comparable<Book>
{
	String title, author,id;
	int price;
	
	public Book(String title, String author,String id,int price)
	{ 
		this.title = title;
		this.author = author;
		this.id = id;
		this.price = price;
	}
	//getter/setter !!!
	
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	public String getId() {return id;}
	public int getPrice() {return price;}
	
	public void setTitle(String title) {this.title = title;}
	public void setAuthor(String author) {this.author = author;}
	public void setId(String id) {this.id = id;}
	public void setPrice(int price) {this.price = price;}
	
	public void allShow()
	{
		System.out.println(this.id + "번 book : " + this.title + " " + 
							this.author + " " +this.price);
	}
	
	
	/*@Override
	public int compareTo(Book books) 
	{
		// TODO Auto-generated method stub
		return this.title.compareTo(books.title);
	}*/
	
}