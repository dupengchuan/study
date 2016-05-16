/**
 * @author kevin
 * @create_time: 2016 May 16, 2016 9:32:00 AM
 * @package_name: kevin.threads.threadpool
 * @project_name: threads
 */
package kevin.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class executors {

	static class Run implements Runnable{
		public void run(){
			System.out.println(Thread.currentThread().getId() + ": " + 
					System.currentTimeMillis());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static class SecondsCount implements Runnable{
		private int count = 0;
		public void run(){
			System.out.println(count++);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = new Run();
		//ExecutorService executorService = Executors.newFixedThreadPool(5);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0; i < 20; i++){
			executorService.submit(run);
		}
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(new SecondsCount(), 0, 1, TimeUnit.SECONDS);
	}

}
