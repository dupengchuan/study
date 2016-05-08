/**
 * @createtime: May 8, 2016 7:02:08 PM
 * @owner: kevin
 */
package dpc.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution80 {
	public int removeDuplicates(int[] nums) {
		return removeDuplicates(nums, 2);
	}

	public int removeDuplicates(int[] nums, int k) {
		
		if(nums.length < k){
			return nums.length;
		}
		
		int index = 1;
		for (int i = 1,count = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1] && count > k){
				continue;
			}
			count = nums[i] == nums[i - 1] ? count + 1 : 1;
			if (count <= k) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
}
