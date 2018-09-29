package Threading;

import java.util.concurrent.ThreadPoolExecutor;


public class ThreadLocking extends Thread{
	@Override
	public void run(){
		System.out.println(" thread calls");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor thre=null;
		//ThreadPool
		ThreadLocking threadLock=new ThreadLocking();
	}

}
