/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 12:59:26 PM
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
public class TryLockWithoutTime {

	static class Run1 implements Runnable{
		static ReentrantLock reentrantLock = new ReentrantLock();
		public void run(){
			while(true){
				if(!reentrantLock.tryLock()){
					continue;
				}
				//System.out.println(Thread.currentThread().getName() + " get own lock");
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!Run2.reentrantLock.tryLock()){
					reentrantLock.unlock();
					continue;
				}
				
				System.out.println(Thread.currentThread().getName() + " start work!");
				System.out.println(Thread.currentThread().getName() + " work end!");
				
				Run2.reentrantLock.unlock();
				reentrantLock.unlock();
				break;
			}
		}
	}
	
	static class Run2 implements Runnable{
		static ReentrantLock reentrantLock = new ReentrantLock();
		public void run(){
			while(true){
				if(!reentrantLock.tryLock()){
					continue;
				}
				//System.out.println(Thread.currentThread().getName() + " get own lock");
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!Run1.reentrantLock.tryLock()){
					reentrantLock.unlock();
					continue;
				}
				
				System.out.println(Thread.currentThread().getName() + " start work!");
				System.out.println(Thread.currentThread().getName() + " work end!");
				
				Run1.reentrantLock.unlock();
				reentrantLock.unlock();
				break;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Run1(), "t1");
		Thread t2 = new Thread(new Run2(), "t2");
		t1.start();
		t2.start();
	}

}
