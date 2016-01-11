import java.io.*;
class CTCI_Chap2_Q5
{
	public static void main(String args[])
	{
		System.out.println("Add elements of 2 linked list");
		System.out.println("Enter no of elements in a linked list 1");
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			int n1=Integer.parseInt(br.readLine());
			Node head1=new Node();
			Node temp1=head1;
			System.out.println("Enter elements");
			for(int i=0;i<n1;i++)
			{
				temp1.next=new Node();
				temp1.next.data=Integer.parseInt(br.readLine());
				temp1=temp1.next;
			}
			temp1=head1.next;
			System.out.println("Enter no of elements in a linked list 2");
			int n2=Integer.parseInt(br.readLine());
			Node head2=new Node();
			Node temp2=head2;
			System.out.println("Enter elements");
			for(int i=0;i<n2;i++)
			{
				temp2.next=new Node();
				temp2.next.data=Integer.parseInt(br.readLine());
				temp2=temp2.next;
			}
			temp2=head2.next;
			System.out.println("Current Linked List 1:");
			if(temp1!=null)
			{
				System.out.print(temp1.data);
			}
			temp1=temp1.next;
			while(temp1!=null)
			{
				System.out.print(" -> "+temp1.data);
				temp1=temp1.next;
			}
			System.out.println();
			temp2=head2.next;
			System.out.println("Current Linked List 2:");
			if(temp2!=null)
			{
				System.out.print(temp2.data);
			}
			temp2=temp2.next;
			while(temp2!=null)
			{
				System.out.print(" -> "+temp2.data);
				temp2=temp2.next;
			}
			System.out.println();
			Node sum=new Node();
			Node sumh=sum;
			int carry=0;
			temp1=head1.next;
			temp2=head2.next;
			while(temp1!=null && temp2!=null)
			{
				sum.next=new Node();
				sum=sum.next;
				int s=temp1.data+temp2.data+carry;
				carry=0;
				if(s<10)
					sum.data=s;
				else
				{
					sum.data=s%10;
					carry=1;
				}
				temp1=temp1.next;
				temp2=temp2.next;
			}
			while(temp1!=null)
			{
				sum.next=new Node();
				sum=sum.next;
				int s=temp1.data+carry;
				carry=0;
				if(s<10)
					sum.data=s;
				else
				{
					sum.data=s%10;
					carry=1;
				}
				temp1=temp1.next;
			}
			while(temp2!=null)
			{
				sum.next=new Node();
				sum=sum.next;
				int s=temp2.data+carry;
				carry=0;
				if(s<10)
					sum.data=s;
				else
				{
					sum.data=s%10;
					carry=1;
				}
				temp2=temp2.next;
			}
			temp1=sumh.next;
			System.out.println("Sum Linked List:");
			if(temp1!=null)
			{
				System.out.print(temp1.data);
				temp1=temp1.next;
			}
			while(temp1!=null)
			{
				System.out.print(" -> "+temp1.data);
				temp1=temp1.next;
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