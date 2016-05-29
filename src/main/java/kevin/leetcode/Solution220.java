/**
 * @createtime: May 9, 2016 12:04:10 PM
 * @owner: kevin
 */
package kevin.leetcode;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution220 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		
		if(nums.length == 0 || k < 1 || t < 0){
			return false;
		}
		
		SortedSet<Long> set = new TreeSet<Long>();
		for(int i = 0; i < nums.length; i++){
			Set<Long> subSet = set.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
			if(!subSet.isEmpty()){
				return true;
			}
			if(i >= k){
				set.remove((long)nums[i-k]);
			}
			set.add((long)nums[i]);
		}
		return false;
    }
//	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {  
//        //input check  
//        if(k<1 || t<0 || nums==null || nums.length<2) return false;  
//          
//        SortedSet<Long> set = new TreeSet<Long>();  
//          
//        for(int j=0; j<nums.length; j++) {  
//            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
//            if(!subSet.isEmpty()) return true;  
//              
//            if(j>=k) {  
//                set.remove((long)nums[j-k]);  
//            }  
//            set.add((long)nums[j]);  
//        }  
//        return false;  
//    }  
	
	public static void main(String[] args){
		int[] data = new int[]{1,3,1};
		Solution220 solution = new Solution220();
		System.out.println(solution.containsNearbyAlmostDuplicate(data, 1, 1));
	}
}
