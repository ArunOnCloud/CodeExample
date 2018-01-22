package ThreadPooling;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolImpl {
	int capacity=0;
	Queue<Runnable> queue=new LinkedList<>();
	//LinkedBlockingQueue<Runnable> queue=new LinkedBlockingQueue<>();
	WorkerThread[] workerThreads=null;
	
	public ThreadPoolImpl(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity=capacity;
		workerThreads=new WorkerThread[this.capacity];
		for(int i=0;i<capacity;i++)
		{
			workerThreads[i]=new WorkerThread(i);
			workerThreads[i].start();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadPoolImpl threadPoolImpl=new ThreadPoolImpl(5);
		for(int i=0;i<100;i++)
		{
			
			threadPoolImpl.execute(new TaskThread(i));
		}
		

	}
	public void execute(Runnable task)
	{
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
		
	}
	private class WorkerThread extends Thread{
		int number=0;
		public WorkerThread(int i) {
			number=i;
		}
		
		
		public void run(){
			
			while(true){
				Runnable task;
				synchronized (queue) {
					while(queue.isEmpty())
					{
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					 task=queue.poll();
					/* System.out.print("worker thread:"+ number+" ");
						task.run();*/
					
				}
				System.out.print("worker thread:"+ number+" ");
				task.run();
				task=null;
				
				
				
			}
			
		}
		
	}

}
class TaskThread extends Thread{
	int ind=0;
	TaskThread(int i){
		ind=i;
	}
	public void run(){
		try {
			Thread.sleep(1000L);
			System.out.println("thread number :"+ind);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

