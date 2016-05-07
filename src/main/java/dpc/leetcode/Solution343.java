/**
 * @createtime: May 7, 2016 10:42:37 AM
 * @owner: kevin
 */
package dpc.leetcode;

/**
 * @author kevin
 * @version 1.1
 */
public class Solution343 {

    public int integerBreak(int n) {
        if(n % 3 == 0){
        	if(3 == n){
        		return 2;
        	}
        	return (int)Math.pow(3, n / 3);
        } else
        if(n % 3 == 1){
        	return (int)Math.pow(3, n / 3 - 1) * 4; 
        } else {
        	if(n == 2){
        		return 1;
        	}
        	return (int)Math.pow(3, n / 3) * 2;
        } 
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution343 solution = new Solution343();
		System.out.println(solution.integerBreak(2));
		System.out.println(solution.integerBreak(10));
	}

}
