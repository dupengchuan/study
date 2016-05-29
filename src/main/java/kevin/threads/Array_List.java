/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 4:14:04 PM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

import java.util.Vector;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Array_List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = new AddThread();
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddThread.printListSize();
	}

}

class AddThread implements Runnable {
	//private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Vector<Integer> list = new Vector<Integer>();

	public void run() {
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
	}

	public static void printListSize() {
		System.out.println(list.size());
	}
}
