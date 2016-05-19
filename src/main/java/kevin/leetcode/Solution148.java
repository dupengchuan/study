/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 8:20:39 AM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution148 {
	public ListNode sortList(ListNode head) {
       if(null == head || null == head.next){
    	   return head;
       }
       ListNode mid = getMid(head);
       ListNode head1 = sortList(head);
       ListNode head2 = sortList(mid);
       return mergeList(head1,head2);
    }
	
	private ListNode mergeList(ListNode head1,ListNode head2){
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				tail.next = head1;
				head1 = head1.next;
			}else{
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		if(head1 != null){
			tail.next = head1;
		}
		if(head2 != null){
			tail.next = head2;
		}
		return head.next;
	}
	
	private ListNode getMid(ListNode head){
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		Solution148 solution = new Solution148();
		solution.sortList(head);
	}

}
