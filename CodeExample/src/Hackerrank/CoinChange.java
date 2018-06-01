package Hackerrank;

import java.util.Scanner;

public class CoinChange {

	static long getWays(Long n, long[] c){
        // Complete this function
		//Long n1=n;
		//int col=n1.intValue();
		Long col=n;
		Long row=(long)c.length;
		long[][] arr=new long[c.length][col.intValue()+1];
		for(int i=0;i<row;i++) {
			for(int j=0;j<=col;j++) {
				if(i==0) {
					if(j%c[i] == 0) {
						arr[i][j]=1l;
					}
				}else if(j==0) {
					arr[i][j]=1l;
				}else {
					Long cost=(Long) (j-c[i]);
					Long f=0l;
					if(cost<0) {
						f=0l;
					}else {
						f=arr[i][cost.intValue()];
					}
					arr[i][j]= f+ arr[i-1][j];
				}
			}
		}
		//Long ans= (long)arr[row-1][col];
		return arr[row.intValue()-1][col.intValue()];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        Long n1=new Long(n);
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n1, c);
        System.out.println(ways);
    }

}
