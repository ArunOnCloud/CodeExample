package list;

public class ListNode {
	private int data;
	private ListNode next;
	ListNode()
	{
		data=0;
		next=null;
		
	}
	public void setData(int n)
	{
		data=n;
	}
	public void setNext(ListNode temp)
	{
		next=temp;
	}
	public int getData()
	{
		return data;
	}
	public ListNode getNext()
	{
		return next;
	}

}
