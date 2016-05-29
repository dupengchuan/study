/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 4:40:34 PM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Hash_Map {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new PutThread(0));
		Thread t2 = new Thread(new PutThread(1));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PutThread.printSize();
	}

}

class PutThread implements Runnable{
	private static HashMap<Integer,String> map = new HashMap<Integer,String>();
	private int start;
	
	public PutThread(int start){
		this.start = start;
	}
	
	public void run(){
		for(int i = start; i < 1000; i += 2){
			map.put(i, Integer.toBinaryString(i));
		}
		ThreadLocal p;
	}
	
	public static void printSize(){
		System.out.println(map.size());
	}
}
