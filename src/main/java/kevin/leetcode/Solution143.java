/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 9:43:49 AM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution143 {
	public void reorderList(ListNode head) {
        if(null == head){
        	return;
        }
        ListNode mid = this.getMidListNode(head);
        ListNode head1 = this.reverseList(mid);
        this.mergeList(head, head1);
        return;
    }
	
	private ListNode reverseList(ListNode head){
		if(null == head){
			return null;
		}
		ListNode pre = head;
		head = head.next;
		pre.next = null;
		while(head != null){
			ListNode temp = head;
			head = head.next;
			temp.next = pre;
			pre = temp;
		}
		return pre;
	}
	
	private void mergeList(ListNode l1,ListNode l2){
		boolean status = true;
		while(null != l1 && null != l2){
			if(status){
				// the order is very important
				ListNode temp = l1.next;
				l1.next = l2;
				l1 = temp;
			}else{
				// the order is very important
				ListNode temp = l2.next;
				l2.next = l1;
				l2 = temp;
			}
			status = !status;
		}
		return;
	}
	
	private ListNode getMidListNode(ListNode head){
		ListNode fast = head.next;
		ListNode slow = head.next;
		ListNode pre = head;
		boolean status = false;
		while(fast != null){
			fast = fast.next;
			if(status){
				pre = slow;
				slow = slow.next;
			}
			status = !status;
		}
		pre.next = null;
		return slow;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		Solution143 solution = new Solution143();
		solution.reorderList(head);
	}
}
