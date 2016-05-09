/**
 * @createtime: May 8, 2016 11:02:56 PM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution136 {
	public int singleNumber(int[] nums) {
		int res = 0;
        for(int i = 0; i < nums.length; i++){
        	res ^= nums[i];
        }
        return res;
    }
}
