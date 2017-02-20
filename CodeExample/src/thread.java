class MyThread implements Runnable {
                String thrdName;
        /*Objects of MyThread can be run in
their own threads because MyThread
implements Runnable.
Chapter 11: Multithreaded Programming 375*/
          MyThread(String name) {
       thrdName = name;
       }
// Entry point of thread.
            public void run() {
                 System.out.println(thrdName + " starting.");
             try {
                 for(int count=0; count < 10; count++) {
                   Thread.sleep(400);
                   System.out.println("In " + thrdName +", count is " + count);
                     } 
                   }
                 catch(InterruptedException exc) {
                System.out.println(thrdName + " interrupted.");
                  }
                     System.out.println(thrdName + " terminating.");
               }
         }
class thread {
              public static void main(String args[]) {
            System.out.println("Main thread starting.");
              // First, construct a MyThread object.
             MyThread mt = new MyThread("Child #1");
             // Next, construct a thread from that object.
         Thread newThrd = new Thread(mt);
          // Finally, start execution of the thread.
         // note in output main thread and mythrea running concurrently
           newThrd.start();
           for(int i=0; i<50; i++) {
            System.out.print(". i="+i+",");
            try {
                Thread.sleep(100);
                String s=newThrd.getName();
                System.out.print(" thread name:"+s+" ");
                }
             catch(InterruptedException exc) {
              System.out.println("Main thread interrupted.");
                  }
        }
         System.out.println("Main thread ending.");
            }
}
            
