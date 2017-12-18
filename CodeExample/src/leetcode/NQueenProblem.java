package leetcode;
import java.util.LinkedList;
import java.util.List;

public class NQueenProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueenProblem nQueenProblem=new NQueenProblem();
		List<List<String>> res=nQueenProblem.solveNQueens(8);
		System.out.println(res.size());
		char[][] ch={{'.','.','.','Q'},
				     {'Q','.','.','Q'},
				     {'.','.','Q','.'},
				     {'.','Q','.','.'}
				};
		//System.out.println(nQueenProblem.isSafe(ch, 3, 1));
		//System.out.println(nQueenProblem.validate(ch));
		//if(nQueenProblem.isSafe(ch, 1, 3))
			
	}
	
	//public void isSafe()
	 public List<List<String>> solveNQueens(int n) {
	       // List<List<String>> result=new LinkedList<List<String>>();
	        char[][] ch=new char[n][n];
	        for(int i=0;i<n;i++)
	        {
	        	for(int j=0;j<n;j++)
	        	{
	        		ch[i][j]='.';
	        	}
	        }
	        for(int k=0;k<n;k++)
	        {
	        	ch[0][k]='Q';
	        	boolean temp=false;
	        	solve(ch,1);
	        	if(temp == true)
			     {
	        		List<String> list=new LinkedList<String>();
	        		
			    	 for(int i=0;i<n;i++)
			        {
			    		 char[] arr=new char[n];
			    		 
			        	for(int j=0;j<n;j++)
			        	{
			        		System.out.print(ch[i][j]+" ");
			        		arr[j]=ch[i][j];
			        	}
			        	String str=new String(arr);
			        	list.add(str);
			        	System.out.println();
			        }
			    	 //result.add(list);
			    	 
			    	 
			    	 System.out.println();
		        }
			    ch[0][k]='.';
			    for(int i=0;i<n;i++)
		    	 {
		    		 for(int j=0;j<n;j++)
		    		 {
		    			 ch[i][j]='.';
		    		 }
		    	 }
	        }
	        
	        return result;
	    }
	 List<List<String>> result=new LinkedList<List<String>>();
	 public void solve(char[][] ch,int ind){
		 int n=ch.length;
		 if(ind>=n)
		 {
			 if(validate(ch))
			 {
				 List<String> list=new LinkedList<String>();
	        		
		    	 for(int i=0;i<n;i++)
		        {
		    		 char[] arr=new char[n];
		    		 
		        	for(int j=0;j<n;j++)
		        	{
		        		//System.out.print(ch[i][j]+" ");
		        		arr[j]=ch[i][j];
		        	}
		        	String str=new String(arr);
		        	list.add(str);
		        	//System.out.println();
		        }
		    	 result.add(list);
		    	 
			 }
			 //return validate(ch);
		 }else
		 {
			// int r=ind/n;
			// int c=ind%n;
			for(int i=0;i<n;i++)
			{
				if(ch[ind][i]=='.')
				{
					ch[ind][i]='Q';
					if(isSafe(ch,ind,i))
					{
						/*if(solve(ch,ind+1))
						{
							//return true;
						}else
						{
							ch[ind][i]='.';
							//return false;
						}*/
						solve(ch,ind+1);
						ch[ind][i]='.';
					}else
					{
						ch[ind][i]='.';
					}
				}
			}
			//return false;
			
		 }
		 
	 }
	 public boolean isSafe(char[][] ch,int r,int c){
		 boolean res=true;
		 //
		 int n=ch.length;
		 int count=0;
		 for(int i=0;i<n;i++)
		 {
			 if(ch[r][i]=='Q')
			 {
				 count++;
			 }
		 }
		 if(count>1)
		 {
			 return false;
		 }
		 count=0;
		 for(int i=0;i<n;i++)
		 {
			 if(ch[i][c]=='Q')
			 {
				 count++;
			 }
		 }
		 if(count>1)
		 {
			 return false;
		 }
		 return checkDiagonal(ch, r, c);
		 /*count=0;
		 int i=(r-c >=0)?(r-c) : 0;
		 int j=(c-r >=0)?(c-r) : 0;
		 while(true)
		 {
			 if(i>=n || j>=n)
			 {
				 break;
			 }
			 
			 if(ch[i][j] == 'Q')
			 {
				 count++;
			 }
			 i++;
			 j++;
			 
		 }
		 if(count>1)
		 {
			 return false;
		 }
		 count=0;
		  i=(r+c >=n)?(n-1) : r+c;
		 // j=(i-r >=0)?(j-i+r) : 0;
		  j=j-i+r-1;
		 while(true)
		 {
			 if(i<0 || j>=n)
			 {
				 break;
			 }
			 
			 if(ch[i][j] == 'Q')
			 {
				 count++;
			 }
			 i--;
			 j++;
			 
		 }
		 if(count>1)
		 {
			 return false;
		 }
		 
		 
		 return res;
		 */
		 
	 }
	 public boolean checkDiagonal(char[][] ch,int r,int c)
	 {
		 boolean result=true;
		 int n=ch.length;
		 int i=r;
		 int j=c;
		 while(true)
		 {
			 if(i==0 || j==0)
			 {
				 break;
			 }
			 i--;
			 j--;
		 }
		 int count=0;
		 while(true)
		 {
			 if(i==n || j==n)
			 {
				 break;
			 }
			 if(ch[i][j]== 'Q')
			 {
				 count++;
			 }
			 i++;
			 j++;
		 }
		 if(count>1)
		 {
			 return false;
		 }
		 i=r;
		 j=c;
		 count=0;
		 while(true)
		 {
			 if(i==n-1 || j==0)
			 {
				 break;
			 }
			 i++;
			 j--;
		 }
		 while(true)
		 {
			 if(i<0 || j==n)
			 {
				 break;
			 }
			 if(ch[i][j]== 'Q')
			 {
				 count++;
			 }
			 i--;
			 j++;
		 }
		 if(count>1)
		 {
			 return false;
		 }
		 return true;
		 
	 }

	 public boolean validate(char[][] ch)
	 {
		 int n=ch.length;
		 int count=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n;j++)
			 {
				 if(!isSafe(ch, i, j))
				 {
					return false; 
				 }
				 if(ch[i][j]=='Q')
					 count++;
			 }
		 }
		 if(count == n)
		 {
			 return true;
		 }else
		 {
			 return false;
		 }
		 
	 }
}
