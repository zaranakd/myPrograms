import java.io.*;
class CTCI_Chap1_Q6
{
	public static void main(String args[])
	{
		System.out.println("Rotating image by 90 degrees");
		System.out.println("Please enter image matrix size:");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n=Integer.parseInt(br.readLine());
			System.out.println("Enter the matrix");
			int mat[][]=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					mat[i][j]=Integer.parseInt(br.readLine());
				}
			System.out.println();
			System.out.println("Original matrix:");
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(mat[i][j]);
				}
				System.out.println();
			}
			for(int i=0;i<n/2;i++)
			{
				int temp;
				for(int x=i;x<n-i-1;x++)
				{
					temp=mat[i][x];
					mat[i][x]=mat[x][n-i-1];
					mat[x][n-i-1]=mat[n-i-1][n-1-x];
					mat[n-i-1][n-1-x]=mat[n-1-x][i];
					mat[n-1-x][i]=temp;
				}
			}
			System.out.println();
			System.out.println("Rotated matrix:");
			for(int i=0;i<n;i++)
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
			System.err.println("Error:"+e);
		}
		
	}
}