/**
 * @createtime: May 8, 2016 8:03:16 PM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution61 {
	public ListNode rotateRight(ListNode head, int k) {
		
		if(head == null || k == 0){
			return head;
		}
		
		int l = 0;
		int len = 1;
		ListNode q = head;
		ListNode p = head;
		while(p.next != null){
			p = p.next;
			len++;
			if(l != k){
				l++;
			}else{
				q = q.next;
			}
		}
		if(len <= k){
			return rotateRight(head,k%len);
		}
		p.next = head;
		head = q.next;
		q.next = null;
		return head;
    }
	
	public static void main(String[] args){
		Solution61  solution = new Solution61();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head = solution.rotateRight(head, 1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
