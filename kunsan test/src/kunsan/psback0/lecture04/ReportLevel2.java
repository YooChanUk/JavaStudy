package kunsan.psback0.lecture04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReportLevel2 
{
   public void report()
   {
      
      Scanner scann = new Scanner(System.in);
      int select;
      
      try
      {
	      do
	      {
	         System.out.println("○ 다음의 프로그램들 중에서 수행할 함수를 선택하세요.");
	         System.out.println("1) 커피 메뉴를 넣으면 가격을 출력해 주는 프로그램");
	         System.out.println("2) 입력된 수의 평균과 갯수 구하기해서 화면에 프린트 하기");
	         System.out.println("3) 알파벳 A부터 Z까지 프린트하기");
	         System.out.println("4) 정수와 x와 y를 입력받아, x부터 y까지 더하는 과정과 결과 보이기");
	         System.out.println("5) 99단 단순 찍기");
	         System.out.println("6) 99단 출력단수와 수의 범위 설정해서 프린트하기");
	         System.out.println("0) 종료");
	         System.out.print("선택 : ");
	         select = scann.nextInt();
	         
	            if(select == 1)
	            {
	               CoffeePrice coffee = new CoffeePrice();
	               coffee.calcPrice();
	            }
	            else if(select == 2)
	            {
	               WhileSample sample = new WhileSample();
	               sample.getAverage();
	            }
	            else if(select == 3)
	            {
	               DoWhileSample dowhile = new DoWhileSample();
	               dowhile.printAtoZ();
	            }
	            else if(select == 4)
	            {
	               ForSum ssum = new ForSum();
	               ssum.printSum();   
	            }
	            else if(select == 5)
	            {
	               NestedLoop loop = new NestedLoop();
	               loop.run99();
	            }
	            else if(select == 6)
	            {
	               Run99Simple simple999 = new Run99Simple();
	               simple999.doDialog();
	            }
	      }
	      while(select != 0);
      }
      catch(InputMismatchException e)
      {
         System.out.println("정수를 입력하세요");
         report();
      }
   } 
   public static void main(String[] args) 
   {   
      ReportLevel2 level = new ReportLevel2();
      level.report();
   }

}