/**
 * @author kevin
 * @create_time: 2016 May 13, 2016 9:39:13 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class SuspundResume {
	
	private static Object lock = new Object();
	
	private static class Thread1 extends Thread{
		String name;
		public Thread1(String name){
			this.name = name;
		}
		
		@SuppressWarnings("deprecation")
		@Override
		public void run(){
			System.out.println(this.name + " started!");
			synchronized(lock){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(this.name + " suspended!");
				Thread.currentThread().suspend();
			}
			System.out.println(this.name + " ended!");
		}
	}
	
	private static class Thread2 extends Thread{
		private String name;
		private boolean suspend = false;
		public Thread2(String name){
			this.name = name;
		}
		
		public void suspendme(){
			this.suspend = true;
		}
		
		public void resuMe(){
			this.suspend = false;
			synchronized(this){
				this.notify();
			}
		}
		
		@Override
		public void run(){
			while(true){
				System.out.println(this.name + " started!");
				synchronized(this){
					while(suspend){
						try {
							System.out.println(this.name + " suspended!");
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				System.out.println(this.name + " ended!");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread1 t1 = new Thread1("t1");
		t1.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.resume();
		
		Thread2 t2 = new Thread2("t2");
		t2.start();
		Thread.sleep(25000);
		t2.suspendme();
		Thread.sleep(25000);
		t2.resuMe();
	}
}
