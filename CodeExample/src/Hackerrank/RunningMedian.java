package Hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void fun(int[] arr) {
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		int len=arr.length;
		if(len == 1) {
			System.out.println(arr[0]);
			return ;
		}else if(len == 2){
			System.out.println(arr[0]);
			
			System.out.println(arr[1]);
			minHeap.add(arr[0]);
			maxHeap.add(arr[1]);
			return;
		}
		for(int i=0;i<arr.length;i++) {
			int min=0;
			int max=0;
			
			if(!minHeap.isEmpty()) {
				min=minHeap.peek();
			}
			if(!maxHeap.isEmpty()) {
				max=maxHeap.peek();
			}
			if(i%2 == 0) {
				
			}
			
		}
		
	}

}
