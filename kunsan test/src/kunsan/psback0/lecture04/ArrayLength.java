package kunsan.psback0.lecture04;
import java.util.Scanner;

public class ArrayLength{
   public double getInput(int n) 
   {
      int intArray[] = new int[n];
      int sum = 0;
      double avg = 0.0;
      
      Scanner scanner = new Scanner(System.in);
      
      System.out.print(intArray.length+"개의 정수를 입력하세요>>");
      
      for(int i=0; i<intArray.length; i++)
         intArray[i] = scanner.nextInt();
      for(int i=0; i<intArray.length; i++)
         sum +=intArray[i];
      
      avg = (double)sum/intArray.length;
      System.out.print("평균은"+avg);
      return avg;
   }
   public static void main(String args[])
   {
      ArrayLength test8 = new ArrayLength();
      test8.getInput(0);
   }
}
