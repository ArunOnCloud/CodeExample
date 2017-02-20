package DesignPattern;

public class TestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonClass instance=SingletonClass.getInstance();;
		System.out.println("i:"+SingletonClass.i);
		 instance=SingletonClass.getInstance();;
		System.out.println("i:"+SingletonClass.i);
		instance=SingletonClass.getInstance();
	    //instance=new SingletonClass(); //compiling error not visible constructor
		System.out.println("i:"+SingletonClass.i);

	}

}
