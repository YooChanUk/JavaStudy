package kunsan.psback0.lecture04;

import java.util.ArrayList;
import java.util.Base64;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MemberManagement 
{
	Scanner sc = new Scanner(System.in);
	
	public Member login()
	{
		String filepath = "Member.txt";
		ArrayList<Object> m = new ArrayList<Object>();
		m = readData(filepath);
		
		Member n = null;
		String decpass = null;
		
		System.out.println("로그인을 시도합니다.");	
		
		
		while(true)
		{
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("Password : ");
			String password = sc.next();
			for(int i = 0; i < m.size(); i++)
			{
				try 
				{
					decpass = Decrypt(((Member) m.get(i)).getPassword(),"Key");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(((Member) m.get(i)).getId().equals(id) && decpass.equals(password))
				{
					n = (Member) m.get(i);
					System.out.println(n.toString(decpass));
					System.out.println("위 정보로 로그인에 성공하였습니다.!");
					return n;
				}
			}
			System.out.println("아이디나 비밀번호가 없습니다. 다시 입력해주세요.");
		}
	}
	
	public void createMember(ArrayList<Object> m,String filepath) // 회원가입
	{	
		String id = null; 
		String password = null;
		String name = null;
		int kind = -1;
		Object n = null;
		
		System.out.println("회원가입을 시작합니다.");
		System.out.println("회원가입 구분(Admin - 1 / Member - 0) : ");

		for(; kind < 0;)
		{
			try 
			{
				kind = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 입력값 입니다. ");
			}
			
			if(kind < 0)
			{
				System.out.println("구분 형식에 음수는 없습니다.");
			}
			if(kind > 1)
			{
				System.out.println("구분 형식에 1을 초과한 숫자는 없습니다.");
				kind = -1;
			}
		}
		
		System.out.println("Id : ");
		id = sc.next();
		System.out.println("Password : ");
		password = sc.next();
		try 
		{
			password = Encrypt(password, "Key");
		}
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Name : ");
		name = sc.next();

		
		
		switch(kind)
		{
		case 0:  m.add(n = new Member(id,password,name,kind));
			break;
		case 1:  m.add(n = new Admin(id,password,name,kind));
			break;
		}
		System.out.println("새로운 아이디 : " + id + "를 생성하셨습니다.");
		
		try 
		{
			FileOutputStream fop = new FileOutputStream(filepath, true);
			DataOutputStream dos = new DataOutputStream(fop);


			dos.writeUTF( ((Member) n).getId() );
			dos.writeUTF( ((Member) n).getPassword() );
			dos.writeUTF( ((Member) n).getName() );
			dos.writeInt( ((Member) n).getIsAdmin() );
			dos.writeUTF("\n");

			dos.close();
		}
		catch (IOException e) 
		{
			System.out.println("DataIOTest : " + e);
		}
	}
	
	public void updateMember(ArrayList<Object> m ,String filepath,Member n) // 수정
	{
		System.out.println("수정은 본인이거나 관리자만 수정 할 수 있습니다.");
		System.out.println("1) pass 수정");
		System.out.println("2) 이름 수정");
		System.out.print("선택 : ");
		int kind = -1;
		boolean bool = false;
		

		
		for(; kind < 0;)
		{
			try 
			{
				kind = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("잘못된 입력값 입니다. ");
			}
			
			if(kind < 0)
			{
				System.out.println("구분 형식에 음수는 없습니다.");
			}
			if(kind > 2)
			{
				System.out.println("구분 형식에 2를 초과한 숫자는 없습니다.");
				kind = -1;
			}
		}
		
		String password = null;
		String name = null;
			
		if(n.getIsAdmin() == 1)
		{
			System.out.println("관리자이십니다.");
			System.out.println("수정할 아이디를 입력해주세요 : ");
			String id = sc.next();
		
			for(int i = 0; i < m.size(); i++)
			{
				if(bool = ((Member) m.get(i)).getId().equals(id))
				{
					System.out.print("수정할 아이디의 전체 정보는 : ");
					System.out.println(m.get(i).toString() + "입니다.");
					
					if(kind == 1)
					{
						System.out.println("수정할 비밀번호는 : ");
						password = sc.next();
						try 
						{
							password = Encrypt(password, "Key");
						}
						catch (Exception e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						((Member) m.get(i)).setPassword(password);
					}

					if(kind == 2)
					{
						System.out.println("수정할 이름은 : ");
						name = sc.next();
						((Member) m.get(i)).setName(name);
					}

				}
			}
			if(!bool)
			{
				System.out.println(id + "는 없는 아이디입니다.");
			}
	
			writeData(m,filepath);
		}
		
		else if(n.getIsAdmin() == 0)
		{
			System.out.println("회원 본인으로 로그인되 있으십니다.");
			System.out.println("본인의 아이디가 수정되길 원합니까?(수정 : 1 / 수정 안함 : 2) : ");
			int yn = sc.nextInt();
			
			if(yn == 1)
			{
				for(int i = 0; i < m.size(); i++)
				{
					if(((Member) m.get(i)).getId().equals(n.getId()))
					{
						System.out.print("수정할 아이디의 전체 정보는 : ");
						System.out.println(m.get(i).toString() + "입니다.");
						
						if(kind == 1)
						{
							System.out.println("수정할 비밀번호는 : ");
							password = sc.next();
							try 
							{
								password = Encrypt(password, "Key");
							}
							catch (Exception e1) 
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							((Member) m.get(i)).setPassword(password);
						}

						if(kind == 2)
						{
							System.out.println("수정할 이름은 : ");
							name = sc.next();
							((Member) m.get(i)).setName(name);
						}
					}
				}
				
				writeData(m,filepath);
			}
		}
	}
	
	public void allshow(ArrayList<Object> m) // 전부 보기 출력
	{
		String en = null;
		
		for(Object n : m)
		{
			try 
			{
				en = Decrypt(((Member)n).getPassword(),"Key");
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(n instanceof Admin)
			    System.out.println(((Admin)n).toString(en));
	    	else if(n instanceof Member)
			    System.out.println(((Member)n).toString(en));
		}
		
	}
	
	public void delectMember(ArrayList<Object> m, String filepath,Member n) // 삭제
	{
		System.out.println("삭제는 본인이거나 관리자만 삭제를 할 수 있습니다.");
		
		if(n.getIsAdmin() == 1)
		{
			System.out.println("관리자이십니다.");
			System.out.println("삭제할 아이디를 입력해주세요 : ");
			String id = sc.next();
			
			for(int i = 0; i < m.size(); i++)
			{
				if(((Member) m.get(i)).getId().equals(id))
				{
					System.out.print("삭제되는 아이디의 정보는 : ");
					System.out.println(m.get(i).toString() + "입니다.");
					m.remove(i);
				}
			}
			writeData(m,filepath);
		}
		else if(n.getIsAdmin() == 0)
		{
			System.out.println("회원 본인이십니다.");
			System.out.println("본인의 아이디가 삭제되길 원합니까?(삭제 : 1 / 삭제 안함 : 2) : ");
			int yn = sc.nextInt();
			
			if(yn == 1)
			{
				for(int i = 0; i < m.size(); i++)
				{
					if(((Member) m.get(i)).getId().equals(n.getId()))
					{
						System.out.print("삭제되는 아이디의 정보는 : ");
						System.out.println(m.get(i).toString() + "입니다.");
						m.remove(i);
						n = null;
					}
				}
				writeData(m,filepath);
				System.out.println("아이디가 삭제되어 다시 로그인 화면으로 돌아갑니다.");
				login();
			}
		}

	}
	
	
	public void writeData( ArrayList<Object> m, String filePath) 
	{
		writeData(m, filePath, false);
	}

	public void writeData(ArrayList<Object> m, String filepath, boolean isAppend) //수정용(덮어쓰기)
	{
		try 
		{
			FileOutputStream fop = new FileOutputStream(filepath, isAppend);
			DataOutputStream dos = new DataOutputStream(fop);
			

			for(Object n : m)
			{
				dos.writeUTF( ((Member) n).getId() );
				dos.writeUTF( ((Member) n).getPassword() );
				dos.writeUTF( ((Member) n).getName() );
				dos.writeInt( ((Member) n).getIsAdmin() );
				dos.writeUTF("\r \n");
			}

			dos.close();
		}
		catch (IOException e) 
		{
			System.out.println("DataIOTest : " + e);
		}
	}
	
	public ArrayList<Object> readData(String filePath) 
	{
		String name = null;
		String password = null;
		String id = null;
		int kind = -1;
		boolean EOF = false;
		
		ArrayList<Object> m = new ArrayList<Object>();
		
		File f = new File(filePath);
		
		if(!f.exists()) // 파일이 존재하지 않을경우 파일 생성 및 기본 관리자 계정생성
		{
			FileOutputStream fop;
			try 
			{
				m.add(new Member("root",Encrypt("1234","Key"),"관리자",1));
			} 
			catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try 
			{
				fop = new FileOutputStream(filePath);
				DataOutputStream dos = new DataOutputStream(fop);
				
				dos.writeUTF( ((Member) m.get(0)).getId() );
				dos.writeUTF( ((Member) m.get(0)).getPassword() );
				dos.writeUTF( ((Member) m.get(0)).getName() );
				dos.writeInt( ((Member) m.get(0)).getIsAdmin() );
				dos.writeUTF("\r \n");
				dos.close();
			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		

		
    // reading part
		try {
			FileInputStream fis = new FileInputStream(filePath);
			DataInputStream dis = new DataInputStream(fis);

			while (!EOF) 
			{
				try 
				{
					id = dis.readUTF();
					password = dis.readUTF();
					name = dis.readUTF();
					kind = dis.readInt();
					dis.readUTF();
					System.out.printf( "%s|%s|%s|%d\n", id, password, name, kind);
					
					switch(kind)
					{
					case 0 : m.add(new Member(id,password,name,kind));
						break;
					case 1 : m.add(new Admin(id,password,name,kind));
						break;
					}
					
				} 
				catch (EOFException e) 
				{
					EOF = true;
				}
			}
			dis.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("DataIOTest : " + e);
		} 
		catch (IOException e) 
		{
			System.out.println("DataIOTest : " + e);
		}
		
		return m;
	}
	
	public void Menu(Member n)
	{
		int select = 0;
		
		String filepath = "Member.txt";	
		ArrayList<Object> m = new ArrayList<Object>();
		m = readData(filepath);
		
		while(true)
		{
			System.out.println("1) 신규 회원가입");
			System.out.println("2) 회원정보 수정");
			System.out.println("3) 회원 삭제");
			System.out.println("4) 회원 정보보기");
			System.out.println("5) 이전 화면으로");
			
			System.out.print("선택 : ");
			try
			{
				select = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("정확한 값을 입력해주세요.");
				sc.next();
			}

			
			switch(select)
			{
			case 1 : createMember(m,filepath);
				break;
			case 2 : updateMember(m,filepath,n);
				break;
			case 3 : delectMember(m,filepath,n);
				break;
			case 4 : allshow(m);
				break;
			case 5 : System.out.println("이전 화면으로 돌아갑니다.");
				return;
			default : System.out.println("해당 되는 입력값이 없습니다.");
				break;
			}
		}
	}
	
	
	public static String Decrypt(String text, String key) throws Exception
	{

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length)
			len = keyBytes.length;

		System.arraycopy(b, 0, keyBytes, 0, len);

		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);

		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		Decoder decoder = Base64.getDecoder();

		byte[] results = cipher.doFinal(decoder.decode(text));

		return new String(results, "UTF-8");

	}

	public static String Encrypt(String text, String key) throws Exception

	{

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

		byte[] keyBytes = new byte[16];

		byte[] b = key.getBytes("UTF-8");

		int len = b.length;

		if (len > keyBytes.length)
			len = keyBytes.length;

		System.arraycopy(b, 0, keyBytes, 0, len);

		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);

		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));

		Encoder encoder = Base64.getEncoder();

		return encoder.encodeToString(results);

	}
}
