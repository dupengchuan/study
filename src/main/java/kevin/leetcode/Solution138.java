/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 4:00:40 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution138 {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(null == head){
			return null;
		}
		
		// copy
		RandomListNode p = head;
		while(p != null){
			p.next = this.clone(p);
			p = p.next.next;
		}
		
		// modify the pointer random
		p = head;
		RandomListNode q;
		while(p != null){
			q = p.next;
			if(q.random != null){
				q.random = q.random.next;
			}
			p = q.next;
		}
		
		// diconnect
		q = head;
		p = head.next;
		head = p;
		while(p != null){
			q.next = p.next;
			q = q.next;
			if(q == null){
				break;
			}
			p.next = q.next;
			p = p.next;
		}
		
		return head;
    }
	
	private RandomListNode clone(RandomListNode p){
		RandomListNode res = new RandomListNode(p.label);
		res.next = p.next;
		res.random = p.random;
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
