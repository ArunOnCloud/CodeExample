package practice;

import java.util.ArrayList;

public class ReferenceInSameScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a=5;
		Integer b=a;
		System.out.println("a:"+a);
		a++;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(12);
		arr.add(13);
		arr.add(15);
		//ArrayList<Integer> barr=(ArrayList<Integer>)arr.clone(); // with clone
		ArrayList<Integer> barr=arr; //without clone
		System.out.println(arr);
		barr.add(16);
		System.out.println(arr);
		System.out.println(barr);
		
		ModifyList(arr);
		
		System.out.println(arr);
		System.out.println(barr);
		
		System.out.println("-------------------------");
		CustomCollection customCollection=new CustomCollection();
		customCollection.arrayList.add(10);
		customCollection.arrayList.add(11);
		System.out.println(customCollection);
		modifyCustomCollection(customCollection);
		
		System.out.println(customCollection);
		
	}
	
	public static void ModifyList(ArrayList<Integer> list)
	{
		list.add(17);
	}
	
	public static void modifyCustomCollection(CustomCollection customCollection)
	{
		customCollection.arrayList.add(14);
	}

}


class CustomCollection{
	public  ArrayList<Integer> arrayList;
	public CustomCollection()
	{
		arrayList=new ArrayList<Integer>();
	}
	public String toString()
	{
		return arrayList.toString();
	}
	
}