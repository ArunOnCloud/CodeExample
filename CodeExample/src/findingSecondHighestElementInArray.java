/*
 * author: Arun Kumar Ram
 * Date:16 june 2015
 * Assumption: Array should contain at least one element
 *             If all element of the array is same then highest element is returned
 */
public class findingSecondHighestElementInArray {
	public static int secondHighestElement(int[] a)
	   {
		   int highest=a[0];
		   for(int i=1;i<a.length;i++)
		   {
			   if(a[i]>highest)
			   {
				   highest=a[i];
			   }
		   }
		  int ans;
		  if(a[0]==highest)
		  {
			  for(int i=1;i<a.length;i++)
			  {
				  if(a[i]<highest)
				  {
					  ans=a[i];
					  break;
				  }
			  }
			  return highest;// when all elements are same then second highest is same
			  
		  }else
		  {
			  ans=a[0];
		  }
		  
		  for(int i=0;i<a.length;i++)
		  {
			  if(a[i]<highest && a[i]>ans)
			  {
				  ans=a[i];
			  }
		  }
		  return ans;
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// array must have one element
		//int[] a={1,-9,3,2,123,29};
		//int[] a={1,1,1,1,1,1};
		int[] a={98,87,123};
		//int[] a={9};
		int secondHighest=secondHighestElement(a);
		System.out.println("Second Highest Element:"+secondHighest);

	}
   
}
