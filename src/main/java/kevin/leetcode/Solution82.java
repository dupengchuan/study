/**
 * @createtime: May 8, 2016 5:41:45 PM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution82 {
	public ListNode deleteDuplicates(ListNode head) {
		
		if(null == head){
			return null;
		}
		
		ListNode res = new ListNode(0);
		ListNode tail = res;
		
		ListNode q = head;
		ListNode p = head.next;
		while (p != null) {
			if(p.val == q.val){
				while (p != null && p.val == q.val) {
					p = p.next;
				}
			}else{
				tail.next = q;
				tail = tail.next;
				tail.next = null;
			}
			q = p;
			if(p != null){
				p = p.next;
			}
		}
		
		if(q != null){
			tail.next = q;
			tail = tail.next;
			tail.next = null;
		}
		return res.next;
	}
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		Solution82 solution = new Solution82();
		head = solution.deleteDuplicates(head);
		while(head != null){
			System.out.println(head.val + " ");
			head = head.next;
		}
	}
}
