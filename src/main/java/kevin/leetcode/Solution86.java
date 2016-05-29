/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 8:24:21 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution86 {
	
	public ListNode partition(ListNode head, int x) {
		if(null == head){
			return null;
		}
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        ListNode tail1 = head1;
        ListNode tail2 = head2;
        while(head != null){
        	ListNode temp = head;
        	head = head.next;
        	if(temp.val < x){
        		tail1.next = temp;
        		tail1 = tail1.next;
        	}else{
        		tail2.next = temp;
        		tail2 = tail2.next;
        	}
        }
        tail1.next = head2.next;
        tail2.next = null;
        return head1.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
