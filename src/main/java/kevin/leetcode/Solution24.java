/**
 * @createtime: May 8, 2016 8:36:42 AM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution24 {
	public ListNode swapPairs(ListNode head) {
		
		//TODO
        if(null == head){
        	return null;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while(pre != null && next != null){
        	int temp = pre.val;
        	pre.val = next.val;
        	next.val = temp;
        	
        	pre = next.next;
        	
        	//TODO
        	if(null == pre){
        		break;
        	}else{
        		next = pre.next;
        	}
        }
        return head;
    }
}
