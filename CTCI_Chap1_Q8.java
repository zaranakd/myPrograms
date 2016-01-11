import java.io.*;
class CTCI_Chap1_Q8
{
	public static void main(String args[])
	{
		System.out.println("If S2 is a rotation of S1");
		System.out.println("Please enter String 1:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String s1=br.readLine();
			System.out.println("Please enter String 2:");
			String s2=br.readLine();
			if(s1.length()!=s2.length())
			{	
				System.out.println("S2 is not a rotation of S1");
				return;
			}
			s2=s2+s2;
			if(isSubstring(s1,s2))
				System.out.println("S2 is a rotation of S1");
			else
				System.out.println("S2 is not a rotation of S1");
		}
		catch(IOException e)
		{
			System.err.println("Error: "+e);
		}
	}
	static boolean isSubstring(String s1, String s2)
	{
		for(int i=0;i<s2.length()/2;i++)
		{
			if(s1.equals(s2.substring(i,i+s1.length())))
				return true;
		}
		return false;
	}
}