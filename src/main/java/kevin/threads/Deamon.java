/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 10:41:32 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Deamon {
	public static void main(String[] args){
		Thread t1 = new Thread(new Deamonable());
		t1.setDaemon(true);
		t1.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello, I am main!");
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Deamonable implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("hello, I am deamon!");
		}
	}
	
}
