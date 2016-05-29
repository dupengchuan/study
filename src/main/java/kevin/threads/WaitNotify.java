/**
 * @author kevin
 * @create_time: 2016 May 13, 2016 9:08:37 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class WaitNotify {
	
	private static Object lock = new Object();
	
	private static class Run1 implements Runnable{
		public void run(){
			System.out.println(Thread.currentThread().getName() + " start!");
			synchronized(lock){
				try {
					System.out.println(Thread.currentThread().getName() + " wait!");
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " end!");
			}
		}
	}
	
	private static class Run2 implements Runnable {
		public void run(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " start!");
			synchronized(lock){
				System.out.println(Thread.currentThread().getName() + " end!");
				lock.notifyAll();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Run1(),"t1");
		Thread t2 = new Thread(new Run1(),"t2");
		Thread t3 = new Thread(new Run2(),"t3");
		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
	}

}
