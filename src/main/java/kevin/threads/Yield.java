/**
 * @author kevin
 * @create_time: 2016 May 13, 2016 10:46:46 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Yield {
	
	private static class Thread1 extends Thread{
		private String name;
		
		public Thread1(String name){
			this.name = name;
		}
		
		public void run(){
			System.out.println(this.name + " started!");
			long count = 0;
			while(true){
				count++;
				if(count % 10000 == 0){
					System.out.println(this.name + " " + count);
					Thread.yield();
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		
		Thread1 t1 = new Thread1("t1");
		Thread1 t2 = new Thread1("t2");
		t1.start();
		t2.start();
	}

}
