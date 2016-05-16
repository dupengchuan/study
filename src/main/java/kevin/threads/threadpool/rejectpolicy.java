/**
 * @author kevin
 * @create_time: 2016 May 16, 2016 10:53:08 AM
 * @package_name: kevin.threads.threadpool
 * @project_name: threads
 */
package kevin.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class rejectpolicy {
	
	static class policy implements RejectedExecutionHandler{

		/* (non-Javadoc)
		 * @see java.util.concurrent.RejectedExecutionHandler#rejectedExecution(java.lang.Runnable, java.util.concurrent.ThreadPoolExecutor)
		 */
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			// TODO Auto-generated method stub
			System.out.println(r.toString() + " is rejected!");
		}
		
	}
	
	static class Run implements Runnable{
		public String name;
		
		public Run(String name){
			this.name = name;
		}
		
		public void run(){
			try {
				System.out.println(Thread.currentThread().getName() + " work!");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		ExecutorService executorService = new ThreadPoolExecutor(5,6,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(5),new ThreadFactoryImpl()){
			@Override
			protected void beforeExecute(Thread t, Runnable r){
				System.out.println(t.getName() + " before work!");
			}
			
			@Override
			protected void afterExecute(Runnable r,Throwable t){
				System.out.println(((Run)r).name + ": after work!");
			}
			
			@Override
			protected void terminated(){
				System.out.println("executorService exit!");
			}
		};
		for(int i = 0; i < 10; i++){
			executorService.execute(new Run(i+""));
			Thread.sleep(100);
		}
		executorService.shutdown();
		
		//System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
