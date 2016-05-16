/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 10:37:45 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class AnonymousInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(){
			@Override
			public void run(){
				System.out.println("hello!,I am an  AnonymousInnerClass");
			}
		};
		//t1.start();
		t1.run();
	}

}
