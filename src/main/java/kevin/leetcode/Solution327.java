/**
 * @author kevin
 * @create_time: 2016 May 17, 2016 7:23:33 PM
 * @package_name: kevin.leetcode
 * @project_name: leetcode
 */
package kevin.leetcode;

/**
 * @author root
 * @copyright kevin
 * @version 1.1
 */
public class Solution327 {

	public int countRangeSum(int[] nums, int lower,int upper){
		if(null == nums || nums.length == 0){
			return 0;
		}
		
		long[] storage = new long[nums.length];
		int[] res = new int[1];
		res[0] = 0;
		storage[0] = nums[0];
		for(int i = 1; i < nums.length; i++){
			storage[i] = nums[i] + storage[i-1];
		}
		this.recurse(storage, 0, nums.length, lower, upper, res);
		return res[0];
	}
	
	private void recurse(long[] nums,int start,int end,int lower,int upper,int[] res){
		if(end <= start){
			return;
		}
		
		if(end == start){
			if(nums[start] >= lower && nums[start] <= upper){
				res[0]++;
			}
			return;
		}
		
		int mid = start + (end-start)/2;
		recurse(nums,start,mid,lower,upper,res);
		recurse(nums,mid,end,lower,upper,res);
		
		int l = mid;
		int r = mid;
		long[] temp = new long[end-start+1];
		int index = 0;
		int pos = mid;
		for(int i = start; i < mid; i++){
			while(l < end && lower + nums[i] > nums[l] ){
				l++;
			}
			while(r < end && upper + nums[i] >= nums[r]){
				r++;
			}
			while(pos < end && nums[pos] < nums[i]){
				temp[index++] = nums[pos++];
			}
			temp[index++] = nums[i];
			res[0] += (r-l);
		}
		while(pos < end){
			temp[index++] = nums[pos++];
		}
		System.arraycopy(temp, 0, nums, start, end-start);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[]{-2,5,-1};
		Solution327 solution = new Solution327();
		solution.countRangeSum(data, -2, 2);
	}

}
