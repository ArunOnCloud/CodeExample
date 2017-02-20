package CodeChef;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//File file=new File(System.out);
		PrintWriter pw=new PrintWriter(System.out,true);
		String line=br.readLine();
		//System.out.print("adf:"+line);
		//br.
		n=Integer.parseInt(line.trim());
		Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
		for(int i=1;i<=n;i++)
		{
			map.put(i, 0);
		}
		int boss=0;
		//for(int i=0;i<n;i++){
			line=br.readLine();
			String[] strArr=line.trim().split(" ");
			for(int j=0;j<strArr.length;j++){
			 Integer key=Integer.parseInt(strArr[j]);
			 if(key==0)
			 boss=j+1;
			 
			 map.put(key, 1);
			}
			
		//}
		for(int i=1;i<=n;i++)
		{
			int k=map.get(i);
			if(k==0 && k!=boss){
				//pw.println(i+" ");
				//pw.print(" asd");
				//pw.print(""+i+" ");
				//System.out.print(i+" ");
				
			}
		}
		

	}

}
