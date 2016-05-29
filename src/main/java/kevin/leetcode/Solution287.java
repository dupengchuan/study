/**
 * @createtime: May 9, 2016 11:41:36 AM
 * @owner: kevin
 */
package kevin.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution287 {
	public int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(set.contains(nums[i])){
        		return nums[i];
        	}else{
        		set.add(nums[i]);
        	}
        }
        return -1;
    }
}
