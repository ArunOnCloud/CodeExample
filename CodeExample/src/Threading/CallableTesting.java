package Threading;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;



public class CallableTesting {

	public static void main(String[] args) throws Exception, ExecutionException {
		// TODO Auto-generated method stub
		Callable<Integer> callable=new Callable<Integer>() {
			public Integer call() throws Exception {
				Thread.currentThread().sleep(1000l);
				for(int i=0;i<100;i++) {
					
				}
				return 1;
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Future<Integer> fut=executor.submit(callable);
		System.out.println("After asdkfjad value");
		
		//Optional<Integer> op=fut.get();
		System.out.println("Ending value:"+fut.get());
		
		
		System.out.println("After fut value");
		//Thread thread=new Thread(callable);
		
		FutureTask<Integer> ft=new FutureTask<>(callable);
		//System.out.println("finished:"+ft.get());
		Thread thread=new Thread(ft);
		thread.start();
		System.out.println("thread started");
		for(int i=0;i<100;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("after thread started finished:"+ft.get());
		System.out.println("after future called");
		for(int i=0;i<100;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("End of execution");
		
		
		
		

	}
	

}
