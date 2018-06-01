package interviewbit;

import java.util.ArrayList;

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int candy(ArrayList<Integer> A) {
		int n=A.size();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=A.get(i);
		}
		
		int candies[] = new int[n];
        candies[0] = 1;
 
        // First loop for up trends
        for(int i = 1; i<n; i++) {
            if(candies[i] == 0) {
                candies[i]=1;
            }
 
            if(arr[i] > arr[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }
 
        // Second loop for down trends
        for(int i = n-1; i > 0; i--) {
            if(arr[i-1] > arr[i] && candies[i-1] <= candies[i]) {
                candies[i-1] = candies[i]+1;
            }
        }
 
        // Calculating the sum - This step can be avoided by
        // addition and substraction in previous loops, but for
        // simplicity it is seperated out.
        Long sum = 0l;
        for(int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum.intValue();
	}

}
