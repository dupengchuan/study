/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 11:42:49 AM
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
public class Interruptibly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Run1(),"t1");
		Thread t2 = new Thread(new Run2(),"t2");
		t1.start();
		t2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}

}

class Run1 implements Runnable{
	static ReentrantLock reentrantLock1 = new ReentrantLock();
	
	public void run(){
		try {
			System.out.println(Thread.currentThread().getName() + " start work!");
			
			reentrantLock1.lockInterruptibly();
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " get reentrantLock1");
			
			Run2.reentrantLock2.lockInterruptibly();
			System.out.println(Thread.currentThread().getName() + " get reentrantLock2");
			
			System.out.println(Thread.currentThread().getName() + " end!");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(Thread.currentThread().getName() + " is Interrupted!");
			//e.printStackTrace();
		}finally{
			if(Run2.reentrantLock2.isHeldByCurrentThread()){
				Run2.reentrantLock2.unlock();
			}
			if(reentrantLock1.isHeldByCurrentThread()){
				reentrantLock1.unlock();
			}
		}
	}
}

class Run2 implements Runnable{
	static ReentrantLock reentrantLock2 = new ReentrantLock();
	
	public void run(){
		try {
			System.out.println(Thread.currentThread().getName() + " start work!");
			
			reentrantLock2.lockInterruptibly();
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " get reentrantLock2");
			
			Run1.reentrantLock1.lockInterruptibly();
			System.out.println(Thread.currentThread().getName() + " get reentrantLock1");
			
			System.out.println(Thread.currentThread().getName() + " end!");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(Thread.currentThread().getName() + " is Interrupted!");
			//e.printStackTrace();
		}finally{
			if(Run1.reentrantLock1.isHeldByCurrentThread()){
				Run1.reentrantLock1.unlock();
			}
			if(reentrantLock2.isHeldByCurrentThread()){
				reentrantLock2.unlock();
			}
		}
	}
}
