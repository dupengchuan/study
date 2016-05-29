/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 2:56:50 PM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Thread_Group {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("make ThreadGroup");
		Runnable run = new ThreadN();
		Thread t1 = new Thread(tg, new Thread(run), "t1");
		Thread t2 = new Thread(tg, new Thread(run), "t2");
		Thread t3 = new Thread(tg, new Thread(run), "t3");
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int temp = tg.activeCount();
		while(true){
			int t = tg.activeCount();
			if(t == 0){
				System.out.println(0);
				break;
			}else{
				if(temp != t){
					System.out.println(temp);
					temp = t;
					tg.list();
				}
			}
		}
	}
}

class ThreadN implements Runnable {
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
