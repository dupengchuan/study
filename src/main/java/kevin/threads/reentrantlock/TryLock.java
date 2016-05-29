/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 12:39:52 PM
 * @package_name: kevin.threads.reentrantlock
 * @project_name: threads
 */
package kevin.threads.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class TryLock {
	static class Run1 implements Runnable{
		private static ReentrantLock reentrantLock = new ReentrantLock();
		public void run(){
			try {
				if(reentrantLock.tryLock(2,TimeUnit.SECONDS)){
					//TODO
					System.out.println(Thread.currentThread().getName() + " get lock!");
					Thread.sleep(3000);
					System.out.println(Thread.currentThread().getName() + " work end!");
				}else{
					System.out.println(Thread.currentThread().getName() + " does't get lock!");
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(reentrantLock.isHeldByCurrentThread()){
					reentrantLock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] args){
		Run1 run = new Run1();
		Thread t1 = new Thread(run,"t1");
		Thread t2 = new Thread(run,"t2");
		t1.start();
		t2.start();
	}
}


