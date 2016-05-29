/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 2:37:56 PM
 * @package_name: kevin.threads.otherlock
 * @project_name: threads
 */
package kevin.threads.otherlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class ReadWriteLockTest {
	
	static CountDownLatch countDownLatch = new CountDownLatch(20);
	static ReentrantLock commonLock = new ReentrantLock();
	static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	static Lock readLock = reentrantReadWriteLock.readLock();
	static Lock writeLock = reentrantReadWriteLock.writeLock();
	
	private static void func(Lock lock){
		lock.lock();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.unlock();
		countDownLatch.countDown();
	}
	
	static class Read implements Runnable{
		public void run(){
			//read
			func(readLock);
			//func(commonLock);
		}
	}
	
	static class Write implements Runnable{
		public void run(){
			//read
			func(writeLock);
			//func(commonLock);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable read = new Read();
		Runnable write = new Write();
		long start = System.currentTimeMillis();
		for(int i = 0; i < 20; i++){
			Thread t = null;
			if(i < 18){
				t = new Thread(read);
			}else{
				t = new Thread(write);
			}
			t.start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - start);
	}

}
