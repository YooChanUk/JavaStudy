package MidFixStudent;

import java.util.Arrays;

public class ShowCompare 
{
	public void birthdayCompare(Student[] std)
	{
		int max=0;
		int min=9999;
		
		for(int i = 0; i < std.length; i++)
		{
			if(max < std[i].getBirthday())
			{
				max = std[i].getBirthday();
			}
			
			if(min > std[i].getBirthday())
			{
				min = std[i].getBirthday();
			}
		}
		
		System.out.println("최저연령자 : " + max +" 나이 : " + (2022-max+1) + "세");
		System.out.println("최고령자 : " + min +" 나이 : " + (2022-min+1) + "세");
	}
	
	
	public void avgMid(Student[] std)
	{
		int sum = 0;
		int[] middle = new int[std.length];
		
		for(int i = 0; i<std.length; i++)
		{
			sum += std[i].getSchoolyear();
			middle[i] = std[i].getSchoolyear();
		}
		
		Arrays.sort(middle);
		
		System.out.println("평균 입학년도 : " + sum/std.length);
		
		if(std.length % 2 == 0)
		{
			int midavg = ((middle[std.length/2] + middle[std.length/2-1]) / 2);
			System.out.println("중위 입학년도 : " + midavg);
		}
		else
		{
			System.out.println("중위 입학년도 : " + middle[std.length/2]);
		}

	}
}
