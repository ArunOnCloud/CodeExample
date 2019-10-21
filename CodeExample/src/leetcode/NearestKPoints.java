package leetcode;

import java.util.PriorityQueue;

public class NearestKPoints {
	public void fun() {
		PriorityQueue<Point> pq=new PriorityQueue<>((p,q)->{return (int)(p.d-q.d);});
		//pq.poll()
		
		Double d=new Double(12.0);
		d.compareTo(10.0);
		
		
	}
	
     Double distance(int x1,int y1,int x2,int y2) {
	   Double ans= Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	   return ans;
	}

}
class Point{
    Double d;
    int x;
    int y;
    Point(Double d,int x,int y){
        this.d=d;
        this.x=x;
        this.y=y;
    }
}
