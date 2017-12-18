package javaEight;

public class LambdaConcepts {
	
	public static void main(String[] args)
	{
		carryOutWork((i)-> {System.out.println("adff"+(i+1));
		System.out.println("given value:"+i);},1);
		//SimpleFuncInterface sfi=(i)-> System.out.println("adff"+(i+1));
		
		//Function<Integer,Integer> add1 = x -> x + 1;
		SimpleFunctionalInterfaceWith<Integer,Integer> add=(i,j)->{return(k)->{System.out.println("sum:"+(i+j));};}; 
		carryOutWork1(add.doWork(3, 4),1);
		//SimpleFunctionalInterfaceGen<Integer,Integer> add=(i,j)->{return i+j;}; 

		
		
	}
	public static void carryOutWork(SimpleFuncInterface sfi,int i){
	    sfi.doWork(i);
	  }
	public static void carryOutWork1(SimpleFunctionalInterfaceGen<Object> sfi,int i){
	    sfi.doWork(i);
	  }

}
@FunctionalInterface
interface SimpleFuncInterface {
  public void doWork(int i);
}
@FunctionalInterface
interface SimpleFunctionalInterfaceWith<T,V> {
  public SimpleFunctionalInterfaceGen<Object> doWork(T x,V y);
}

@FunctionalInterface
interface SimpleFunctionalInterfaceGen<T> {
	 public void doWork(T i);
}