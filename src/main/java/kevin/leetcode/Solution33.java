/**
 * @createtime: May 8, 2016 3:16:15 PM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution33 {
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left)/2;
			if(nums[mid] == target){
				return mid;
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
		return -1;
    }
	
	public static void main(String[] args){
		int[] data = new int[]{4,5,6,7,0,1,2};
		Solution33 solution  = new Solution33();
		System.out.println(solution.search(data, 4));
		System.out.println(solution.search(data, 0));
		System.out.println(solution.search(data, 2));
		data = new int[]{5,1,2,3,4};
		System.out.println(solution.search(data, 1));
//		System.out.println(solution.search(data, 0));
//		System.out.println(solution.search(data, 2));
		
	}
}
