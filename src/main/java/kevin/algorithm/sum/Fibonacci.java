/**
 * @author kevin
 * @create_time: 2016 May 16, 2016 4:11:18 PM
 * @package_name: kevin.algorithm.sum
 * @project_name: algorithm
 */
package kevin.algorithm.sum;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Fibonacci {
	
	private static final class Task extends RecursiveTask<Integer>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final int n;
		public Task(int n){
			this.n = n;
		}
		/* (non-Javadoc)
		 * @see java.util.concurrent.RecursiveTask#compute()
		 */
		@Override
		public Integer compute(){
			if(n <= 1){
				return n;
			}
			Task t1 = new Task(n-1);
			t1.fork();
			Task t2 = new Task(n-2);
			return t2.compute() + t1.join();
		}
	}
	
	public Integer fibonacci1(int n){
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Task task = new Task(n);
		ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);
		try {
			return (Integer)forkJoinTask.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int fibonacci2(int n){
		if(n <= 1){
			return n;
		}
		return fibonacci2(n-1) + fibonacci2(n-2);
	}
}
