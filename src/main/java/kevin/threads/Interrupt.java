/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 11:24:38 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Interrupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new InterruptThread());
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}

}

class InterruptThread implements Runnable{
	public void run(){
		while(true){
			if(Thread.currentThread().isInterrupted()){
				System.out.println("The thread is interrupted!");
				Thread.interrupted();
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("InterruptedException!");
				Thread.currentThread().interrupt();
			}
		}
	}
}
