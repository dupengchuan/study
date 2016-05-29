/**
 * @author kevin
 * @create_time: 2016 May 25, 2016 7:40:12 PM
 * @package_name: kevin.threads.threadlocal
 * @project_name: threads
 */
package kevin.threads.threadlocal;

import java.util.concurrent.locks.LockSupport;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class GCTest {
	
	static class GC{
		public void finalize(){
			System.out.println(this.toString() + " is GC!");
		};
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GC gc = new GC();
		//GC gc1 = gc;
		gc = null;
		System.out.println("No GC");
		try {
			Thread.sleep(1000);
			System.gc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("GC!");
		LockSupport.park();
	}

}
