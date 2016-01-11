import java.io.*;
class CTCI_Chap2_Q2
{
	public static void main(String args[])
	{
		System.out.println("Find kth last element in a linked list");
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
			System.out.println("Enter k:");
			int k=Integer.parseInt(br.readLine());
			System.out.println("Current Linked List");
			for(int i=0;i<n;i++)
			{
				System.out.print(" "+temp.data);
				temp=temp.next;
			}
			System.out.println();
			findk(head,k);
		}
		catch(IOException e)
		{
			System.err.println("Error:"+e);
		} 
	}
	static int findk(Node head, int k)
	{
		Node temp=head;
		if(temp.next==null)
			return --k;
		k=findk(temp.next,k);
		if(k==1)
			System.out.println("kth last element is:"+temp.data);
		return --k;
	}
}
class Node
{
	Node next=null;
	int data;
}