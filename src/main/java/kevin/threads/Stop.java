/**
 * @author kevin
 * @create_time: 2016 May 14, 2016 10:59:23 AM
 * @package_name: kevin.threads
 * @project_name: threads
 */
package kevin.threads;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Stop {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u = new User(0,"0");
		Thread read = new Thread(new read(u));
		read.start();
		while(true){
			Thread write = new Thread(new write(u));
			write.start();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			write.stop();
		}
	}

}

class User{
	int id;
	String name;
	User(int id,String name){this.id = id;this.name = name;}
	
	public String toString(){
		return "id: " + id + " name: " + name;
	}
}

class read implements Runnable{
	private User u;
	public read(User u){
		this.u = u;
	}
	
	public void run(){
		while(true){
			synchronized(u){
				if(u.id != Integer.parseInt(u.name)){
					System.out.println(u.toString());
				}
			}
		}
	}
}

class write implements Runnable{
	private User u;
	public write(User u){
		this.u = u;
	}
	
	public void run(){
		synchronized(u){
			u.id += 1;
			u.name = u.id + "";
		}
	}
}
