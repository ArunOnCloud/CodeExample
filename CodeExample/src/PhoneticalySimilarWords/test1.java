package PhoneticalySimilarWords;
import java.util.*;
import java.util.LinkedList;
class listObject<T>{
	public List<T> data;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
public class test1 {
	
    public static void sortStringCloseToLengthGivenString(String[] arr,String str)
    {
    	int maxLength=1;
    	for(String val:arr)
    	{
    		if(val.length()>maxLength)
    			{
    			  maxLength=val.length();
    			}
    	}
    	listObject[] listArr=new listObject[maxLength];
    	for(int i=0;i<maxLength;i++)
    	{
    		listObject man=listArr[i];
    		((listArr[i])).setData((new LinkedList<String>()));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		Triple[] arr=new Triple[n];
		for(int i=0;i<n;i++)
			arr[i]=new Triple();
		arr[0].first=new Double(7.0);arr[0].second="man0";arr[0].third="city0";
		arr[1].first=new Double(8.0);arr[1].second="man1";arr[1].third="city1";
		arr[2].first=new Double(9.0);arr[2].second="man2";arr[2].third="city2";
		//int ind=binarySearch(arr,0,arr.length-1,8.0);
		//System.out.println("ind:"+ind);

	}

}
