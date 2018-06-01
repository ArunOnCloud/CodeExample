package geeksforgeeks;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque;

public class KLargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int t,n,k;
		t=sc.nextInt();
		for(int i1=0;i1<t;i1++)
		{
			n=sc.nextInt();
			k=sc.nextInt();
			int[] arr=new int[n];
			PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1-o2;
				}
				
			});
			for(int i=0;i<n;i++)
			{
				int temp=sc.nextInt();
				queue.add(temp);
				if(queue.size()>k)
				{
					queue.poll();
				}
				
			}
			List<Integer> list=new LinkedList<Integer>();
			for(int i=0;i<k;i++)
			{
				list.add(queue.poll());
			}
			for(int i=k-1;i>=0;i--)
			{
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			
		}

	}
	

}
