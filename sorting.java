import java.io.*;
class sorting
{
	public static void main(String args[])
	{
		int no,sort;
		try
		{
			System.out.print("Total numbers to be sorted:");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			no=Integer.parseInt(br.readLine());
			System.out.println("Enter numbers:");
			int a[]= new int[no];
			for(int i=0;i<no;i++)
			{
				br=new BufferedReader(new InputStreamReader(System.in));
				a[i]=Integer.parseInt(br.readLine());
			}

			System.out.println();
			System.out.println("Enter Sorting Algo:");
			System.out.println("1. Bubble Sort");
			System.out.println("2. Insertion Sort");
			System.out.println("3. Selection Sort");
			System.out.println("4. Merge Sort");
			System.out.println("5. Quick Sort");
			System.out.println("6. Heap Sort");
			System.out.println();
			br=new BufferedReader(new InputStreamReader(System.in));
			sort=Integer.parseInt(br.readLine());
			switch(sort)
			{
				case 1:
					System.out.println("1. Bubble Sort");
					a=bubblesort(a);
					break;
				case 2:
					System.out.println("2. Insertion Sort");
					a=insertionsort(a);
					break;
				case 3:
					System.out.println("3. Selection Sort");
					a=selectionsort(a);
					break;
				case 4:
					System.out.println("4. Merge Sort");
					a=mergesort(a,0,a.length-1);
					break;
				case 5:
					System.out.println("5. Quick Sort");
					a=quicksort(a,0,a.length-1);
					break;
				case 6:
					System.out.println("6. Heap Sort");
					a=heapsort(a);
					break;
			}
			System.out.println();
			System.out.println("Sorted list");
			for(int i=0;i<no;i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}	
		catch(IOException e)
		{
			System.err.println("Error:" + e);
		}
	}
	static int[] bubblesort(int a[])
	{
		for(int i=1;i<a.length;i++)		
			for(int j=0;j<a.length-i;j++)
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
		return a;
	}
	static int[] insertionsort(int a[])
	{
		for(int i=0;i<a.length;i++)
			for(int j=i;j>0;j--)
				if(a[j]<a[j-1])
				{
					int temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}	
		return a;
	}
	static int[] selectionsort(int a[])
	{
		int small=0;
		for(int i=0;i<a.length;i++)
		{
			small=i;
			for(int j=i+1;j<a.length;j++)
				if(a[small]>a[j])
					small=j;
			int temp=a[small];
			a[small]=a[i];
			a[i]=temp;
		}
		return a;
	}
	static int[] mergesort(int a[],int low, int high)
	{
		int a1[]=new int[a.length];
		int a2[]=new int[a.length];
		if(high-low==0)
			return a;
		else if(high-low==1)
			if(a[high]<a[low])
			{
				int temp=a[high];
				a[high]=a[low];
				a[low]=temp;
				return a;
			}
			else
				return a;
		int mid=(low+high)/2;
		int i=low,j=mid+1,k=low;
		for(int m=0;m<a.length;m++)
		{
			a1[m]=a[m];
			a2[m]=a[m];
		}
		a1=mergesort(a1,low,mid);
		a2=mergesort(a2,mid+1,high);
		while(i<=mid && j<=high && k<=high)
		{
			if(a1[i]<=a2[j])
			{
				a[k]=a1[i];
				k++;
				i++;
			}
			else
			{
				a[k]=a2[j];
				k++;
				j++;
			}
		}
		while(i<=mid && k<=high)
		{
			a[k]=a1[i];
			k++;
			i++;
		}
		while(j<=high && k<=high)
		{
			a[k]=a2[j];
			k++;
			j++;
		}
		return a;
	}
	static int[] quicksort(int a[],int low,int high)
	{
		if(low==high)
			return a;
		int pivot=high;
		int i=low,j=high-1;
		while(i<j)
		{
			if(a[i]>a[pivot] && a[j]<=a[pivot])
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
			else
			{
				if(a[i]<=a[pivot])
					i++;
				if(a[j]>a[pivot])
					j--;
			}
		}
		for(int m=low;m<high;m++)
		{
			if(a[m]>a[pivot])
			{
				int temp=a[pivot];
				a[pivot]=a[m];
				a[m]=temp;
				pivot=m;
				break;
			}
		}
		if(pivot!=low)
			a=quicksort(a,low,pivot-1);
		if(pivot!=high)
			a=quicksort(a,pivot+1,high);
		return a;
	}
	static int[] heapsort(int a[])
	{
		int h[]=new int[a.length];
		int k=0,i=0,j=0;
		h[k]=a[k];
		k++;
		while(k<a.length)
		{
			h[k]=a[k];
			i=(k-1)/2;
			j=k;
			while(h[j]<h[i] && i>=0 &&i<a.length)
			{
				int temp=h[j];
				h[j]=h[i];
				h[i]=temp;
				j=i;
				i=(i-1)/2;
			}
			k++;
		}
		for(int x=0;x<a.length;x++)
			System.out.print(" "+h[x]);
		k=0;
		i=0;
		int last=a.length-1;
		while(k<a.length && last>=0)
		{
			a[k]=h[0];
			i=0;
			h[0]=h[last];
			j=(i+1)*2-1;
			while(j+1<last && (h[i]>h[j] || h[i]>h[j+1]))
			{
				if(h[j]>=h[j+1])
				{
					int temp=h[j+1];
					h[j+1]=h[i];
					h[i]=temp;
					i=j+1;
				}
				else
				{
					int temp=h[j];
					h[j]=h[i];
					h[i]=temp;
					i=j;
				}
				j=(i+1)*2-1;
			}
			last--;
			k++;
		}

		return a;
	}
}