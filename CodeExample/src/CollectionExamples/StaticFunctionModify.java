package CollectionExamples;

import java.util.List;

public class StaticFunctionModify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a=12;
		System.out.println(a);
		//Custom.increment(a);
		CustomOne.increment(a);
		System.out.println(a);
		
		
		IncrementInteger incrementInteger=new IncrementIntegerImpl();
		incrementInteger.setData(10);
		System.out.println(incrementInteger.getData());
		CustomIncrement.increment(incrementInteger);
		System.out.println(incrementInteger.getData());

	}
	
	

}
class CustomOne
{
	public  static int increment(Integer a)
	{
	 return  ++a;	
	}
}
interface IncrementInteger{
	// Integer data=1;
	 public void increment(Integer a);
	 public void setData(Integer a);
	 public Integer getData();
}
class IncrementIntegerImpl implements IncrementInteger{
	Integer data;
	 public void increment(Integer a)
	 {
		 a++;
	 }
	 public void setData(Integer a)
	 {
		 data=a;
	 }
	 public Integer getData(){
		 return data;
	 }
}
class CustomIncrement {
	 public static void increment(IncrementInteger incrementInteger)
	 {
		Integer a= incrementInteger.getData();
		a++;
		incrementInteger.setData(a);
	 }
}

  class Custom {
	 public static void increment(List<Integer> list)
	 {
		 for(int i=0;i<list.size();i++)
		 {
			 Integer a=list.get(i);
			 a++;
		 }
	 }
 }
