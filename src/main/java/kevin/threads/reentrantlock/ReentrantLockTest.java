/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 11:28:43 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class ReentrantLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLockThread run = new ReentrantLockThread();
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReentrantLockThread.printCount();
		
		
	}

}

class ReentrantLockThread implements Runnable{
	private static int count = 0;
	private static ReentrantLock reentrantLock = new ReentrantLock();
	public void run(){
		for(int i = 0; i < 100000; i++){
			reentrantLock.lock();
			count++;
			reentrantLock.unlock();
		}
	}
	
	public static void printCount(){
		System.out.println(count);
	}
}
