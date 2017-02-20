package Hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


class Pair implements Comparator<Pair>,Comparable<Pair>{
	public Integer first;
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer second;
	
	 public int compare(Pair l, Pair r){
		 return l.first-l.second;
	 }
	 public boolean equals(Pair obj){
		  if(this.second==obj.second)
			  return true;
		  else
			  return false;
	 }
	 public int compareTo(Pair p){
		 return this.second-p.second;
	 }
}
public class ShortestReach {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//PrintWriter pw=new PrintWriter(new InputStreamReader(System.in));
		Integer big=999999999;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line;
		line=br.readLine();
		Integer t=Integer.parseInt(line);
		while(t>0){
			Integer n,m;
			line=br.readLine();
			String[] strArr=line.trim().split(" ");
			n=Integer.parseInt(strArr[0]);
			m=Integer.parseInt(strArr[1]);
			ArrayList< ArrayList<Integer> > list=new ArrayList< ArrayList<Integer> >();
			for(int i=0;i<n;i++)
			{
				ArrayList<Integer> lis=new ArrayList<Integer>();
				lis.ensureCapacity(n);
				list.add(lis);
			}
			list.ensureCapacity(n);
			for(int i=0;i<m;i++)
			{
				line=br.readLine();
				strArr=line.trim().split(" ");
				int a,b;
				a=Integer.parseInt(strArr[0]);
				b=Integer.parseInt(strArr[1]);
				list.get(a-1).add(b-1);
				list.get(b-1).add(a-1);
			}
			line=br.readLine();
			int s=Integer.parseInt(line.trim());
			Integer []arr=new Integer[n];
			boolean []check=new boolean[n];
			boolean []ch=new boolean[n];
			for(int i=0;i<n;i++)
			{
				check[i]=true;
				ch[i]=true;
				arr[i]=big;
			}
			int cur=s-1;
			arr[cur]=0;
			ch[cur]=true;
			PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
			Pair p=new Pair();
			p.first=cur;
			p.second=0;
			
			pq.add(p);
			while(!pq.isEmpty())
			{
				Pair temp=pq.element();
				cur=temp.first;
				int dist=temp.second;
				pq.remove();
				
				check[cur]=false;
				if(dist<arr[cur])
				{
					arr[cur]=dist;
				}
				for(int i=0;i<list.get(cur).size();i++)
				{
					int ind=list.get(cur).get(i);
					int newDist=dist+6;
					if(check[ind]==true){
						if(arr[ind]>newDist)
						{
							temp=new Pair();
							temp.first=ind;
							temp.second=newDist;
							arr[ind]=newDist;
							pq.add(temp);
						}
						if(ch[ind]==true)
						{
							temp=new Pair();
							temp.first=ind;
							temp.second=newDist;
							
							pq.add(temp);
							ch[ind]=false;
						}
					}
				}
				
			}
			for(int i=0;i<n;i++)
			{
				if(i!=s-1)
				{
					if(arr[i]==big)
						System.out.print(-1+" ");
					else
						System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			
			t--;
		}

	}

}
