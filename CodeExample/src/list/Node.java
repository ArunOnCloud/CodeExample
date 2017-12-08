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

		testReverseInChunk();

		Node a=new Node(1);
		a.next=new Node(2);
	    a.next.next=new Node(3);
	   // a.next.next.next=new Node(4);
	    //a.next.next.next.next=a.next;
	    System.out.println(Node.detectCyle(a));
	    Node head=reverse(a);
	    while(head!=null)
	    {
	    	System.out.print(head.data+" -> ");
	    	head=head.next;
	    	
	    	
	    }

	    
		

	}
	
	public static void addOneToLinKlist(Node node)
	{
		if(node != null)
		{
			
		}else
		{
			
		}
		
	}
	
	public static void testLinkListOneAddition()
	{
		
	}
	
	
	
	
	public static void printList(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.data+" -> ");
			head=head.next;
		}
		System.out.println();
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
	
	public static  Node reverse(Node head)
   {
        // add code here
		if(head==null)
			return head;
        return reverseUtil(null,head);
   }
	public static Node reverseUtil(Node prev,Node head)
	{
		if(head!=null)
		{
			Node res=reverseUtil(head,head.next);
			head.next=prev;
			return res;
		}else
		{
			return prev;
		}
	}

	/*public static int removeCycleInList(Node head)
	{
		int result=0;
		
	}*/
	
	public static void testReverseInChunk()
	{
		Node a=new Node(1);
		a.next=new Node(2);
	    a.next.next=new Node(3);
	    a.next.next.next=new Node(4);
	    //a.next.next.next.next=a.next;
	    //System.out.println(Node.detectCyle(a));
	    
	    printList(a);
	    Node head=reverse(a, 2);
	    printList(head);
	}
	public static  Node reverse(Node head, int k)
	    {
	       Node current = head;
	       Node next = null;
	       Node prev = null;
	        
	       int count = 0;
	 
	       /* Reverse first k nodes of linked list */
	       while (count < k && current != null) 
	       {
	           next = current.next;
	           current.next = prev;
	           prev = current;
	           current = next;
	           count++;
	       }
	 
	       /* next is now a pointer to (k+1)th node 
	          Recursively call for the list starting from current.
	          And make rest of the list as next of first node */
	       if (next != null) 
	          head.next = reverse(next, k);
	 
	       // prev is now head of input list
	       return prev;
	    }                      
	 
	
	/*public static Node reverseLinkList(Node node,int k)
	{
		if(node==null)
		{
			return null;
		}else if(node.next == null)
		{
			return node;
		}
		int count=1;
		Node head=node;
		Node prev=null;
		Node last=null;
		Node temp=head;
		Node result=null;
		while(temp.next!=null)
		{
			
			while(temp!=null && count%k==0)
			{
				temp=temp.next;
				count++;
			}
			count++;
			last=temp;
			Node res=reverseUtil(prev,head,temp);
			head.next=last;			
			prev=head;
			head=last;
			
			result=res;
		}
		return result;
			
	}
	public static Node reverseUtil(Node prev,Node node,Node last)
	{
		if(node.next!=last)
		{
			Node res=reverseUtil(node, node.next, last);
			node.next=prev;
			return res;
		}else
		{
			return node;
		}
	}*/
	

}
