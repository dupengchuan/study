/**
 * @createtime: May 8, 2016 11:02:56 PM
 * @owner: kevin
 */
package dpc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution136 {
	public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if(set.contains(nums[i])){
        		set.remove(nums[i]);
        	}else{
        		set.add(nums[i]);
        	}
        }
        return set.iterator().next();
    }
}
