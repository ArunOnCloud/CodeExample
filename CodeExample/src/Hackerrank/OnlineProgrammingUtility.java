package Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnlineProgrammingUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   String line=br.readLine();
	   int t=Integer.parseInt(line);

	}
	
	
	public static int[] convertLineToArray(String str)
	{
		
		String[] strArr=str.trim().split(" ");
		int[] arr=new int[strArr.length];
		for(int i=0;i<strArr.length;i++)
		{
			arr[i]=Integer.parseInt(strArr[i].trim());
		}
		return arr;
	}

}
