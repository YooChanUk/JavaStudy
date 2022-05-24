package YCU;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowSearch 
{
	public void showList(CompactDisc[] cd) // 전체보기
	{
		System.out.println("바코드번호  음반명   음악가 가격 출시년도 보유재고갯수");
		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i] != null)
			cd[i].Showall();
		}
	}
	
	public void showArtistName(CompactDisc[] cd) // 가수명으로 보기
	{
		String searchname = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾을 가수 이름 입력 : ");
		searchname = sc.next();


		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i].getArtistname().equals(searchname))
			{
				cd[i].Showall();
			}
		}
	}
	
	public void haveNumSearch(CompactDisc[] cd) //가격범위로 찾기
	{
		System.out.println("가격의 범위를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		int min = 999999,max = 0;
		
		try
		{
			System.out.println("최소값 : ");
			min = sc.nextInt();
			System.out.println("최대값 : ");
			max = sc.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("잘못된 입력값 입니다.");
			sc.next();
			haveNumSearch(cd);
		}
		
		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i].getPrice() >= min && cd[i].getPrice() <= max)
			{
				cd[i].Showall();
			}
		}
		
	}
	
	public void songNameSort(CompactDisc[] cd) //음반명순 정렬
	{
		CompactDisc[] ccd = (CompactDisc[])cd.clone();
		//int temp = 0;
		//String tmp = null;
		
		for(int i = 0; i < ccd.length; i++)
		{
			for(int j = 0; j < ccd.length; j++)
			{
				int res = ccd[i].getSongname().compareTo(ccd[j].getSongname());
				//System.out.println(res);
				
				if(res <= 0)
				{
					//바코드명 변경
					/*tmp = ccd[i].getBarcodenum();
					ccd[i].setBarcodenum(ccd[j].getBarcodenum());
					ccd[j].setBarcodenum(tmp);
					
					//음반명 변경
					tmp = ccd[i].getSongname();
					ccd[i].setSongname(ccd[j].getSongname());
					ccd[j].setSongname(tmp);
					
					//가수명 변경
					tmp = ccd[i].getArtistname();
					ccd[i].setArtistname(ccd[j].getArtistname());
					ccd[j].setArtistname(tmp);
					
					//가격 변경
					temp = ccd[i].getPrice();
					ccd[i].setPrice(ccd[j].getPrice());
					ccd[j].setPrice(temp);
					
					//출시날 변경
					temp = ccd[i].getOpenday();
					ccd[i].setOpenday(ccd[j].getOpenday());
					ccd[j].setOpenday(temp);
					*/
					
					CompactDisc tmp = ccd[i];
					ccd[i] = ccd[j];
					ccd[j] = tmp;
					
				}
			}
		}
		
		for(int i = 0; i < ccd.length; i++)
		{
			ccd[i].Showall();
		}
	}
}