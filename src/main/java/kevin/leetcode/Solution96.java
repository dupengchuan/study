/**
 * @createtime: May 9, 2016 9:42:13 AM
 * @owner: kevin
 */
package kevin.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution96 {
	
	//catalan 
	// h(n) = h(0)*h(n-1) + h(1)*h(n-1) + ... + h(n-1)*h(0)
	public int numTrees(int n){
		
		int[] nums = new int[n + 1];
		nums[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < i; j++){
				nums[i] += nums[j]*nums[i-j-1];
			}
		}
		
		return nums[n];
	}
	
	public static void main(String[] args){
		Solution96 solution = new Solution96();
		System.out.println(solution.numTrees(4));
	}
}
