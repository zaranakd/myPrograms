import java.io.*;
class CTCI_Chap1_Q3
{
	public static void main(String args[])
	{
	System.out.println("Chk if 1 string is the permutation of another");
	try
		{
			System.out.println("String 1:");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String s1=br.readLine();
			System.out.println("String 2:");
			String s2=br.readLine();
			if(s1.length()!=s2.length())
			{
				System.out.println("String 1 is not the permutation of String 2");
				return;
			}
			int chk[]=new int[256];
			for(int i=0;i<s1.length();i++)
			{
				chk[(int)(s1.charAt(i))]++;
			}
			for(int i=0;i<s2.length();i++)
			{
				chk[(int)(s2.charAt(i))]--;
			}
			for(int i=0;i<chk.length;i++)
			{
				if(chk[i]>0)
				{
					System.out.println("String 1 is not the permutation of String 2");
					return;
				}
			}
			System.out.println("String 1 is a permutation of String 2");
		}
		catch(IOException e)
		{
			System.err.println("Error:"+e);
		}
	}
}