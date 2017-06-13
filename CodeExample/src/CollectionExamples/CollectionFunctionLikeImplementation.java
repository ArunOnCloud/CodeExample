package CollectionExamples;

public class CollectionFunctionLikeImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IncrementInt incrementInteger=new IncrementIntImpl();
		incrementInteger.setData(10);
		System.out.println(incrementInteger.getData());
		System.out.println(incrementInteger);
		CustomIncrementExample.increment(incrementInteger);
		System.out.println(incrementInteger);
		System.out.println(incrementInteger.getData());

	}
	
	

}

interface IncrementInt{
	// Integer data=1;
	 public void increment(Integer a);
	 public void setData(Integer a);
	 public Integer getData();
}
class IncrementIntImpl implements IncrementInt{
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
class CustomIncrementExample {
	 public static void increment(IncrementInt incrementInteger)
	 {
		Integer a= incrementInteger.getData();
		a++;
		incrementInteger.setData(a);
	 }
}
