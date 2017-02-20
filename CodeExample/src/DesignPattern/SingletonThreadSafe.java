package DesignPattern;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonThreadSafe {
	private static SingletonThreadSafe instance;
	public static int i=0;
	//private static Lock lock=new LockImpl();
	private static Lock lock=new ReentrantLock();
	
	private SingletonThreadSafe(){
		System.out.println("constructor called");
		//i++;
	}
	public static SingletonThreadSafe getInstance(){
		if(instance==null)
		{
			lock.lock();
			try{
				if(instance == null)
				{
					instance=new SingletonThreadSafe();
				}
				//lock.unlock();
			}catch(Exception e)
			{
				e.printStackTrace();
			} finally
			{
				lock.unlock();
			}
			
			
			
			
		}
		return instance;
	}
	

}
class LockImpl implements Lock{

	  private boolean isLocked = false;

	  public synchronized void LockImpl(){
		  
	  }
	  

	  public synchronized void unlock(){
	    isLocked = false;
	    notify();
	  }

	@Override
	public synchronized void lock() {
	      while(isLocked){
		      try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		    isLocked = true;
		  }

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long paramLong, TimeUnit paramTimeUnit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
}
