/**
 * @author kevin
 * @create_time: 2016 May 13, 2016 10:32:07 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Join {
	private static class ThreadJoin extends Thread{
		private long count = 0;
		
		@Override
		public void run(){
			for(;count < 100000000; count++);
		}
		
		public void printCount(){
			System.out.println(count);
		}
	}
	
	public static void main(String[] args){
		ThreadJoin t1 = new ThreadJoin();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.printCount();
	}
}
