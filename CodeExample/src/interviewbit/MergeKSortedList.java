package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		ListNode res=null;
		PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val -o2.val;
			}
			
		});
		for(ListNode node:a) {
			 while(node!=null) {
				 pq.add(node);
				 node=node.next;
			 }
		}
		return null;
	}

}
class ListNode {
	     public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
	 