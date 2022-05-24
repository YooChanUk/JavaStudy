package kunsan.psback0.lecture04;
import java.util.Scanner;
import java.lang.*;

public class CoffeePrice 
{
	public void calcPrice() 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("무슨 커피 드릴까요?(에스프레소,카푸치노,카페라떼,아메리카노) ");
		String order = scanner.next();
		
		int price=0;
		
		switch (order) 
		{
			case "에스프레소":
			case "카푸치노":
			case "카페라떼":
				price = 3500;
				break;
			case "아메리카노" :
				price = 2000;
				break;
			default:
				System.out.println("메뉴에 없습니다!");
		}
		
		if(price != 0)
		{
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.println(order + "는 " + price + "원입니다\n");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
	}
	
	/*public static void main(String args[])
	{
		CoffeePrice cp = new CoffeePrice();
		cp.calcPrice();
	}*/
}