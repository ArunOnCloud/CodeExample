package tree;
//import LinkedListPractice.Node;

public class LinkedListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 LinkedListPractice.Node node=new LinkedListPractice.new Node(9);
//		   node.next=new LinkedListPractice.Node(9);
		LinkedListPractice lt=new LinkedListPractice();
		Node node=lt.new Node(1);
		
		

	}
	public Node addOne(Node node){
		int flag=addUtil(node);
		
		if(flag ==1)
		{
			Node head=new Node(1);
			head.next=node;
			head.data=1;
			return head;
		}else
		{
			return node;
		}
		
	}
	public int addUtil(Node node)
	{
		int flag=0;
		int test=0;
		if(node.next!=null)
		{
		    flag=addUtil(node.next);
		}else if(node.next ==null)
		{
			test=1;
			int t=node.data;
			t+=1;
			if(t == 10)
			{
				t=0;
				flag=1;
			}
			node.data=t;
		}
		if(test==0)
		{
			if(flag == 1)
			{
				int t=node.data;
				t+=1;
				if(t == 10)
				{
					t=0;
					flag=1;
				}
				node.data=t;
			}
		}
		return flag;
		
	}

	class Node{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
}
