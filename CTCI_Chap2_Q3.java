import java.io.*;
class CTCI_Chap2_Q3
{
	public static void main(String args[])
	{
		System.out.println("Delete a node from singly linked list");
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
			System.out.println("Enter node data to be deleted:");
			int ddata=Integer.parseInt(br.readLine());
			System.out.println("Current Linked List");
			for(int i=0;i<n-1;i++)
			{
				System.out.print(temp.data+" -> ");
				temp=temp.next;
			}
			System.out.println(temp.data);
			System.out.println();
			temp=head.next;
			while(temp!=null)
			{
				if(temp.data == ddata)
				{
					temp.data=temp.next.data;
					temp.next=temp.next.next;
				}
				temp=temp.next;
			}	
			temp=head.next;
			System.out.println("Linked List after deletion");
			while(temp.next!=null)
			{
				System.out.print(temp.data+" -> ");
				temp=temp.next;
			}
			System.out.println(temp.data);
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