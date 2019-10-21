package hackerearth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CallHealthGiftVouchers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int n,m,k;
		n=s.nextInt();
		m=s.nextInt();
		k=s.nextInt();
		//List<List<Integer>> listOf=new ArrayList<>();
		Map<Integer,List<Integer>> map=new TreeMap<>();
		//List<Integer>[] lists=new List<Integer>[n];
		int t=m;
		while(t>0) {
			int a=s.nextInt();
			int b=s.nextInt();
			if(map.containsKey(a)) {
				map.get(a).add(b);
				if(map.containsKey(b)) {
					map.get(b).add(a);
				}else {
					List<Integer> la=new LinkedList<>();
					map.put(b, la);
				}
			}else if(map.containsKey(b)) {
				map.get(b).add(a);
				if(map.containsKey(a)) {
					map.get(a).add(b);
				}else {
					List<Integer> lb=new LinkedList<>();
					map.put(a, lb);
				}
			}else{
				List<Integer> la=new LinkedList<>();
				List<Integer> lb=new LinkedList<>();
				la.add(a);
				lb.add(b);
				map.put(a, lb);
				map.put(b, la);
			}
			
			t--;
		}
		int[] arr=new int[n+1];		
		List<Integer> ans=new LinkedList<>();
		List<Set<Integer>> listOfSet=new LinkedList<>();
		Set<Integer> keySet=map.keySet();
		if(keySet.size() >0) {
			for(Integer ver:keySet) {
				Set<Integer> graph=new TreeSet<>();
				if(arr[ver] != 1)
				{
					dfs(arr,map,ver,graph);
					listOfSet.add(graph);
				}
				
			}
		}
		for(Set<Integer> set:listOfSet) {
			if(set.size() >=k) {
			  Object[] list=set.toArray();
			  Integer val=(Integer)list[k-1];
			  ans.add(val);
			}
			
		}
		System.out.println(ans.size());
		ans.forEach((i)-> System.out.print(i+" "));
		

	}
	static void dfs(int[] arr,Map<Integer,List<Integer>> map,int cur,Set<Integer> set) {
		if(arr[cur]==1) {
			return ;
		}
		arr[cur]=1;
		set.add(cur);
		List<Integer> edges=map.get(cur);
		
		for(int i=0;i<edges.size();i++) {
			int e=edges.get(i);
			if(arr[e]==0) {
				dfs(arr,map,e,set);
			}
		}
		
	}

}
