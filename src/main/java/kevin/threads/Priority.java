/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 3:25:18 PM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Priority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new PriorityThread("t1"),"t1");
		Thread t2 = new Thread(new PriorityThread("t2"),"t2");
		Thread t3 = new Thread(new PriorityThread("t3"),"t3");
		t1.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

}

class PriorityThread implements Runnable{
	private int count = 0;
	private String name;
	
	static Object obj = new Object();
	
	public PriorityThread(String name){
		this.name = name;
	}
	
	public void run(){
		while(true){
			synchronized(obj){
				count++;
				if(count == 1000000000){
					System.out.println(this.name + ": " + System.currentTimeMillis());
					break;
				}
			}
		}
	}
}
