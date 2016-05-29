/**
 * @author kevin
 * @create_time: 2016 May 17, 2016 6:27:48 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution315 {

	static class BinarySearchTree{
		BinarySearchTree left;
		BinarySearchTree right;
		int count = 0;
		int val;
		BinarySearchTree(int val){this.val = val;}
	}
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new LinkedList<Integer>();
        if(null == nums || nums.length == 0){
        	return list;
        }
        
        BinarySearchTree root = new BinarySearchTree(nums[nums.length-1]);
        list.add(0);
        for(int i = nums.length - 2; i > -1; i--){
        	list.add(0,insert(root,nums[i],0));
        }
        return list;
    }
	
	private int insert(BinarySearchTree root,int element,int count){
		if(element > root.val){
			if(root.right == null){
				root.right = new BinarySearchTree(element);
				return count + root.count + 1;
			}
			return insert(root.right,element,count+root.count + 1);
		}else{
			root.count++;
			if(root.left == null){
				root.left = new BinarySearchTree(element);
				return count;
			}
			return insert(root.left,element,count);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[]{2,0,1};
		Solution315 solution = new Solution315();
		List<Integer> list = solution.countSmaller(data);
		for(Integer i : list){
			System.out.println(i);
		}
	}

}
