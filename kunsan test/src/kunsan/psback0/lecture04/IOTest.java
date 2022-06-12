package kunsan.psback0.lecture04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest 
{
	public void runData()
	{
		try
		{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("invoice1.txt"));
			
			double prices[] = { 19.99, 9.99, 15.99, 3.99, 4.99 };
			int units[] = { 12, 8, 13, 29, 50 };
			String descs[] = { "Java T‐shirt", "Java Mug", 
					"Duke Juggling Dolls", "Java pin", "Java Key Chain" };
			
			for (int i = 0; i < prices.length; i ++) 
			{
				dos.writeDouble(prices[i]);
				dos.writeChar('\t');
				dos.write(units[i]);
				dos.writeChar('\t');
				dos.writeUTF(descs[i]);
				dos.writeChar('\n');
			}
			dos.close();
		}
		catch(IOException e)
		{
			System.out.println("DataIOTest: " + e);
		}
	}
	
	public void inputdata()
	{
		try 
		{
			DataInputStream dis = new DataInputStream(new FileInputStream("invoice1.txt"));
			
			double price;
			int unit;
			String desc;
			boolean EOF = false;
			double total = 0.0;
			
			while(!EOF)
			{
				try
				{
					price = dis.readDouble();
					dis.readChar();
					unit = dis.readInt();
					dis.readChar();
					desc = dis.readLine();
					System.out.println("You've ordered" + unit + "units of" + desc + "at$" + price);
					total = total + unit * price;
				}
				catch(EOFException e)
				{
					EOF = true;
				}
			}
			System.out.println("For a TOTAL of:$" + total);
			dis.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("DATAIOTest:" + e);
		}
		catch(IOException e)
		{
			System.out.println("DATAIOTest:" + e);
		}


	}
	
	public static void main(String[] args) 
	{
		IOTest it = new IOTest();
		it.runData();
		it.inputdata();
	}
}