package interviewbit;
import java.util.*;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        util(A,0,new ArrayList<Integer>());
        Collections.sort(result, new Comparator<ArrayList<Integer> >() {

			@Override
			public int compare(ArrayList<Integer> arg0, ArrayList<Integer> arg1) {
				 for(int i=0;i<arg0.size() ;i++)
				 {
					 if(i == arg1.size() )
					 {
						 return 0;
					 }else {
						 if(arg0.get(i) == arg1.get(i)) {
							 continue;
						 }else
						 {
							return arg0.get(i) - arg1.get(i);
						 }
					 }
				 }
				return 0;
			}
        	
		});
        return result;
        
    }
    
	
	 public void util(ArrayList<Integer> a,int i,ArrayList<Integer> s){
	        if(i==a.size()){
	            return;
	        }
	        else{
	            if(s.size() >0)
	            {
	               result.add(copyList(s)) ;
	            }
	            util(a,i+1,copyList(s));
	            int val=a.get(i);
	            s.add(val);
	           // copyList(s);
	            util(a,i+1, copyList(s));
	            
	        }
	        
	        
	    }
	    public ArrayList<Integer>  copyList(ArrayList<Integer> s){
	    ArrayList<Integer> res=new ArrayList<Integer>();
	    for(int i=0;i<s.size();i++){
	        int val=s.get(i);
	        res.add(val);
	        
	     }
	     return res;
	    }

}
