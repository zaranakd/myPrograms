import java.io.*;
class CTCI_Chap2_Q1
{
	public static void main(String args[])
	{
		System.out.println("Remove duplicates from unsorted linked list");
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
			System.out.println("Current Linked List");
			for(int i=0;i<n;i++)
			{
				System.out.print(" "+temp.data);
				temp=temp.next;
			}
			System.out.println();
			temp=head.next;
			while(temp!=null && temp.next!=null)
			{
				Node prevrunner=temp;
				Node runner=temp.next;
				while(runner!=null)
				{
					if(temp.data==runner.data)
					{
						prevrunner.next=runner.next;
						runner=runner.next;
					}
					else
					{
						prevrunner=runner;
						runner=runner.next;
					}
				}
				temp=temp.next;
			}
			System.out.println("Linked List with no duplicates");
			temp=head.next;
			while(temp!=null)
			{
				System.out.print(" "+temp.data);
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