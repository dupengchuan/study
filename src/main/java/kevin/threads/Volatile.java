/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 11:49:44 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Volatile {
	
	//private volatile static boolean status = false;
	private static boolean status = false;
	
	public static class ReadThread extends Thread{
		public void run(){
			while(!status);
			System.out.println("ReadThread end!");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// atomicity
		Thread[] threads = new Thread[10];
		for(int i = 0; i < 10; i++){
			threads[i] = new Thread(new PlusTask());
			threads[i].start();
		}
		for(int i = 0; i < 10; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PlusTask.printCount();
		
		// visibility
		Thread t2 = new Thread(new ViewTask());
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ViewTask.status = true;
		
		Thread t3 = new ReadThread();
		t3.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status = true;
		System.out.println(status);
	}

}

// atomicity
class PlusTask implements Runnable {
	private static volatile long count = 0;
	public void run(){
		for(int i = 0; i < 1000; i++){
			//count++;
			count = count + 1;
		}
	}
	
	public static void printCount(){
		System.out.println(count);
	}
}

// visibility
class ViewTask implements Runnable{
	public volatile static boolean status = false;
//	public static boolean status = false;
	
	public void run(){
		while(!status);
		System.out.println("ViewTask end!");
	}
}
