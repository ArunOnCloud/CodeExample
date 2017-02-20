package list;

public class list {
	private ListNode head;
	private ListNode tail;
	public void addData(int n)
	{
		if(head == null)
		{
			head=new ListNode();
			head.setData(n);
			head.setNext(null);
			tail=head;
		}else
		{
			ListNode temp=new ListNode();
			temp.setData(n);
			tail.setNext(temp);
			tail=temp;
			
		}
	}
	public void printList()
	{
		ListNode temp=head;
		while(temp!=null)
		{
			int n=temp.getData();
			System.out.print(n+" ");
			temp=temp.getNext();
		}
	}
	
	

}
