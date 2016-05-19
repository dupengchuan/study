/**
 * @author kevin
 * @create_time: 2016 May 18, 2016 4:36:52 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution109 {
	
	static ListNode currentHead = null;
	public TreeNode sortedListToBST(ListNode head){
		if(null == head){
			return null;
		}
		currentHead = head;
		int len = 0;
		while(head != null){
			head = head.next;
			len++;
		}
		return this.buildTree(0, len-1);
	}
	
	private TreeNode buildTree(int start,int end){
		if(start > end){
			return null;
		}
		int mid = start + (end - start)/2;
		TreeNode left = buildTree(start,mid-1);
		TreeNode root = new TreeNode(currentHead.val);
		root.left = left;
		currentHead = currentHead.next;
		root.right = buildTree(mid+1,end);
		
		return root;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode p = head;
		int i = 2;
		while(i < 11){
			p.next = new ListNode(i);
			p = p.next;
			i++;
		}
		Solution109 solution = new Solution109();
		solution.sortedListToBST(head);
	}

}
