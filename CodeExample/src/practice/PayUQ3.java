package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;


public class PayUQ3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("C:/Users/ArunAdmin/Desktop/payu/q3input.csv"));
		String line=br.readLine();
		if(!(line !=null && line.length()>0)){
			System.out.println("provide input in file");
			br.close();
			return;
		}
			
		String[] sArr=line.trim().split(",");
		int n=sArr.length;
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(sArr[i].trim());
		}
		int minTillNow=Integer.MAX_VALUE;
		if(n<=1){
			System.out.println("No profit");
			br.close();
			return ;
		}
		minTillNow=arr[0];
		int profit=0;
		int sellInd=0;
		int buyInd=0;
		for(int i=1;i<n;i++){
			if(arr[i]> minTillNow){
				int temp=arr[i]-minTillNow;
				if(temp>profit){
					profit=temp;
					sellInd=i;
				}
			}else if(arr[i] <minTillNow){
				minTillNow=arr[i];
				buyInd=i;
			}
		}
		
		System.out.println("buying day:"+(buyInd+1));
		if(profit>0){
			System.out.println("sell day:"+(sellInd+1));
		}else{
			System.out.println("sell day:"+(buyInd+1));
		}
		
		System.out.println("profit:"+profit);
		
		br.close();
		
		
		

	}

}
