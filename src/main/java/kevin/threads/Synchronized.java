/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 3:56:02 PM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Synchronized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable run = new ObjectLock();
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
		ObjectLock.printCount();
		
		Thread c1 = new Thread(new ClassLock());
		Thread c2 = new Thread(new ClassLock());
		c1.start();
		c2.start();
		try {
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClassLock.printCount();
	}

}

class ObjectLock implements Runnable {
	static int count = 0;
	public void run(){
		for(int i = 0; i < 1000; i++){
			synchronized(this){
				count++;
			}
		}
	}
	
	public static void printCount(){
		System.out.println(count);
	}
}

class ClassLock implements Runnable {
	static int count = 0;
	public void run(){
		for(int i = 0; i < 1000; i++){
			synchronized(ClassLock.class){
				count++;
			}
		}
	}
	
	public static void printCount(){
		System.out.println(count);
	}
}