package Threading;

public class ThreadLocking extends Thread{
	@Override
	public void run(){
		System.out.println(" thread calls");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocking threadLock=new ThreadLocking();
	}

}
