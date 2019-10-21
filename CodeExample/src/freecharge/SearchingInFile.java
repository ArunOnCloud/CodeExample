package freecharge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SearchingInFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String folder="/home/arunkumarram/prod1/application.log-2018-10-09.0";
		String folder="/home/arunkumarram/Desktop/work/prod1.txt";
		BufferedReader br =new BufferedReader(new FileReader(folder));
		Set<String> set=new HashSet<>();
		String line=br.readLine();
		int duplicateCount=0;
		while(line!=null) {
			if(!set.add(line.trim())) {
				duplicateCount++;
			}
			line=br.readLine();
		}		
		folder="/home/arunkumarram/Desktop/work/prod2.txt";
		 br =new BufferedReader(new FileReader(folder));
		 line=br.readLine();
		while(line!=null) {
			
            if(!set.add(line.trim())){
				duplicateCount++;
			}
			line=br.readLine();
		}
		List<String> prodCheckoutIds=new LinkedList<>();
		
		for(String str:set) {
			prodCheckoutIds.add(str);
		}
		System.out.println("count of prod checkout Ids:"+prodCheckoutIds.size());		
		folder="/home/arunkumarram/Desktop/work/dbText.txt";
		List<String> dbCheckoutIds=new LinkedList<>();
		 br =new BufferedReader(new FileReader(folder));
		 line=br.readLine();
		 while(line!=null) {
				
			 dbCheckoutIds.add(line.trim());
				line=br.readLine();
		}
		 
		System.out.println("count of db checkout Ids:"+dbCheckoutIds.size());
		System.out.println("checkout Ids not present on prod:");
		for(String str: dbCheckoutIds) {
			if(!prodCheckoutIds.contains(str)) {
				System.out.println(str);
			}
		}
		System.out.println("checkout Ids not present on db:");
		for(String str: prodCheckoutIds) {
			if(!dbCheckoutIds.contains(str)) {
				System.out.println(str);
			}
		}
		//System.out.println("duplicateCount:"+duplicateCount);
		
		
	}
	public static boolean isPresent(String str,List<String> fileName) throws Exception {
		String folder="";
		BufferedReader br =new BufferedReader(new FileReader(folder));
		String line=br.readLine();
		while(line!=null) {
			if(line.indexOf(str)>=0) {
				return true;
			}
			line=br.readLine();
		}
		return false;
		
		
	}
	public static List<String> getCheckoutIds() throws Exception{
		List<String> res=new ArrayList<>();
		String folder="";
		BufferedReader br =new BufferedReader(new FileReader(folder));
		String line=br.readLine();
		while(line!=null) {
			res.add(line);
			line=br.readLine();
		}
		return res;
		
	}

}
