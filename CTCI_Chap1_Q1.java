import java.io.*;
class CTCI_Chap1_Q1
{
	public static void main(String args[])
	{
		System.out.println("Check if all strings has all unique characters");
		System.out.println("Please enter the string to be checked:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String chk=br.readLine();
			if(chk.length()>128)
				System.out.println("String does not have all unique characters");
			int chkbit=0;
			char base='a';
			for(int i=0;i<chk.length();i++)
			{
				int temp=(int)(chk.charAt(i)-base);
				if((chkbit | 1<<temp)==chkbit)
				{
					System.out.println("String does not have all unique characters");
					return ;
				}
				else
				{
					chkbit=chkbit | 1<<temp;
				}
			}
			System.out.println("String has all unique characters");
		}
		catch(IOException e)
		{
			System.err.println("Error:"+e);
		}
		
	}
}