package �ڹٽ�ȭ;

public class Test 
{
	//�� ����� 3���� 20����
	int[][] û�� = new int[3][20];
	int[][] ���� = new int[3][20];
	int[][] ��Ƽ�� = new int[3][20];
	int[][] ���� = new int[3][20];
	int[] û��sub = new int[3];
	int[] ����sub = new int[3];
	int[] ��Ƽ��sub = new int[3];
	
	public Test()
	{
		for(int i=0; i<3; i++)
		{	//������ ���� �ʱ�ȭ
			û��sub[i] = 0;
			����sub[i] = 0;
			��Ƽ��sub[i] = 0;
			
			for(int j=0; j<20; j++)
			{
				//i�� 0= ��� 1=�ܱ��� 2=����
				//j�� ���߹迭���� �����Ǽ���
				//3����� 3���� 20������ ���乮�� ������ ����(�ֵ��� �ʹ� ������ �����ϱ� ������ ������ ���δ�)
				û��[i][j] = (int)(Math.random()*2+1);
				��Ƽ��[i][j] = (int)(Math.random()*2+1);
				����[i][j] = (int)(Math.random()*2+1);
				����[i][j] = (int)(Math.random()*2+1);
			}
			
		}
	}
	
	//���� �ؾ��ϴ� ���� ����,û��,��Ƽ�� ���� 3���� �������ϱ� + ���� : û��,����,��Ƽ���� ������ ���� ������ �迭ó��?
	public void score()
	{ 
		int temp = 0;
		
		
		//û�� ���� ���ϱ�
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<20; j++)
			{
				if(û��[i][j] == ����[i][j])
				{
					temp++;
				}
			}
			û��sub[i] = û��sub[i] + (temp*5);
			temp=0;
		}
		
		
		
		//���� ���� ���ϱ�
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<20; j++)
			{
				if(����[i][j] == ����[i][j])
				{
					temp++;
				}
			}
			����sub[i] = ����sub[i] + (temp*5);
			temp=0;
		}
	
		
		
		//��Ƽ�� ���� ���ϱ�
		for(int i=0; i<3; i++)
		{
			temp = 0;
			for(int j=0; j<20; j++)
			{
				if(��Ƽ��[i][j] == ����[i][j])
				{
					temp++;
				}
			}
			��Ƽ��sub[i] = ��Ƽ��sub[i] + (temp*5);
			temp=0;
		}
		
		
	}
	
	public void language(int la)
	{
		System.out.println("����");
		System.out.print("û�� : ");
		for(int i=0; i < 20; i++)
		{
			if(û��[la][i] == ����[la][i])
			{
				System.out.print("O ");
			}
			else if(û��[la][i] != ����[la][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + û��sub[la]);
		
		
		System.out.print("���� : ");
		for(int i=0; i < 20; i++)
		{
			if(����[la][i] == ����[la][i])
			{
				System.out.print("O ");
			}
			else if(����[la][i] != ����[la][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + ����sub[la]);
		
		
		System.out.print("��Ƽ�� : ");
		for(int i=0; i < 20; i++)
		{
			if(��Ƽ��[la][i] == ����[la][i])
			{
				System.out.print("O ");
			}
			else if(��Ƽ��[la][i] != ����[la][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + ��Ƽ��sub[la]);
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
	}
	
	public void forein(int fo)
	{
		System.out.println("�ܱ����");
		System.out.print("û�� : ");
		for(int i=0; i < 20; i++)
		{
			if(û��[fo][i] == ����[fo][i])
			{
				System.out.print("O ");
			}
			else if(û��[fo][i] != ����[fo][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + û��sub[fo]);
		
		
		System.out.print("���� : ");
		for(int i=0; i < 20; i++)
		{
			if(����[fo][i] == ����[fo][i])
			{
				System.out.print("O ");
			}
			else if(����[fo][i] != ����[fo][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + ����sub[fo]);
		
		
		System.out.print("��Ƽ�� : ");
		for(int i=0; i < 20; i++)
		{
			if(��Ƽ��[fo][i] == ����[fo][i])
			{
				System.out.print("O ");
			}
			else if(��Ƽ��[fo][i] != ����[fo][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + ��Ƽ��sub[fo]);
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
	}
	
	public void math(int ma)
	{
		System.out.println("��������");
		System.out.print("û�� : ");
		for(int i=0; i < 20; i++)
		{
			if(û��[ma][i] == ����[ma][i])
			{
				System.out.print("O ");
			}
			else if(û��[ma][i] != ����[ma][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + û��sub[ma]);
		
		
		System.out.print("���� : ");
		for(int i=0; i < 20; i++)
		{
			if(����[ma][i] == ����[ma][i])
			{
				System.out.print("O ");
			}
			else if(����[ma][i] != ����[ma][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + ����sub[ma]);
		
		
		System.out.print("��Ƽ�� : ");
		for(int i=0; i < 20; i++)
		{
			if(��Ƽ��[ma][i] == ����[ma][i])
			{
				System.out.print("O ");
			}
			else if(��Ƽ��[ma][i] != ����[ma][i])
			{
				System.out.print("X ");
			}
		}
		System.out.println("���� : " + ��Ƽ��sub[ma]);
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
	}
	
	//sub(����)���� 3���� 3����� ������ �迭�� ����Ϸ�
	//���� ������ ���������� ������ ����� ����� ����ϰ� ������ ���
	
	public void print()
	{
		int[] ave = new int[3]; //ave 0�� û���� ��� 1�� ������ ��� 2�� ��Ƽ���� ���
		System.out.println("       ��� / �ܱ��� / ���� /  ����/  ���/  ����");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("û�� :   ");
		for(int e: û��sub)
		{
			System.out.print(e + " /  ");
		}
		System.out.print((û��sub[0]+û��sub[1]+û��sub[2] + " /  "));
		ave[0] = (û��sub[0]+û��sub[1]+û��sub[2])/3;
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
		
		
		System.out.print("���� :   ");
		for(int e: ����sub)
		{
			System.out.print(e + " /  ");
		}
		System.out.print((����sub[0]+����sub[1]+����sub[2] + " /  "));
		ave[1] = (����sub[0]+����sub[1]+����sub[2])/3;
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
		
		
		System.out.print("��Ƽ�� :  ");
		for(int e: ��Ƽ��sub)
		{
			System.out.print(e + " /  ");
		}
		System.out.print((��Ƽ��sub[0]+��Ƽ��sub[1]+��Ƽ��sub[2] + " /  "));
		ave[2] = (��Ƽ��sub[0]+��Ƽ��sub[1]+��Ƽ��sub[2])/3;
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
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		
	}
	
	//������ ���񿵿��� ���� ���� ����� ���� ��������� ���� ��� ���������� max,min�� ����� for��? ���� ã�Ƴ���
	//sub[i] 0�� ���, 1�ܱ���, 2����
	public void print2(int max, int min)
	{
		System.out.print("max : ");
		for(int i=0; i<3; i++)
		{
			if(û��sub[i] > max)
			{
				max = û��sub[i];
				
				if(����sub[i] > max)
				{
					max = ����sub[i];
				}
				else if(��Ƽ��sub[i] > max)
				{
					max = ��Ƽ��sub[i];
				}
				
			}
			System.out.print(max + "  /  ");
			max = 0;
		}
		System.out.println("");
		
		System.out.print("min : ");
		for(int i=0; i<3; i++)
		{
			if(û��sub[i] < min)
			{
				min = û��sub[i];
				
				if(����sub[i] < min)
				{
					min = ����sub[i];
				}
				else if(��Ƽ��sub[i] < min)
				{
					min = ��Ƽ��sub[i];
				}
				
			}
			System.out.print(min + "  /  ");
			min = 100;
		}
	}
	
	public static void main(String[] args) 
	{
		
		Test ace = new Test();//������ �� �������� �غ�
		ace.score();
		ace.language(0); //0�� ��� 1�� �ܱ��� 2�� ����
		ace.forein(1);
		ace.math(2);
		ace.print();
		ace.print2(0,100);
	}

}
