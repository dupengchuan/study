/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 9:07:52 AM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution147 {
	public ListNode insertionSortList(ListNode head) {
        if(null == head || null == head.next){
        	return head;
        }
        ListNode head1 = new ListNode(Integer.MIN_VALUE);
        head1.next = head;
        head = head.next;
        head1.next.next = null;
        while(head != null){
        	// the order is very important
        	ListNode temp = head;
        	head = head.next;
        	this.insert(head1, temp);
        }
        return head1.next;
    }
	
	private void insert(ListNode head,ListNode element){
		ListNode pre = head;
		ListNode p = pre.next;
		while(p != null){
			if(p.val < element.val){
				pre = p;
				p = p.next;
			}else{
				break;
			}
		}
		pre.next = element;
		if(null != p){
			element.next = p;
		}else{
			element.next = null;
		}
		return;
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		Solution147 solution = new Solution147();
		solution.insertionSortList(head);
	}
}
