/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 1:39:57 PM
 * @package_name: kevin.threads.reentrantlock
 * @project_name: threads
 */
package kevin.threads.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Conditions {

	static class Run implements Runnable{
		static ReentrantLock reentrantLock = new ReentrantLock();
		static Condition condition = reentrantLock.newCondition();
		public void run(){
			reentrantLock.lock();
			try {
				condition.await();
				System.out.println(Thread.currentThread().getName() + " await!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " work end!");
			reentrantLock.unlock();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Run(),"t1");
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Run.reentrantLock.lock();
		Run.condition.signal();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Run.reentrantLock.unlock();
	}

}
