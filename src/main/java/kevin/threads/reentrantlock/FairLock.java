/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 1:22:57 PM
 * @package_name: kevin.threads.reentrantlock
 * @project_name: threads
 */
package kevin.threads.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class FairLock {

	static class Run implements Runnable{
		//ReentrantLock reentrantLock = new ReentrantLock(true);
		ReentrantLock reentrantLock = new ReentrantLock();
		public void run(){
			while(true){
				reentrantLock.lock();
				System.out.println(Thread.currentThread().getName() + " work!");
				reentrantLock.unlock();
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
		t2.start();
	}

}
