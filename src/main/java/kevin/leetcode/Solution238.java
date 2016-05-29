/**
 * @createtime: May 8, 2016 2:25:38 PM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution238 {

	public int[] productExceptSelf(int[] nums){
		int[] res = new int[nums.length];
		
		int count = 0;
		int pos = -1;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0){
				if(count == 0){
					pos = i;
					count ++;
				}else{
					return res;
				}
			}
		}
		
		if(count == 1){
			res[pos] = 1;
			for(int i = 0; i < pos; i++){
				res[pos] *= nums[i];
			}
			for(int i = pos + 1; i < nums.length; i++){
				res[pos] *= nums[i];
			}
			return res;
		}
		
		int product = 1;
		for(int i = 0; i < nums.length; i++){
			product *= nums[i];
		}
		for(int i = 0; i < nums.length; i++){
			res[i] = product / nums[i];
		}
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = new int[]{1,2,3,4};
		Solution238 solution = new Solution238();
		data =  solution.productExceptSelf(data);
		for(int d : data){
			System.out.println(d);
		}
	}

}
