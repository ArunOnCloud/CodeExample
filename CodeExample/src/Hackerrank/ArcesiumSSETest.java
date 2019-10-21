package Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArcesiumSSETest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		//list.add(1);
		System.out.println(getMinimumSeconds(list, 3, 1, 3));

	}
	
	static int getMinimumSeconds(List<Integer> height, int h, int u, int v) {
        int ans=0;
        Collections.sort(height);
        int ind=Collections.binarySearch(height, h);
        if(ind <0) {
        	ind= -(ind+1);
        }
        int left =0;
        int right =ind;
        System.out.println("ind"+ind);
        ans= (height.size() - ind)*u;
        if(ind>= height.size()) {
        	//ind=height.size()-1;
        	right=height.size()-1;
        	
        }
        
        int ansTemp=0;
        int count=0;
        while(left<right) {
        	if(height.get(left) + height.get(right) > h) {
        		right--;
        		
        	}else if(height.get(left) + height.get(right) < h){
        		ansTemp+=v;
        		right--;
        		left++;
        		count++;
        	}else if (height.get(left) + height.get(right) == h){
        		right --;
        		
        	}
        }
       // ans+= (ind -right)*u;
        ans= count*v + (height.size() -(count*2))*u;
		return ans;
    }

}
