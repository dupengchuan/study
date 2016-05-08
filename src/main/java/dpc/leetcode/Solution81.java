/**
 * @createtime: May 8, 2016 5:30:07 PM
 * @owner: kevin
 */
package dpc.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution81 {
	public boolean search(int[] nums,int target){
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(nums[mid] == target){
				return true;
			}
			if(nums[mid] > nums[left]){
				if(target >= nums[left] && target < nums[mid]){
					right = mid - 1;
				}else{
					left = mid + 1;
				}
			}else if (nums[mid] < nums[left]){
				if(target > nums[mid] && target <= nums[right]){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}else{
				left++;
			}
		}
		return false;
	}
}
