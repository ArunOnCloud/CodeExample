package list;

public class Node {

	public int data;
	public Node next;
	Node(int d)
	{
		this.data=d;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Node a=new Node(1);
		a.next=new Node(2);
	   // a.next.next=new Node(3);
	   // a.next.next.next=new Node(4);
	    //a.next.next.next.next=a.next;
	    System.out.println(Node.detectCyle(a));
	    
		

	}
	
	
	public static boolean detectCyle(Node head)
	{
		boolean result=false;
		
		Node fast;
		Node slow;
		if(head== null)
		{
			return false;
		}else if(head.next == null)
		{
			return false;
		}
		fast=head.next;
		slow=head;
		while(true)
		{
			if(fast== null  || slow == null)
			{
				result=false;
						break;
			}
			
			if(fast == slow)
			{
				result=true;
				break;
			}
			fast=fast.next;
			if(fast == null)
			{
				result =false;
				break;
			}
			fast=fast.next;
			if(fast == null)
			{
				result =false;
				break;
			}
			slow=slow.next;
		}
		
		
		
		
		return result;
		
		
	}
	

	/*public static int removeCycleInList(Node head)
	{
		int result=0;
		
	}*/
	
	

}
