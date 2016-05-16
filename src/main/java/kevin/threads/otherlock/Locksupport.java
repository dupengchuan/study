/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 4:18:33 PM
 * @package_name: kevin.threads.otherlock
 * @project_name: threads
 */
package kevin.threads.otherlock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Locksupport {

	static class Run implements Runnable{
		private Object lock = new Object();
		public void run(){
			synchronized(lock){
				LockSupport.park(this);
				//if(Thread.currentThread().isInterrupted()){
				if(Thread.interrupted()){
					System.out.println(Thread.currentThread().getName() + " is interrupted!");
				}
				System.out.println(Thread.currentThread().getName() + " work end!");
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run run = new Run();
		Thread t1 = new Thread(run,"t1");
		Thread t2 = new Thread(run,"t2");
		t1.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.start();
		
		//LockSupport.unpark(t1);
		t1.interrupt();
		
		LockSupport.unpark(t2);
	}

}
