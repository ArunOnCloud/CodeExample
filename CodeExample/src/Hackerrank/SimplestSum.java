package Hackerrank;

import java.util.*;
public class SimplestSum {
	static Long kMax=100003l;
	static long aMax=1000000000000000000l;
	static long bMax=1000000000000000000l;
	static long mod=1000000007l;
	static List<List<Long>> rangeArr=new ArrayList<List<Long>>(kMax.intValue());
	static List<List<Long>> indArr=new ArrayList<List<Long>>(kMax.intValue());
	static List<Pair> pairArr=new ArrayList<SimplestSum.Pair>(kMax.intValue());
	static class Pair{
		Long[][] table=null;
		Pair(int m,int n)
		{
			table=new Long[m][n];
		}
	}
	public static void preProcessing()
	{
		for(Long k=2l;k<kMax;k++)
	    {   
			long sum=0l;
			int ind=0;
			//long k=2;
			//System.out.println("afda");
			List<Long> list=new ArrayList<Long>(64);
			List<Long> listIndex=new ArrayList<Long>(64);
			for(long i=1;(i<(Long.MAX_VALUE/k) && i>0 );i++)
			{
				sum+=i;
				//rangeArr[k.intValue()][ind]=sum;
				listIndex.add(i);
				list.add(sum);
				if(sum>0)
				{
					//list.add(sum);
				}
				/*System.out.println("k:"+k);
				System.out.println("i:"+i);
				System.out.println("sum:"+sum);*/
				ind++;
				i*=k;
				if(i<0)
				{
					break;
				}
			}
			rangeArr.add(list);
			indArr.add(listIndex);
		}
		for(int k=0;k<rangeArr.size();k++)
		{
			List<Long> list=indArr.get(k);
			List<Long> listValue=rangeArr.get(k);
			Pair pair=new Pair(list.size(),list.size());
			for(int i=0;i<list.size();i++)
			{
				for(int j=i;j<list.size();j++)
				{
					Long value=simplestSumUtil(k+2,list.get(i),list.get(j));;
					//System.out.println("k:"+(k+2)+" i:"+list.get(i)+" j:"+list.get(j));
					//System.out.println(value);
					pair.table[i][j]=simplestSumUtil(k+2,list.get(i),list.get(j));
				}
			}
			pairArr.add(pair);
			
		}
		/*Pair pair=pairArr.get(0);
		for(int i=0;i<pair.table.length;i++)
		{
			for(int j=0;j<pair.table.length;j++)
			{
				System.out.print(pair.table[i][j]+ " ");
			}
			System.out.println();
		}*/
		//print(rangeArr);
		
	}
	static void print(List<List<Long>> list){
		for(int i=0;i<=kMax.intValue()-3;i++)
		{
			if(list.get(i).get(list.get(i).size()-1) <0)
			{
				System.out.println(list.get(i));
			}
		}
		System.out.println(list.get(0));
		System.out.println(indArr.get(0));
	}
	static Long find(List<Long> arr,Long a)
	{
		Long res=0l;
		Integer ind=Collections.binarySearch(arr, a);
		if(ind>=0)
		{
			res=(long)ind;
		}else
		{
			ind=-(ind+1);
			res=(long)ind;
			res--;
		}
		//System.out.println("res:"+res+" a:"+a);
		
		return res;
	}
	static Long simplestSumUtil(int k, Long a, Long b) {
        // Complete this function
		Long result=0l;
		List<Long> list=indArr.get(k-2);
		List<Long> listValue=rangeArr.get(k-2);
		Long n=(long)list.size();
		Long si=-1l;
		Long ei=-1l;
		Long ind=0l;
		/*while(ind<n)
		{
			long val=list.get(ind.intValue());
			//si=ind;
			if(val<=a)
			{
				si=ind;
				
			}else
			{
			   break;
			}
			ind++;
			
		}*/
		si=find(list,a);
		 ind=0l;
		/*while(ind<n)
		{
			long val=list.get(ind.intValue());
			if(val<=b)
			{
				ei=ind;
			}else
			{
				break;
			}
			ind++;
			
		}*/
		 ei=find(list,b);
		ind=si;
		Long prevInd=a;
		Long curInd=0l;
		if(list.get(si.intValue()) == a)
		{
			prevInd=a;
		}else
		{
			//prevInd=list.get(si.intValue());
			prevInd=a;
			ind++;
		}
		Long prev=0l;
		if(ind>0 && list.get(si.intValue()) != a)
		{
			prev=ind-1;
		}
		//System.out.println("prev:"+prev);
		while(ind <= ei)
		{
			Long val=listValue.get(prev.intValue());
			val=val%mod;
			 curInd=list.get(ind.intValue());
			result+= ((((curInd-prevInd)%mod)*val)%mod);
			result=result% mod;
			//System.out.println("result:"+result);
			prevInd=curInd;
			prev=ind;
			ind++;
		}
		
		if(curInd!= b)
		{
			Long val=listValue.get(prev.intValue());
			val=val%mod;
			result+= ((((b-prevInd+1)%mod)*val)%mod);
			result=result% mod;
		}else
		{
			Long val=listValue.get(prev.intValue());
			val=val%mod;
			result+= ((val)%mod);
			result=result% mod;
		}
		
		
		
		
		
		return result;
    }

