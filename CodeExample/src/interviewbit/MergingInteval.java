package interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class MergingInteval {
	
	
	 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		   ArrayList<Interval> res=new ArrayList<>();
		   res.add(newInterval);
		   Interval cur=newInterval;
		   if(intervals.size()>0) {
			   
			   
			   for(int i=0;i<intervals.size();i++) {
				   Interval interval=intervals.get(i);
				   int n=res.size();
				   cur= res.get(n-1);
				   if(cur.end >=interval.start && cur.start <=interval.start ) {
					   if(interval.end > cur.end)
					   cur.end=interval.end;
				   }else if(cur.start  <=interval.end && cur.end >= interval.end) {
					   if(interval.start < cur.start)
					   cur.start=interval.start;
				   }else if(cur.start>=interval.start && cur.end <=interval.end) {
					   cur.start=interval.start;
					   cur.end=interval.end;
				   }else if(cur.end <interval.start) {
					   res.add(interval);
				   }else if(cur.start >interval.end) {
					   res.add(n-1,interval);
				   }
				   
			   }
		   }
		   
		  
		  
		  
		  return res;

	    }
	 
	 

}

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	      }
