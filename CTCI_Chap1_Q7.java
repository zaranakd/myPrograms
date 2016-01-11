import java.io.*;
class CTCI_Chap1_Q7
{
	public static void main(String args[])
	{
		System.out.println("If any element in matrix is set to 0, set the entire row and column to 0");
		System.out.println("Please enter no of rows in matrix:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int m=Integer.parseInt(br.readLine());
			System.out.println("Please enter no of columns in matrix:");
			int n=Integer.parseInt(br.readLine());
			System.out.println("Enter the matrix");
			int mat[][]=new int[m][n];
			for(int i=0;i<m;i++)
				for(int j=0;j<n;j++)
				{
					mat[i][j]=Integer.parseInt(br.readLine());
				}
			System.out.println();
			System.out.println("Original matrix:");
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(mat[i][j]);
				}
				System.out.println();
			}
			int r[]=new int[m];
			int c[]=new int[n];
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(mat[i][j]==0)
					{
						r[i]=1;
						c[j]=1;
					}
				}
			}
			for(int i=0;i<m;i++)
			{
				if(r[i]==1)
				{
					for(int j=0;j<n;j++)
					{
						mat[i][j]=0;
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				if(c[i]==1)
				{
					for(int j=0;j<m;j++)
					{
						mat[j][i]=0;
					}
				}
			}
			System.out.println();
			System.out.println("Changed matrix:");
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(mat[i][j]);
				}
				System.out.println();
			}
		}
		catch(IOException e)
		{
			System.err.println("Error: "+e);
		}
	}
}