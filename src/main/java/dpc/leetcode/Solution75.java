/**
 * @createtime: May 8, 2016 8:41:16 PM
 * @owner: kevin
 */
package dpc.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution75 {
	public void sortColors(int[] nums) {
		
		for(int i = 0,j = i,k=nums.length-1; j <= k; j++){
			while (j <= k && (nums[j] == 0 || nums[j] == 2)) {
				if (nums[j] == 0) {
					if (i < j) {
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						i++;
					} else {
						j++;
					}
				} else {
					if (j < k) {
						int temp = nums[j];
						nums[j] = nums[k];
						nums[k] = temp;
						k--;
					} else {
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] data = new int[] { 1, 0 };
		Solution75 solution = new Solution75();
		solution.sortColors(data);
		for (int i : data) {
			System.out.println(i + " ");
		}
	}
}
