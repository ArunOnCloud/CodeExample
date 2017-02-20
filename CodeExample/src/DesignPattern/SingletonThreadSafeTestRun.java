package DesignPattern;

public class SingletonThreadSafeTestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=0;i<100000;i++)
        {
        	TestThread th=new TestThread();
        	Thread thread=new Thread(th);
        	 thread.start();
        }
	}
	
 

}
class TestThread implements Runnable {
	public void run() {
		try {
			Thread.sleep(10);
			SingletonThreadSafe instance=SingletonThreadSafe.getInstance();
			Thread.sleep(10);
			if(SingletonThreadSafe.i>1)
			System.out.println("i:"+SingletonThreadSafe.i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
