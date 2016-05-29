/**
 * @createtime: May 9, 2016 9:02:48 AM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution137_1 {
	public int singleNumber(int[] nums){
		int one = 0;
		int two = 0;
		for(int i = 0; i < nums.length; i++){
			two |= nums[i] & one;
			one ^= nums[i];
			int three = one & two;
			one &= ~three;
			two &= ~three;
		}
		return one;
	}
}
