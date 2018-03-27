package leetcode;

public class MinimumDeleteSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinimumDeleteSum minimumDeleteSum=new MinimumDeleteSum();
		int val=minimumDeleteSum.minimumDeleteSum("eat", "sea");
		System.out.println(val);

	}
	
	 public int minimumDeleteSum(String s1, String s2) {
	        int m=s1.length();
	        int n=s2.length();
	        int[][] arr=new int[m][n];
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	            	//System.out.println("i:"+i+" j:"+j);
	                if(s1.charAt(i) != s2.charAt(j)){
	                    int i1=i-1;
	                    int j1= j-1;
	                    if(i1 >=0 && j1 >= 0){
	                        arr[i][j]= max(arr[i1][j] + (int)s1.charAt(i) ,arr[i][j1] + (int)s2.charAt(j));
	                    }else if( i1 <0 && j1>=0){
	                        int temp=0;
	                         temp+= (int)s2.charAt(j) ;
	                        for(int k=0;k<j ; k++){
	                            temp+= (int)s2.charAt(k);
	                        }
	                       arr[i][j]= max(temp,arr[i][j1] + (int)s2.charAt(j)); 
	                    }else if(i1 >=0 && j1 < 0){
	                        int temp=0;
	                        temp+= (int)s1.charAt(i) ;
	                        for(int k=0;k<i ; k++){
	                            temp+= (int)s1.charAt(k);
	                        }
	                        arr[i][j]= max(arr[i1][j] + (int)s1.charAt(i), temp); 
	                    }else {
	                    	int temp=0;
	                         temp+= (int)s2.charAt(j) ;
	                        for(int k=0;k<j ; k++){
	                            temp+= (int)s2.charAt(k);
	                        }
	                        
	                        int temp2=0;
	                        temp2+= (int)s1.charAt(i) ;
	                        for(int k=0;k<i ; k++){
	                            temp2+= (int)s1.charAt(k);
	                        }
	                        arr[i][j]= temp +temp2;
	                    }
	                    
	                }else if(s1.charAt(i) == s2.charAt(j)){
	                    int i1=i-1;
	                    int j1= j-1;
	                    if(i1 >=0 && j1 >= 0){
	                        arr[i][j]= max(arr[i1][j] + (int)s1.charAt(i) ,arr[i][j1] + (int)s2.charAt(j));
	                    }else if( i1 <0  && j1 >=0){
	                        int temp=0;
	                         //temp+= (int)s2.charAt(j) ;
	                        for(int k=0;k<j ; k++){
	                            temp+= (int)s2.charAt(k);
	                        }
	                       arr[i][j]= temp; 
	                    }else if(i1>=0 && j1 < 0){
	                        int temp=0;
	                       // temp+= (int)s1.charAt(i) ;
	                        for(int k=0;k<i ; k++){
	                            temp+= (int)s1.charAt(k);
	                        }
	                        arr[i][j]= temp; 
	                    }else {
	                    	int temp=0;
	                        // temp+= (int)s2.charAt(j) ;
	                        for(int k=0;k<j ; k++){
	                            temp+= (int)s2.charAt(k);
	                        }
	                        
	                        int temp2=0;
	                        //temp2+= (int)s1.charAt(i) ;
	                        for(int k=0;k<i ; k++){
	                            temp2+= (int)s1.charAt(k);
	                        }
	                        arr[i][j]= temp +temp2;
	                    }
	                    
	                }
	                
	                
	            }
	            
	        }
	        
	        for(int i=0;i<m;i++) {
	        	for(int j=0;j<n;j++) {
	        		System.out.print(arr[i][j]+ " ");
	        	}
	        	
	        	System.out.println();
	        }
	        
	        return arr[m-1][n-1];
	        
	    }
	    int max(int a,int b ){
	        if(a<b)
	        {
	            return a;
	        }else
	        {
	            return b;
	        }
	    }

}
