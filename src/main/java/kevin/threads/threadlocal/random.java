/**
 * @author kevin
 * @create_time: 2016 May 25, 2016 8:04:14 PM
 * @package_name: kevin.threads.threadlocal
 * @project_name: threads
 */
package kevin.threads.threadlocal;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class random {
	static final int NUM = 10000000;
	static final int ROUND = 1000;
	static final int TN = 4;
	static CyclicBarrier cyclicBarrier = new CyclicBarrier(TN,new run2());
	static ThreadLocal<Random> threadLocal = new ThreadLocal<Random>();
	static class Run1 implements Runnable{
		Random random;
		Run1(Random random){
			this.random = random;
		}
		public void run(){
			try {
				threadLocal.set(new Random(ROUND));
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i = 0; i < NUM; i++){
				random.nextInt();
			}
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < NUM; i++){
				threadLocal.get().nextInt();
			}
			
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	static long start = System.currentTimeMillis();
	static class run2 implements Runnable{
		public void run(){
			long now = System.currentTimeMillis();
			System.out.println(now - start);
			start = now;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random(ROUND);
		for(int i = 0; i < TN; i++){
			new Thread(new Run1(random)).start();
		}
	}

}
