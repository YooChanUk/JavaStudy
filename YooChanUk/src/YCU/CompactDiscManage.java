package YCU;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompactDiscManage 
{
	CompactDisc[] getCompactDisc()
	{
		Scanner sc = new Scanner(System.in);
		String barcodenum = null,songname = null,artistname = null;
		int price = 0,openday = 0,havenum = 0;
		int n = 0;
		
		while(n<=0)
		{
			System.out.print("CD의 종류는 몇개 있습니까? : ");
			n = sc.nextInt();
			
			if(n<=0)
			{
				System.out.print("CD의 종류가 0개 또는 그 아래 입니다. 다시 입력해주십시오");
			}
		}

		
		CompactDisc[] cd = new CompactDisc[n];
		
		for(int i = 0; i < cd.length; i++)
		{
			try
			{
				System.out.println(i + "번째 디스크 상황 받기");
				
				System.out.print("바코드 번호 입력 : ");
				barcodenum = sc.next();
				System.out.print("노래 이름 입력 : ");
				songname = sc.next();
				System.out.print("가수 이름 입력 : ");
				artistname = sc.next();
				
				System.out.print("가격 입력 : ");
				price = sc.nextInt();
				System.out.print("출시년도 입력 : ");
				openday = sc.nextInt();
				System.out.print("보유 재고 입력 : ");
				havenum = sc.nextInt();
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 값이 입력되었습니다!");
				sc.nextLine();
			}

			
			cd[i] = new CompactDisc(barcodenum,songname,artistname
					,price,openday, havenum);
		}
		
		return cd;
	}
	
	/*CompactDisc[] cdDelect(CompactDisc[] cd) //cd삭제
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 음반의 바코드 번호 : ");
		String barcode = sc.next();
		//boolean del = false;
		CompactDisc[] ccd = null;
		int delnum = 0;
		int tmp = 0;
		
		
		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i].getBarcodenum().equals(barcode))
			{	
				delnum = i;
			}
					
		}
		
		ccd = new CompactDisc[cd.length - 1];
		
		for(int i = 0; i < ccd.length; i++)
		{
			if(delnum == i)
			{
				tmp++;
			}
			
			ccd[i] = cd[tmp];
			tmp++;
			

		}
		
		for(int i = 0; i < ccd.length; i++)
		{
			ccd[i].Showall();	
		}
		
		return ccd;
	}*/
	
	public void cdDelect(CompactDisc[] cd)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 음반의 바코드 번호 : ");
		String barcode = sc.next();
		
		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i] != null)
			{
				if(cd[i].getBarcodenum().equals(barcode))
				{
					cd[i] = null;
				}
			}
			
			if(cd[i] != null)
			{
				cd[i].Showall();
			}
					
		}
	}
	
	public void haveNumUpdate(CompactDisc[] cd) // 재고 변경
	{
		Scanner sc = new Scanner(System.in);
		int havenum = 0;
		System.out.print("재고 개수 변경할 cd 바코드 번호 : ");
		String barcode = sc.next();
		
		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i].getBarcodenum().equals(barcode))
			{
				cd[i].Showall();
				
				while(havenum <= 0)
				{
					System.out.print("변경 재고 입력 : ");
					try
					{
						havenum = sc.nextInt();
					}
					catch(InputMismatchException e)
					{
						System.out.println("잘못된 값이 입력되었습니다!");
						sc.next();
					}

					
					if(havenum < 0)
					{
						System.out.println("변경재고는 음수일수 없습니다.");
					}
				}

				
				cd[i].setHavenum(havenum);
				
				cd[i].Showall();
			}
		}
		
		

	}
	
	public void compactDiscModify(CompactDisc[] cd) // 수정
	{
		Scanner sc = new Scanner(System.in);
		String barcodenum = null,songname = null,artistname = null;
		int price = 0,openday = 0;
		
		System.out.print("수정할 cd 바코드 번호 : ");
		String barcode = sc.next();

		for(int i = 0; i < cd.length; i++)
		{
			if(cd[i].getBarcodenum().equals(barcode))
			{
				System.out.print("수정할 바코드 번호 입력 : ");
				barcodenum = sc.next();
				System.out.print("수정할 노래 이름 입력 : ");
				songname = sc.next();
				System.out.print("수정할 가수 이름 입력 : ");
				artistname = sc.next();
				
				System.out.print("수정할 가격 입력 : ");
				price = sc.nextInt();
				System.out.print("수정할 출시년도 입력 : ");
				openday = sc.nextInt();
				
				cd[i].setBarcodenum(barcodenum);
				cd[i].setSongname(songname);
				cd[i].setArtistname(artistname);
				cd[i].setPrice(price);
				cd[i].setOpenday(openday);
				
			}
		}
		
		for(int i = 0; i < cd.length; i++)
		{
			cd[i].Showall();
		}

	}
}
