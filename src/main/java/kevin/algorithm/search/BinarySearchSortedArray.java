/**
 * @createtime: May 8, 2016 2:49:45 PM
 * @owner: kevin
 */
package kevin.algorithm.search;

import kevin.algorithm.interfaces.Search;
import kevin.util.AlgorithmName;

/**
 * @author kevin
 * @version 1.1
 */
public class BinarySearchSortedArray implements Search{

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.inter.Search#search(int[], int)
	 */
	public boolean search(int[] nums, int target) {
		int i = 0;
		int j = nums.length - 1;
		while(i <= j){
			int mid = i + (j - i)/2;
			if(nums[mid] < target){
				i = mid + 1; 
			}else if(nums[mid] > target){
				j = mid - 1;
			}else{
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.dpc.algorithm.interfaces.Search#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return AlgorithmName.BINARY_SEARCH_ARRAY;
	}

}
