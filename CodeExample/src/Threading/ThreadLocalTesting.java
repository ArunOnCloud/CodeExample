package Threading;

public class ThreadLocalTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ThreadLocalCustom threadLocalCustom=new ThreadLocalCustom();
		for(int i=0 ;i<5;i++) {
			Integer ind=i;
			Runnable runnable=()->{
				try {
					threadLocalCustom.runningMethod("Thread :"+ind);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			Thread thread=new Thread(runnable);
			System.out.println(thread.getId());
			System.out.println(Thread.currentThread().getId());
			thread.start();
			
		}

	}
	

}

class ThreadLocalCustom{
	
	ThreadLocal<String> threadLocal=new ThreadLocal<>();
	public void runningMethod(String value) throws InterruptedException {
		System.out.println("setting value in thread local:"+value);
		threadLocal.set(value);
		Thread.currentThread().sleep(500L);
		System.out.println("getValueFromThred for value:"+value+" :"+threadLocal.get());
		
	}
}
