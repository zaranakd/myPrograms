import java.io.*;
class CTCI_Chap2_Q4
{
	public static void main(String args[])
	{
		System.out.println("Partition based on a number x");
		System.out.println("Enter no of elements in a linked list");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n=Integer.parseInt(br.readLine());
			Node head=new Node();
			Node temp=head;
			System.out.println("Enter elements");
			for(int i=0;i<n;i++)
			{
				temp.next=new Node();
				temp.next.data=Integer.parseInt(br.readLine());
				temp=temp.next;
			}
			temp=head.next;
			System.out.println("Enter x:");
			int x=Integer.parseInt(br.readLine());
			System.out.println("Current Linked List");
			for(int i=0;i<n-1;i++)
			{
				System.out.print(temp.data+" -> ");
				temp=temp.next;
			}
			System.out.println(temp.data);
			System.out.println();
			temp=head.next;
			Node before=null,after=null;
			Node beforerun=new Node();
			Node afterrun=new Node();
			int a=0,b=0;
			while(temp!=null)
			{
				if(temp.data<=x)
				{
					if(b==0)
					{
						before=temp;
						b=1;
					}
					beforerun.next=temp;
					temp=temp.next;
					beforerun=beforerun.next;
				}
				else if(temp.data>x)
				{
					if(a==0)
					{
						after=temp;
						a=1;
					}
					afterrun.next=temp;
					temp=temp.next;
					afterrun=afterrun.next;
				}
			}
			if(before!=null)
				head.next=before;
			else
				head.next=after;
			if(beforerun!=null)
				beforerun.next=after;
			if(afterrun!=null)
				afterrun.next=null;
			temp=head.next;
			System.out.println("Linked List after partition");
			if(temp!=null)
			{
				System.out.print(temp.data);
			}
			temp=temp.next;
			while(temp!=null)
			{
				System.out.print(" -> "+temp.data);
				temp=temp.next;
			}
			System.out.println();
		}
		catch(IOException e)
		{
			System.err.println("Error:"+e);
		} 
	}
}
class Node
{
	Node next=null;
	int data;
}