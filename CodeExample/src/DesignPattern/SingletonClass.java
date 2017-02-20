package DesignPattern;

public class SingletonClass {
	private static SingletonClass instance;
	public  static int i=0;
	private SingletonClass()
	{
		System.out.println(" constructor called");
		i++;
	}
	public static SingletonClass getInstance(){
		if(instance ==null)
		{
			instance=new SingletonClass();
			
		}
		return instance;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonClass singeltonClass=SingletonClass.getInstance();
		System.out.println("i:"+i);
		singeltonClass=SingletonClass.getInstance();
		System.out.println("i:"+i);
	    singeltonClass=SingletonClass.getInstance();
		//singeltonClass=new SingletonClass();
		System.out.println("i:"+i);
				//singeltonClass=new SingletonClass();
				System.out.println("i:"+i);

	}

}
