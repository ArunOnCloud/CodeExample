package Threading;

/*
FileName: ATEST16.java
The output of this example is as follows:
 Entered the testcase
 Synchronize to prevent access to shared data
 Create/start the thread
 Thread Thread-1: Entered
 Thread Thread-2: Entered
 Wait a bit until we're 'done' with the shared data
 Thread Thread-3: Entered
 Unlock shared data
 Thread Thread-1: Start critical section, in synchronized block
 Thread Thread-1: End critical section, leave synchronized block
 Thread Thread-2: Start critical section, in synchronized block
 Thread Thread-2: End critical section, leave synchronized block
 Thread Thread-3: Start critical section, in synchronized block
 Thread Thread-3: End critical section, leave synchronized block
 Wait for the threads to complete
 Testcase completed
*/
import java.lang.*;
 
 
public class ATEST16 {
   public final static int NUMTHREADS   = 3;
   public static int sharedData  = 0;
   public static int sharedData2 = 0;
   /* Any real java object or array would suit for synchronization          */
   /* We invent one here since we have two unique data items to synchronize */
   /* An in this simple example, they're not in an object                   */
   static class theLock extends Object {
   }
   static public theLock lockObject = new theLock();
 
   static class theThread extends Thread {
      public void run() {
         System.out.print("Thread " + getName() + ": Entered\n");
         synchronized (lockObject) {
            /********** Critical Section *******************/
            System.out.print("Thread " + getName() +
                             ": Start critical section, in synchronized block\n");
            ++sharedData; --sharedData2;
            System.out.print("Thread " + getName() +
                             ": End critical section, leave synchronized block\n");
            /********** Critical Section *******************/
         }
      }
   }
 
   public static void main(String argv[]) {
      theThread threads[] = new theThread[NUMTHREADS];
      System.out.print("Entered the testcase\n");
 
      System.out.print("Synchronize to prevent access to shared data\n");
      synchronized (lockObject) {
 
         System.out.print("Create/start the thread\n");
         for (int i=0; i<NUMTHREADS; ++i) {
         threads[i] = new theThread();
            threads[i].start();
         }
 
         System.out.print("Wait a bit until we're 'done' with the shared data\n");
         try {
            Thread.sleep(3000);
         }
         catch (InterruptedException e) {
            System.out.print("sleep interrupted\n");
         }
         System.out.print("Unlock shared data\n");
      }
 
      System.out.print("Wait for the threads to complete\n");
      for(int i=0; i <NUMTHREADS; ++i) {
    	  try{
      threads[i].join();
         }
         catch (InterruptedException e) {
            System.out.print("Join interrupted\n");
         }
      }
 
      System.out.print("Testcase completed\n");
      System.exit(0);
   }
 
}
      