package CollectionExamples;
import java.util.*;


class Pair implements Comparator<Pair>,Comparable<Pair>{
	public Integer first;
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer second;
	
	 public int compare(Pair l, Pair r){
		 return l.first-l.second;
	 }
	 public boolean equals(Pair obj){
		  if(this.second==obj.second)
			  return true;
		  else
			  return false;
	 }
	 public int compareTo(Pair p){
		 return this.second-p.second;
	 }
}


public class PriorityQueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
		Pair p=new Pair();
		p.first=12;
		p.second=15;
		pq.add(p);
		
		p.first=13;
		p.second=18;
		pq.add(p);
	     
		System.out.println(" first:"+pq.element().first);
		//pq.poll();
		pq.remove();
		System.out.println(" first:"+pq.element().first);
		pq.remove();
		
		System.out.println(" first:"+pq.element().first);
		
		
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		

	}

}
