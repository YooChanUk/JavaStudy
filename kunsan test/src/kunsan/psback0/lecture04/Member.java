package kunsan.psback0.lecture04;

public class Member 
{
	String id = null;
	String password = null;
	String name = null;
	int isAdmin = -1;
	
	public Member(String id,String password, String name, int isAdmin)
	{
		this.id = id;
		this.password = password;
		this.name = name;
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() 
	{
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", isAdmin=" + isAdmin + "]";
	}
	
	public String toString(String en) 
	{
		return "Member [id=" + id + ", password=" + password + "(" + en + ")" + " + , name=" + name + ", isAdmin=" + isAdmin + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
}

class Admin extends Member
{
	public Admin(String id, String password, String name, int isAdmin) 
	{
		super(id, password, name, isAdmin);
	}

	@Override
	public String toString(String en) 
	{
		return "Admin [id=" + id + ", password=" + password + "(" + en + ")" + ", name=" + name + ", isAdmin=" + isAdmin + "]";
	}
	
}
