/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 7:12:04 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(null == head || m == n){
        	return head;
        }
        int count = 1;
        ListNode head1 = new ListNode(0);
        ListNode tail = head1;
        ListNode pre = head1;
        ListNode tail2 = null;
        tail.next = head;
        ListNode p = head;
        while(count < m){
        	pre = p;
    		p = p.next;
    		count++;
        }
        tail = pre;
		pre = p;
		p = p.next;
		pre.next = null;
		tail2 = pre;
		ListNode temp = null;
		count++;
		while(count <= n){
			temp = p;
    		p = p.next;
    		temp.next = pre;
    		pre = temp;
    		count++;
		}
		tail.next = temp;
		tail2.next = p;
        return head1.next;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		Solution92 solution = new Solution92();
		ListNode list = solution.reverseBetween(head, 1, 1);
		list.toString();
	}
}
