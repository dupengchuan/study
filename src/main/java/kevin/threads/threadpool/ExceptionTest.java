/**
 * @author kevin
 * @create_time: 2016 May 16, 2016 3:00:27 PM
 * @package_name: kevin.threads.threadpool
 * @project_name: threads
 */
package kevin.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class ExceptionTest {

	static class DivTask implements Runnable{
		int a;
		int b;
		DivTask(int a,int b){
			this.a = a;
			this.b = b;
		}
		public void run(){
			System.out.println(a/b);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ExecutorService executorService = new ThreadPoolExecutor(5,5,0,TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),new ThreadFactoryImpl());
		ExecutorService executorService = new ThreadPoolExecutor(5,5,0,TimeUnit.SECONDS,new SynchronousQueue<Runnable>()){
			@Override
			public void execute(Runnable r){
				super.execute(this.wrap(r,clientTrace()));
			}
			
			@Override
			public Future<?> submit(Runnable r){
				return super.submit(wrap(r,clientTrace()));
			}
			
			private Runnable wrap(final Runnable r,final Exception c){
				return new Runnable(){
					public void run(){
						try{
							r.run();
						}catch(Exception e){
							//Exception e1 = new Exception("exception");
							c.printStackTrace();
							try {
								throw e;
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				};
			}
			
			private Exception clientTrace(){
				return new Exception("clent stack");
			}
		};
		for(int i = 0; i < 5; i++){
//			Future future = executorService.submit(new DivTask(100,i));
//			try {
//				future.get();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			executorService.execute(new DivTask(100,i));
		}
	}

}

