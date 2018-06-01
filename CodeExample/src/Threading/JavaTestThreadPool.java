package Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaTestThreadPool {  
    public static void main(String[] args) {
    	
    	
    	
    	
       ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
       for (int i = 0; i < 100; i++) {  
           Runnable worker = new WorkerThread("" + i);  
           executor.execute(worker);//calling execute method of ExecutorService  
         }
       System.out.println("========Ending of pooling");
       executor.shutdown();  
       while (!executor.isTerminated()) { 
    	   //System.out.println("========isTerminate is called");  
       }  
 
       System.out.println("Finished all threads");  
   }  
}  