package interviewbit;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EditDistance editDistance=new EditDistance();
		System.out.println(editDistance.minDistance("a", "aabc"));
		System.out.println(editDistance.editDistDP("a", "aabc"));
	}



    public int minDistance(String A, String B) {
        
        int n=A.length();
        int m=B.length();
        int[][] arr=new int[n+1][m+1];
        /*for(int i=0;i<n;i++) {
        	if(A.charAt(i) == B.charAt(0)) {
        		arr[i][0]=0;
        	}else {
        		arr[i][0]=i+1;
        	}
        }
        for(int i=0;i<m;i++) {
        	if(A.charAt(0) == B.charAt(i)) {
        		arr[0][i]=0;
        	}else {
        		arr[0][i]=i+1;
        	}
        }*/
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
            	if(i == 0) {
            		arr[i][j]=j;
            		continue;
            	}
            	if(j==0) {
            		arr[i][j]=i;
            		continue;
            	}
                int i1;
                int j1;
                int ans=Integer.MAX_VALUE;
                if(A.charAt(i-1) == B.charAt(j-1)){
                    i1=i-1;
                    j1=j-1;
                    if(i1<0 || j1<0){
                        ans=Integer.MAX_VALUE;
                        //ans=0;
                    }else{
                        ans=arr[i1][j1];
                    }
                }else  if(A.charAt(i-1) != B.charAt(j-1)){
                     i1=i-1;
                    j1=j-1;
                    int left=Integer.MAX_VALUE;
                    int right=Integer.MAX_VALUE;
                    if(i1>=0){
                        left=arr[i1][j];
                    }else{
                      //left=0;
                    }
                    if(j1>=0){
                        right=arr[i][j1];
                    }else{
                        //right=0;
                    }
                    int temp=0;
                    if(i1<0 || j1<0){
                        temp=Integer.MAX_VALUE;
                        //ans=0;
                    }else{
                       temp=arr[i1][j1];
                    }
                    
                    ans=Math.min(Math.min(left,right),temp)+1;
                }
                arr[i][j]=ans;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        
        return arr[n][m];
        
    }
    int min(int a,int b,int c) {
    	return min(min(a,b),c);
    }
    int min(int a,int b) {
    	return a<b? a:b;
    }
    
    int editDistDP(String str1, String str2)
    {
        // Create a table to store results of subproblems
    	int m=str1.length();
    	int n=str2.length();
        int dp[][] = new int[m+1][n+1];
      
        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // isnert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j
      
                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i
      
                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
      
                // If last character are different, consider all
                // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                                       dp[i-1][j],  // Remove
                                       dp[i-1][j-1]); // Replace
            }
        }
  
        return dp[m][n];
    }
}

