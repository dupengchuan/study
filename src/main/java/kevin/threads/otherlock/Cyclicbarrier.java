/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 3:43:27 PM
 * @package_name: kevin.threads.otherlock
 * @project_name: threads
 */
package kevin.threads.otherlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Cyclicbarrier {

	static CyclicBarrier cyclicBarrier = new CyclicBarrier(10,new Run());
	
	static class Run implements Runnable{
		static boolean status = false;
		public void run(){
			if(status){
				System.out.println("work end!");
			}else{
				System.out.println("work start!");
				status = true;
			}
		}
	}
	
	static class Worker implements Runnable{
		public void run(){
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//do work
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = new Worker();
		for(int i = 0; i < 10; i++){
			new Thread(run).start();
		}
	}

}
