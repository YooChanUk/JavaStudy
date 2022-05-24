package 자바심화;

public class Test 
{
	//세 사람의 3과목 20문제
	int[][] 청하 = new int[3][20];
	int[][] 소향 = new int[3][20];
	int[][] 펑티모 = new int[3][20];
	int[][] 정답 = new int[3][20];
	int[] 청하sub = new int[3];
	int[] 소향sub = new int[3];
	int[] 펑티모sub = new int[3];
	
	public Test()
	{
		for(int i=0; i<3; i++)
		{	//각각의 과목 초기화
			청하sub[i] = 0;
			소향sub[i] = 0;
			펑티모sub[i] = 0;
			
			for(int j=0; j<20; j++)
			{
				//i의 0= 언어 1=외국어 2=수리
				//j는 이중배열안의 문제의숫자
				//3사람의 3과목 20문제와 정답문제 객관식 설정(애들이 너무 점수가 낮으니까 정답의 범위를 줄인다)
				청하[i][j] = (int)(Math.random()*2+1);
				펑티모[i][j] = (int)(Math.random()*2+1);
				소향[i][j] = (int)(Math.random()*2+1);
				정답[i][j] = (int)(Math.random()*2+1);
			}
			
		}
	}
	
	//이제 해야하는 일은 소향,청하,펑티모 각각 3영역 총점구하기 + 수정 : 청하,소향,펑티모의 각각의 과목 점수도 배열처리?
	public void score()
	{ 
		int temp = 0;
		
		
		//청하 총점 구하기
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<20; j++)
			{
				if(청하[i][j] == 정답[i][j])
				{
					temp++;
				}
			}
			청하sub[i] = 청하sub[i] + (temp*5);
			temp=0;
		}
		
		
		
		//소향 총점 구하기
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<20; j++)
			{
				if(소향[i][j] == 정답[i][j])
				{
					temp++;
				}
			}
			소향sub[i] = 소향sub[i] + (temp*5);
			temp=0;
		}
	
		
		
		//펑티모 총점 구하기
		for(int i=0; i<3; i++)
		{
			temp = 0;
			for(int j=0; j<20; j++)
			{
				if(펑티모[i][j] == 정답[i][j])
				{
					temp++;
				}
			}
			펑티모sub[i] = 펑티모sub[i] + (temp*5);
			temp=0;
		}
		
		
	}
	
	public void language(int la)
	{
		System.out.println("언어영역");
		System.out.print("청하 : ");
		for(int i=0; i < 20; i++)
		{
			if(청하[la][i] == 정답[la][i])
			{
				System.out.print("O ");
			}
			else if(청하[la][i] != 정답[la][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 청하sub[la]);
		
		
		System.out.print("소향 : ");
		for(int i=0; i < 20; i++)
		{
			if(소향[la][i] == 정답[la][i])
			{
				System.out.print("O ");
			}
			else if(소향[la][i] != 정답[la][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 소향sub[la]);
		
		
		System.out.print("펑티모 : ");
		for(int i=0; i < 20; i++)
		{
			if(펑티모[la][i] == 정답[la][i])
			{
				System.out.print("O ");
			}
			else if(펑티모[la][i] != 정답[la][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 펑티모sub[la]);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	public void forein(int fo)
	{
		System.out.println("외국어영역");
		System.out.print("청하 : ");
		for(int i=0; i < 20; i++)
		{
			if(청하[fo][i] == 정답[fo][i])
			{
				System.out.print("O ");
			}
			else if(청하[fo][i] != 정답[fo][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 청하sub[fo]);
		
		
		System.out.print("소향 : ");
		for(int i=0; i < 20; i++)
		{
			if(소향[fo][i] == 정답[fo][i])
			{
				System.out.print("O ");
			}
			else if(소향[fo][i] != 정답[fo][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 소향sub[fo]);
		
		
		System.out.print("펑티모 : ");
		for(int i=0; i < 20; i++)
		{
			if(펑티모[fo][i] == 정답[fo][i])
			{
				System.out.print("O ");
			}
			else if(펑티모[fo][i] != 정답[fo][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 펑티모sub[fo]);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	public void math(int ma)
	{
		System.out.println("수리영역");
		System.out.print("청하 : ");
		for(int i=0; i < 20; i++)
		{
			if(청하[ma][i] == 정답[ma][i])
			{
				System.out.print("O ");
			}
			else if(청하[ma][i] != 정답[ma][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 청하sub[ma]);
		
		
		System.out.print("소향 : ");
		for(int i=0; i < 20; i++)
		{
			if(소향[ma][i] == 정답[ma][i])
			{
				System.out.print("O ");
			}
			else if(소향[ma][i] != 정답[ma][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 소향sub[ma]);
		
		
		System.out.print("펑티모 : ");
		for(int i=0; i < 20; i++)
		{
			if(펑티모[ma][i] == 정답[ma][i])
			{
				System.out.print("O ");
			}
			else if(펑티모[ma][i] != 정답[ma][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("총점 : " + 펑티모sub[ma]);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	}
	
	//sub(과목)으로 3명의 3과목당 점수를 배열에 저장완료
	//이제 할일은 지역변수로 총점과 평균을 만들어 출력하고 학점을 출력
	
	public void print()
	{
		int[] ave = new int[3]; //ave 0은 청하의 평균 1은 소향의 평균 2는 펑티모의 평균
		System.out.println("       언어 / 외국어 / 수리 /  총점/  평균/  학점");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.print("청하 :   ");
		for(int e: 청하sub)
		{
			System.out.print(e + " /  ");
		}
		System.out.print((청하sub[0]+청하sub[1]+청하sub[2] + " /  "));
		ave[0] = (청하sub[0]+청하sub[1]+청하sub[2])/3;
		System.out.print(ave[0] + "  /  ");
		if(ave[0] >= 60)
		{
			System.out.print("A");
		}
		else if(ave[0] >= 50)
		{
			System.out.print("B");
		}
		else if(ave[0] >= 10 )
		{
			System.out.print("C");
		}
		System.out.println("");
		
		
		System.out.print("소향 :   ");
		for(int e: 소향sub)
		{
			System.out.print(e + " /  ");
		}
		System.out.print((소향sub[0]+소향sub[1]+소향sub[2] + " /  "));
		ave[1] = (소향sub[0]+소향sub[1]+소향sub[2])/3;
		System.out.print(ave[1] + "  /  ");
		if(ave[1] >= 60)
		{
			System.out.print("A");
		}
		else if(ave[1] >= 50)
		{
			System.out.print("B");
		}
		else if(ave[1] >= 10 )
		{
			System.out.print("C");
		}
		System.out.println("");
		
		
		System.out.print("펑티모 :  ");
		for(int e: 펑티모sub)
		{
			System.out.print(e + " /  ");
		}
		System.out.print((펑티모sub[0]+펑티모sub[1]+펑티모sub[2] + " /  "));
		ave[2] = (펑티모sub[0]+펑티모sub[1]+펑티모sub[2])/3;
		System.out.print(ave[2] + "  /  ");
		if(ave[2] >= 60)
		{
			System.out.print("A");
		}
		else if(ave[2] >= 50)
		{
			System.out.print("B");
		}
		else if(ave[2] >= 10 )
		{
			System.out.print("C");
		}
		System.out.println("");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
	}
	
	//마지막 과목영역중 가장 높은 사람의 점수 낮은사람의 점수 출력 지역변수로 max,min을 만든뒤 for문? 으로 찾아내기
	//sub[i] 0은 언어, 1외국어, 2수리
	public void print2(int max, int min)
	{
		System.out.print("max : ");
		for(int i=0; i<3; i++)
		{
			if(청하sub[i] > max)
			{
				max = 청하sub[i];
				
				if(소향sub[i] > max)
				{
					max = 소향sub[i];
				}
				else if(펑티모sub[i] > max)
				{
					max = 펑티모sub[i];
				}
				
			}
			System.out.print(max + "  /  ");
			max = 0;
		}
		System.out.println("");
		
		System.out.print("min : ");
		for(int i=0; i<3; i++)
		{
			if(청하sub[i] < min)
			{
				min = 청하sub[i];
				
				if(소향sub[i] < min)
				{
					min = 소향sub[i];
				}
				else if(펑티모sub[i] < min)
				{
					min = 펑티모sub[i];
				}
				
			}
			System.out.print(min + "  /  ");
			min = 100;
		}
	}
	
	public static void main(String[] args) 
	{
		
		Test ace = new Test();//문제지 와 정답지를 준비
		ace.score();
		ace.language(0); //0은 언어 1은 외국어 2는 수리
		ace.forein(1);
		ace.math(2);
		ace.print();
		ace.print2(0,100);
	}

}
