/**
 * @createtime: May 9, 2016 8:50:44 AM
 * @owner: kevin
 */
package kevin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution144 {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        this.reversePreOrderTranversal(list, root);
		return list;
    }
	
	private void reversePreOrderTranversal(List<Integer> list,TreeNode p){
		if(p == null){
			return;
		}
		list.add(p.val);
		reversePreOrderTranversal(list,p.left);
		reversePreOrderTranversal(list,p.right);
	}
}
