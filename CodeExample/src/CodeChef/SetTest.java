package CodeChef;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class SetTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Set<Integer> set=new TreeSet<Integer>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out,true);
		String line=br.readLine();
		int t=Integer.parseInt(line);
		while(t>0)
		{
			int n,m;
			line=br.readLine();
			String[] strArr=line.trim().split(" ");
			n=Integer.parseInt(strArr[0]);
			m=Integer.parseInt(strArr[1]);
			Integer[][] arr=new Integer[n][m];
			for(int i=0;i<n;i++)
			{
				
					line=br.readLine();
					strArr=line.trim().split(" ");
					for(int j=0;j<m;j++)
					{
						//System.out.println("====="+strArr[j]+" ");
						arr[i][j]=Integer.parseInt(strArr[j]);
					}
					
					
			}
			//Map<Integer,Integer> []rowMap=(TreeMap<Integer,Integer>[]) Array.newInstance(TreeMap<Integer,Integer>, n);
			//ArrayList<Map<Integer,Integer> > rowMap=new ArrayList<Map<Integer,Integer> >();
			ArrayList<Map<Integer,Integer> > rowMap=new ArrayList<Map<Integer,Integer> >();
			
			rowMap.ensureCapacity(n);
			ArrayList<Map<Integer,Integer> > colMap=new ArrayList<Map<Integer,Integer> >();
			colMap.ensureCapacity(m);
			//Map<Integer,Integer> []rowMap=new TreeMap<?,?>[n];
			for(int i=0;i<n;i++)
			{
				// rowMap[i]=new TreeMap<Integer,Integer>();
				//Map<Integer,Integer> mapUtil=new TreeMap<Integer,Integer>();
				Map<Integer,Integer> mapUtil=new HashMap<Integer,Integer>();
				
				for(int j=0;j<m;j++){
					int temp=arr[i][j];
					
					if(mapUtil.containsKey(temp))
					{
						int count=mapUtil.get(temp);
						mapUtil.put(temp,count+1);
					}else
					{
						mapUtil.put(temp, 1);
					}
					
				}
				rowMap.add(mapUtil);
			}
			
			for(int i=0;i<m;i++)
			{
				// rowMap[i]=new TreeMap<Integer,Integer>();
				//Map<Integer,Integer> mapUtil=new TreeMap<Integer,Integer>();
				Map<Integer,Integer> mapUtil=new HashMap<Integer,Integer>();
				for(int j=0;j<n;j++){
					int temp=arr[j][i];
					
					if(mapUtil.containsKey(temp))
					{
						int count=mapUtil.get(temp);
						mapUtil.put(temp,count+1);
					}else
					{
						mapUtil.put(temp, 1);
					}
					
				}
				colMap.add(mapUtil);
			}
			int result=0;
			for(int i=0;i<n;i++ ){
				for(int j=0;j<m;j++){
					int curTemp=arr[i][j];
					//rowMap.get(temp)
					//Map<Integer,Integer> mapUtil=new TreeMap<Integer,Integer>();
					Map<Integer,Integer> mapUtil=new HashMap<Integer,Integer>();
					Iterator<Map.Entry<Integer, Integer>> itr=rowMap.get(i).entrySet().iterator();
					while(itr.hasNext()){
						Map.Entry<Integer,Integer> entry=itr.next();
						{
							int key=entry.getKey();
							mapUtil.put(key, entry.getValue());
						   /*if(mapUtil.containsKey(key)){
							   int val=mapUtil.get(key);
							   mapUtil.put(key, val+1);
						   }else
						   {
							   mapUtil.put(key, 1);
						   }*/
						}
					}
					//System.out.println("before colmap mapUtil:"+mapUtil);
					 itr=colMap.get(j).entrySet().iterator();
					 while(itr.hasNext()){
							Map.Entry<Integer,Integer> entry=itr.next();
							{
								int key=entry.getKey();
								
							   if(mapUtil.containsKey(key)){
								   int val=mapUtil.get(key);
								   mapUtil.put(key, val+entry.getValue());
							   }else
							   {
								   mapUtil.put(key,entry.getValue());
							   }
							}
						}
					// System.out.println("after colmap mapUtil:"+mapUtil);
					 if(mapUtil.containsKey(curTemp)){
						int curVal=mapUtil.get(curTemp);
						mapUtil.put(curTemp, curVal-1);
						}
					 itr=mapUtil.entrySet().iterator();
					 int count=0;
					 if(i==2 && j==2)
					   {
						   //System.out.println("countlinndf===");
					   }
					 while(itr.hasNext()){
						 Map.Entry<Integer,Integer> entry=itr.next();
							{
								int val=entry.getValue();
								count++;
								//System.out.println("key:"+entry.getKey()+"   value:"+val);
								if(val>result)
								{
									result=val;
								}
							   
							   
							}
						 
					 }
					 if(i==2 && j==2)
					   {
						   //System.out.println("countlinndf===========end");
					   }
					 //System.out.println(" count:"+count);
					/* System.out.println("result:"+result);
					 System.out.println("curTemp:"+curTemp);
					 System.out.println("rowmap:"+rowMap.get(i));
					 System.out.println("colmap:"+colMap.get(j));*/
					
				}
			}
			rowMap.clear();
			colMap.clear();
			//System.out.println(result);
			pw.println(result);
			//System.out.println("result:"+result);
			
			t--;
		}
		
		

	}

}
