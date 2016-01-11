import java.io.*;
class CTCI_Chap1_Q5
{
	public static void main(String args[])
	{
		System.out.println("String compression");
		System.out.println("Please enter the string to be compressed:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str=br.readLine();
			int i=1;
			int j=1;
			int count=1;
			while(i<str.length())
			{
				if(str.charAt(i)==str.charAt(i-1))
					count++;
				else
				{
					char[] cnt=String.valueOf(count).toCharArray();
					for(int x=0;x<cnt.length;x++)
					{
						j++;
					}
					count=1;
					j++;
				}
				i++;
			}
			j++;
			if(j>str.length())
			{
				System.out.println("The compressed string is:"+str);
				return;	
			}
			i=1;
			j=1;
			count=1;
			char[] comp=new char[str.length()];
			comp[0]=str.charAt(0);
			while(i<str.length())	
			{
				if(comp[j-1]==str.charAt(i))
					count++;
				else
				{
					char[] cnt=String.valueOf(count).toCharArray();
					for(int x=0;x<cnt.length;x++)
					{
						comp[j]=cnt[x];
						j++;
					}
					count=1;
					comp[j]=str.charAt(i);
					j++;
				}
				i++;
			}
			char[] cnt=String.valueOf(count).toCharArray();
			for(int x=0;x<cnt.length;x++)
			{
				comp[j]=cnt[x];
				j++;
			}
			str=String.valueOf(comp);
			System.out.println("The compressed string is:"+str);
		}
		catch(IOException e)
		{
			System.err.println("Error:"+e);
		}
		
	}
}