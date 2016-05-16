/**
 * @author kevin
 * @create_time: 2016 May 15, 2016 2:21:00 PM
 * @package_name: kevin.threads.otherlock
 * @project_name: threads
 */
package kevin.threads.otherlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class SemaphoreTest {
	
	static class Run implements Runnable{
		private final Semaphore semaphore = new Semaphore(5);
		public void run(){
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " work done!");
			semaphore.release();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		Run run = new Run();
		for(int i = 0; i < 20; i++){
			executorService.submit(run);
		}
	}

}