	static int simplestSum(int k, Long a, Long b) {
        // Complete this function
		Long result=0l;
		List<Long> list=indArr.get(k-2);
		List<Long> listValue=rangeArr.get(k-2);
		Pair pair=pairArr.get(k-2);
		Long n=(long)list.size();
		Long si=-1l;
		Long ei=-1l;
		Long ind=0l;
		/*while(ind<n)
		{
			long val=list.get(ind.intValue());
			//si=ind;
			if(val<=a)
			{
				si=ind;
				
			}else
			{
			   break;
			}
			ind++;
			
		}*/
		si=find(list,a);
		 ind=0l;
		/*while(ind<n)
		{
			long val=list.get(ind.intValue());
			if(val<=b)
			{
				ei=ind;
			}else
			{
				break;
			}
			ind++;
			
		}*/
		 ei=find(list,b);
		ind=si;
		Long prevInd=a;
		Long curInd=0l;
		if(list.get(si.intValue()) == a)
		{
			prevInd=a;
		}else
		{
			//prevInd=list.get(si.intValue());
			prevInd=a;
			ind++;
		}
		Long prev=0l;
		if(ind>0 && list.get(si.intValue()) != a)
		{
			prev=ind-1;
		}
		//System.out.println("prev:"+prev);
		/*while(ind <= ei)
		{
			Long val=listValue.get(prev.intValue());
			val=val%mod;
			 curInd=list.get(ind.intValue());
			result+= ((((curInd-prevInd)%mod)*val)%mod);
			result=result% mod;
			//System.out.println("result:"+result);
			prevInd=curInd;
			prev=ind;
			ind++;
		}*/
		
		result+=pair.table[ind.intValue()][ei.intValue()];
		if(ind!=si)
		{
		  Long	val=listValue.get(si.intValue());
		  Long temp=list.get(si.intValue());
		  result+= (((a-temp)%mod)*val)%mod;
		  result=result% mod;
		}
		//System.out.println("result:"+result);
		curInd=list.get(ei.intValue());
		prevInd=list.get(ei.intValue() );
		prev=ei;
		//System.out.println("curInd:"+curInd+" prevInd:"+prevInd+" prev:"+prev);
		if(curInd!= b)
		{
			Long val=listValue.get(prev.intValue());
			val=val%mod;
			result+= ((((b-prevInd)%mod)*val)%mod);
			result=result% mod;
		}else
		{
			/*Long val=listValue.get(prev.intValue());
			val=val%mod;
			result+= ((val)%mod);
			result=result% mod;*/
		}
		
		
		
		
		
		return result.intValue();
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Long time1=System.currentTimeMillis();
		//System.out.println("start time:"+System.currentTimeMillis());
		preProcessing();
		Long time2=System.currentTimeMillis();
		//System.out.println("start time:"+((time2-time1)/100));
		
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            long a = in.nextLong();
            long b = in.nextLong();
            int result = simplestSum(k, a, b);
            System.out.println(result);
        }
        in.close();
	}

}
