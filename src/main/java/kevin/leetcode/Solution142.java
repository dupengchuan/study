/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 10:17:39 AM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution142 {
	
	public ListNode detectCycle(ListNode head) {
		if(null == head){
			return null;
		}
        ListNode fast = head;
        ListNode slow = head;
        ListNode slow1 = head;
        while(true){
        	if(fast != null){
        		fast = fast.next;
        	}else{
        		return null;
        	}
        	if(fast != null){
        		fast = fast.next;
        	}else{
        		return null;
        	}
        	slow = slow.next;
        	if(slow == fast){
        		break;
        	}
        }
        
        while(true){
        	if(slow == slow1){
        		return slow;
        	}
        	slow = slow.next;
        	slow1 = slow1.next;
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
