/**
 * @createtime: May 9, 2016 8:29:18 AM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution268 {
	public int missingNumber(int[] nums){
		int res = (nums.length-1)*nums.length/2;
		for(int i = 0; i < nums.length; i++){
			res -= nums[i];
		}
		
		return res;
	}
	
	public static void main(String[] args){
		Solution268 solution = new Solution268();
		int[] data = new int[]{1,0};
		solution.missingNumber(data);
	}
}
