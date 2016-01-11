import java.io.*;
class CTCI_Chap1_Q4
{
	public static void main(String args[])
	{
		System.out.println("Replace space by %20");
		System.out.println("Please enter the string to be operated on:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String chg=br.readLine();
			char[] chgarr=chg.toCharArray();
			int space=chgarr.length;
			for(int i=0;i<chg.length();i++)
			{
				if(chgarr[i]==' ')
					space+=2;
			}
			char newarr[]=new char[space];
			space--;
			for(int i=chgarr.length-1;i>=0;i--)
			{
				if(chgarr[i]==' ')
				{
					newarr[space]='0';
					newarr[space-1]='2';
					newarr[space-2]='%';
					space-=3;
				}
				else
				{
					newarr[space]=chgarr[i];
					space--;
				}
			}
			chg=String.valueOf(newarr);
			System.out.println("The new string is:"+chg);
		}
		catch(IOException e)
		{
			System.err.println("Error:"+e);
		}
		
	}
}