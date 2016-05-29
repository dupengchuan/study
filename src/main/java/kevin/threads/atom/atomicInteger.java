/**
 * @author kevin
 * @create_time: 2016 May 25, 2016 9:57:01 PM
 * @package_name: kevin.threads.atom
 * @project_name: threads
 */
package kevin.threads.atom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class atomicInteger {
	static int count = 0;
	static class Run1 implements Runnable{
		public void run(){
			for(int i = 0; i < 100000000; i++){
				increment();
			}
		}
	}
	
	static synchronized void increment(){
		count++;
	}
	
	static AtomicInteger atom = new AtomicInteger(0);
	static class Run2 implements Runnable{
		public void run(){
			for(int i = 0; i < 100000000; i++){
				atom.incrementAndGet();
//				while(true){
//					int current = atom.get();
//					int expect = current + 1;
//					if(atom.compareAndSet(current,expect)){
//						break;
//					};
//				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Run1 run1 = new Run1();
		Thread[] t = new Thread[4];
		Long start = System.currentTimeMillis();
		for(int i = 0; i < 4; i++){
			t[i] = new Thread(run1);
			t[i].start();
		}
		try{
			for(int i = 0; i < 4; i++){
				t[i].join();
			}
		}catch (InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(count + " time: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		Run2 run2 = new Run2();
		for(int i = 0; i < 4; i++){
			t[i] = new Thread(run2);
			t[i].start();
		}
		try{
			for(int i = 0; i < 4; i++){
				t[i].join();
			}
		}catch (InterruptedException ie){
			ie.printStackTrace();
		}
		System.out.println(atom + " time: " + (System.currentTimeMillis() - start));
	}

}
