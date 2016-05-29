/**
 * @author kevin
 * @create_time: 2016 May 16, 2016 11:18:24 AM
 * @package_name: kevin.threads.threadpool
 * @project_name: threads
 */
package kevin.threads.threadpool;

import java.util.concurrent.ThreadFactory;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class ThreadFactoryImpl implements ThreadFactory {

	static int id = 0;
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread t = new Thread(r,"t" + id++);
		//t.setDaemon(true);
		return t;
	}

}
