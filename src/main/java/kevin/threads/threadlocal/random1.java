/**
 * @author kevin
 * @create_time: 2016 May 25, 2016 8:48:29 PM
 * @package_name: kevin.threads.threadlocal
 * @project_name: threads
 */
package kevin.threads.threadlocal;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class random1 {
	static final int NUM = 100000000;
	static final int ROUND = 1000;
	static final int NT = 4;
	
	static ThreadLocal<Random> threadLocal = new ThreadLocal<Random>(){
		@Override
		protected Random initialValue(){
			return new Random(ROUND);
		}
	};
	static class gen1 implements Callable<Long>{
		public Long call(){
			return getTime(threadLocal.get());
		}
	}
	
	static class gen2 implements Callable<Long>{
		static Random random = new Random(ROUND);
		public Long call(){
			return getTime(random);
		}
	}
	
	private static long getTime(Random random){
		long start = System.currentTimeMillis();
		for(int i = 0; i < NUM; i++){
			random.nextInt();
		}
		return System.currentTimeMillis() - start;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(NT);
		Future<Long>[] future = new Future[NT];
		for(int i = 0; i < NT; i++){
			future[i] = executorService.submit(new gen1());
		}
		int res = 0;
		for(int i = 0; i < NT; i++){
			try {
				res += future[i].get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				System.out.println(executorService.isTerminated());
				e.printStackTrace();
			}
		}
		System.out.println(res);
		
		for(int i = 0; i < NT; i++){
			future[i] = executorService.submit(new gen2());
		}
		res = 0;
		for(int i = 0; i < NT; i++){
			try {
				res += future[i].get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(res);
	}

}
