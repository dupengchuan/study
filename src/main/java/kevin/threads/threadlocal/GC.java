/**
 * @author kevin
 * @create_time: 2016 May 25, 2016 6:12:55 PM
 * @package_name: kevin.threads.threadlocal
 * @project_name: threads
 */
package kevin.threads.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class GC {

	static volatile ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
		@Override
		public void finalize() {
			System.out.println(Thread.currentThread().getId() + " is GC!");
		}
	};
	
	static volatile CountDownLatch countDownLatch = new CountDownLatch(10000);

	static class Run implements Runnable {
		int i;
		Run(int i){
			this.i = i;
		}
		
		public void run() {
			if (threadLocal.get() == null) {
				threadLocal.set(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					@Override
					public void finalize() {
						System.out.println(Thread.currentThread().getId() + " is GC!!!");
					}
				});
				System.out.println(Thread.currentThread().getName() + " create DataFormat!");
			}
			DateFormat dateFormat = threadLocal.get();
			try {
				countDownLatch.countDown();
				dateFormat.parse("2016-5-25 18:28:1");
			} catch (ParseException e) {
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
		countDownLatch = new CountDownLatch(10);
		for(int i = 0; i < 10; i++){
			Thread t = new Thread(new Run(i));
			t.start();
		}
		try {
			countDownLatch.await();
			System.gc();
			System.out.println("GC1!");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		countDownLatch = new CountDownLatch(10000);
		for (int i = 0; i < 10000; i++) {
			executorService.execute(new Run(i));
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//threadLocal = null;
		System.out.println("GC2!");
		//executorService.shutdown();
		//threadLocal.remove();
		System.gc();
	}

}
