package test1;

class calculator
{
	int left,right;
	
	public calculator(int left, int right)
	{
		this.left = left;
		this.right = right;
	}

	public void sum()
	{
		System.out.println(this.left+this.right);
	}
	public void avg()
	{
		System.out.println((this.left+this.right)/2);
	}
}

class mincalculator extends calculator
{
	public mincalculator(int left, int right)
	{
	super(left,right);
	}
	
	public void min()
	{
		System.out.println(this.left - this.right);
	}
}

public class Animal {

	public static void main(String[] args)
	{	
		mincalculator c1 = new mincalculator(10,20);
		c1.sum();
		c1.avg();
		c1.min();

	}

}
