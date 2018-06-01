package interviewbit;

import java.util.*;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A=new ArrayList<Integer>();
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-4);
		//A.add(-1);
		//A.add(-1);
		ThreeSumClosest threeSumClosest=new ThreeSumClosest();
		
		int ans=threeSumClosest.threeSumClosest(A, 1);
		System.out.println(ans);
		

	}
	public int threeSumClosest(ArrayList<Integer> A, int B) {
        int min=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        List<Integer> list=new ArrayList<>(A.size());
        for(int i=0;i<A.size();i++)
        {
            list.add(A.get(i));
        }
        Collections.sort(list);
        
        System.out.println(list);
        System.out.println(A);
        for(int i=0;i<A.size();i++)
        {
            int a=A.get(i);
            for(int j=i+1;j<A.size();j++)
            {
                int sum=a+ A.get(j);
                System.out.println("find:"+(B-sum));
                int ind=Collections.binarySearch(list,(B-sum));
                System.out.println("ind:"+ind);
                if(ind<0)
                {
                    int ind1= -(ind+1) ;
                    int ind2=ind1-1;
                    if(ind1<A.size())
                    {
                    	sum=A.get(i)+A.get(j)+list.get(ind1);
                    	System.out.println("i:"+i+" j:"+j+" ind1 sum:"+sum);
	                    int temp=Math.abs(sum-B);
	                    if(temp<min)
	                    {
	                        s=sum;
	                        min=temp;
	                    }
                    }
                    if(ind2 <A.size())
                    {
                        sum=A.get(i)+A.get(j)+list.get(ind2);
                        System.out.println("i:"+i+" j:"+j+" ind2 sum:"+sum);
                        int  temp=Math.abs(sum-B);
                        if(temp<min)
                        {
                            s=sum;
                            min=temp;
                        }
                    }
                    
                }else
                {
                     sum=A.get(i)+A.get(j)+list.get(ind);
                     System.out.println("i:"+i+" j:"+j+" ind sum:"+sum);
                    int temp=Math.abs(sum-B);
                    if(temp<min)
                    {
                        s=sum;
                        min=temp;
                    }
                    
                }
                
                
                /*for(int k=j+1;k<A.size();k++)
                {
                    int sum=A.get(i)+A.get(j)+A.get(k);
                    int temp=Math.abs(sum-B);
                    if(temp<min)
                    {
                        s=sum;
                        min=temp;
                    }
                }*/
            }
        }
        return s;
    }


}
