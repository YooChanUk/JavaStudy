package YCU;

public class CompactDisc 
{
	String barcodenum = null,songname = null,artistname = null;
	int price = 0,openday = 0,havenum = 0;
	
	public CompactDisc(String barcodenum,String songname,String artistname
						,int price,int openday, int havenum)
	{
		this.barcodenum = barcodenum;
		this.songname = songname;
		this.artistname = artistname;
		this.price = price;
		this.openday = openday;
		this.havenum = havenum;
	}

	public String getBarcodenum() 
	{
		return barcodenum;
	}

	public void setBarcodenum(String barcodenum) 
	{
		this.barcodenum = barcodenum;
	}

	public String getSongname() 
	{
		return songname;
	}

	public void setSongname(String songname) 
	{
		this.songname = songname;
	}

	public String getArtistname() 
	{
		return artistname;
	}

	public void setArtistname(String artistname) 
	{
		this.artistname = artistname;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public int getOpenday() 
	{
		return openday;
	}

	public void setOpenday(int openday) 
	{
		this.openday = openday;
	}

	public int getHavenum() 
	{
		return havenum;
	}

	public void setHavenum(int havenum) 
	{
		this.havenum = havenum;
	}
	
	public void Showall()
	{
		System.out.println(this.barcodenum + " " + this.songname + " " + 
					this.artistname + " " + this.price + " " + this.openday +
					" " + this.havenum);
	}
	
}